package coding201;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.util.List;

/**
 * matchRunner
 *This class is where the matches are simulated. It takes in the opposing team and the player club>
 *It randomly selects two players, one from each team and checks if one's attack is greater than the other's defense
 *If it is true, a goal is scored. If false, it mvoes on to the next event
 *@version 1.0
 *@author tve21 & bro82
 */
public class matchRunner extends JPanel	 {
	
	public Hashtable<String, Athlete> player;
	public opposingTeam opposition;
	
	public ArrayList<String> listKeysOfTeam;
	public ArrayList<String> listKeysOfOpposition;
	public PlayerClub playerClub;
	mainFrame frame;
	Stadium stad;
	int myClubScore = 0;
	int oppScore = 0;
	Store store;
	private Boolean gameRunning =  true;

	private JTextArea textField;

	/**
	 *The constructor for the class takes in multiple parameters and creates the JPanel for the class
	 *@param playerclub,opposingTeam, mainFrame, Stadium, Store
	 */
	public matchRunner(PlayerClub player, opposingTeam opps, mainFrame frame, Stadium stad, Store store) {
		this.playerClub = player;
		this.opposition = opps;
		this.frame = frame;
		this.stad = stad;
		this.store = store;
		
		
		 listKeysOfTeam = new ArrayList<String>(playerClub.starterList.keySet());
		 listKeysOfOpposition = new ArrayList<String>(opposition.athleteList.keySet());
		
		 frame.setBounds(0,0, 1280, 720);
		 frame.setLayout(null);
		 

			setBounds(0,0, 1280, 720);
			setLayout(null);
			
			textField = new JTextArea();
			textField.setEditable(false);
			textField.setBounds(242, 71, 796, 630);
			
			add(textField);
			textField.setColumns(10);
			textField.setLineWrap(true);
			
			
			
			JLabel lblNewLabel = new JLabel("Match Between " + playerClub.name +  " & " + opps.name);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel.setBounds(346, 30, 571, 46);
			add(lblNewLabel);
			
			
		 
			
			
		 
		JScrollPane scroll = new JScrollPane (textField);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

		scroll.setBounds(254, 163, 689, 337);
		add(scroll);

		 
		 playMatch();
		 Boolean check = checkStamina(stad);
		 
		 JLabel scoreLabel = new JLabel("Final Score = (" + opposition.name + " "+ oppScore + "-" + myClubScore + " " +  playerClub.name + ")" );
			scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
			scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			scoreLabel.setBounds(338, 617, 587, 53);
			if(check) {
				add(scoreLabel);
			}
			
		 
		 JButton backButton = new JButton("Finish Simulation");
			backButton.addActionListener(new ActionListener() {
				/* The method here calculates who won and gives appropriate prize money to the user. 
				 * It also checks if the current weeks is less than the total weeks to play, to ensure 
				 * the user cannot play more weeks than intended
				 * If the whole team is injured during the match, it will end the game early and not
				 * return any prize money to the user*/
				public void actionPerformed(ActionEvent e) {
					
					HomePanel home = new HomePanel(frame);
					stad.currWeek +=1;
					if(check ==  true) {
						if(myClubScore > oppScore) {
							JOptionPane.showMessageDialog(frame, "Congrats, with that win " + stad.club.name + " just earned $50");
							stad.club.balance += 50;
							stad.numWins +=1;
						}
						else if(myClubScore == oppScore) {
							JOptionPane.showMessageDialog(frame, "With that tough draw " + stad.club.name + " just earned $25");
							stad.club.balance += 25;
							stad.numDraws += 1;
						}
						else if(myClubScore < oppScore) {
							JOptionPane.showMessageDialog(frame, "The fans booed the players and demand a refund, " + stad.club.name + " just lost $10");
							stad.club.balance -= 10;
							stad.numLosses += 1;
						}
						
						if(stad.currWeek < stad.weeksToPlay) {
						
							store.refreshStore();
							home.setupPanel(stad, store);
						}
						else {
							JOptionPane.showMessageDialog(frame,"All weeks have passed! Game has ended");
							FinishPanel finishPanel = new FinishPanel(frame,stad);
							frame.setContentPane(finishPanel);
						}
					}
					else if(check == false) {
						JOptionPane.showMessageDialog(frame,"As all your players got injured, no money is earned/lost");
						store.refreshStore();
						home.setupPanel(stad, store);
					}
				}
			});
			backButton.setBounds(10, 25, 150, 23);
			add(backButton);
			
		
		 
	}

	
	/**
	 * The method playMatch simulates the match. 
	 * It checks if the whole team is not injured, before checking the stats of one 
	 * random player vs another. If the team is on attack or defense, is also calculated by
	 * a random number.
	 * It repeats this process either 9 times, or if the whole team gets injured it ends the game early
	 */
	public void playMatch()  {
		int minutespassed = 10;
		
		
		Random random = new Random();
		
		otherEvents otherEvents = new otherEvents();
		goalEvents goalEvents = new goalEvents();
		List<String> otherEventsList = otherEvents.getList(); 
		List<String> goalEventsList = goalEvents.getList();
				
		textField.setText("Game Events: \n");
		
		while (minutespassed <= 90) {
			
			
			Boolean check = checkStamina(stad);
			int event = random.nextInt(2);
			
			int number = random.nextInt(4);
			
			Athlete myPlayer = playerClub.starterList.get(listKeysOfTeam.get(number));
			
			int number1 = random.nextInt(4);
		
			Athlete oppPlayer = opposition.athleteList.get(listKeysOfOpposition.get(number1));
			
			textField.setText(textField.getText()+ "\nMinutes: "+ minutespassed + ":00");
			minutespassed +=10;
			if(check ==false) {
				frame.remove(matchRunner.this);
				
				endEarly();
				break;
				
				
			}
			else if(check == true) {
				
					if(event == 0) {
						boolean working = true;
		
						while(working) {
							int attackRatingPlayer = myPlayer.getAttack();
							
							
							int defenseRatingOpps = oppPlayer.getDefense();
							
							if(attackRatingPlayer >= defenseRatingOpps) {
								int eventNumber = random.nextInt(goalEventsList.size());
								textField.setText(textField.getText()+ "\n" + myPlayer.name + " " + goalEventsList.get(eventNumber) + "\n");
								myClubScore +=1;
								working = false;
							
							}
							else {
								int eventNumber = random.nextInt(otherEventsList.size());
								textField.setText(textField.getText()+ "\n" +myPlayer.name + " " + otherEventsList.get(eventNumber) + "\n");
								working = false;
								
								}
							reduceStamina(myPlayer);
						}
							
							
						
						
					
					}
					
					if(event == 1) {
							boolean working = true;
							while(working) {
								int defenseRatingPlayer = myPlayer.getDefense();
								
								
								int attackRatingOpp = oppPlayer.getAttack();
								
								if(defenseRatingPlayer <= attackRatingOpp) {
									int eventNumber = random.nextInt(goalEventsList.size());
									textField.setText(textField.getText()+ "\n" +oppPlayer.name + " " + goalEventsList.get(eventNumber) + "\n" );
									oppScore+=1;
									working = false;
									
								}
								else {
									int eventNumber = random.nextInt(otherEventsList.size());
									textField.setText(textField.getText()+ "\n" +oppPlayer.name + " " + otherEventsList.get(eventNumber)+ "\n" );
									working = false;
									}
							}
							
							reduceStamina(myPlayer);
							
							
						}
						textField.setText(textField.getText()+ "\nScore = (" + opposition.name + " "+ oppScore + "-" + myClubScore + " " +  playerClub.name + ")");
					
						
						}
						
				
				
				
			}
			
			
				

			
		stad.PossibleOpponents.clear();
		stad.fillOpponentTable();
		
			
		}
		
	/*This method is called when all the players are injured, it is so the user is notified of what has happened. 
	 * 
	 */
	public void endEarly() {
		JOptionPane.showOptionDialog(new JFrame(), "Game was unable to be simulated as all your starters got injured midway through", "Game",
			JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			new Object[] { "Ok" }, JOptionPane.OK_OPTION);
		}
			
			
		
	/*This method is called when to check if all the players in the team have enough stamina left, otherwise
	 * the game is ended early. If one player has stamina, the game continues. 
	 */
	public Boolean checkStamina(Stadium stad) {
		Boolean yes = false;
		
		for(int i = 0; i < listKeysOfTeam.size(); i++) {
			Athlete player = stad.club.starterList.get(listKeysOfTeam.get(i));
			if(player.stamina > 0) {
				
				yes = true;
				
			}
		}
		return yes;		
	}
	/*The method here is used to reduce the stamina of a chosen player. Only if they are completing an action
	 */
	public void reduceStamina(Athlete myPlayer) {
		Random random = new Random();
		int number = 10 + random.nextInt(4);
		
		
		if(myPlayer.stamina - number >= 0) {
			myPlayer.stamina -= number;
		}
		else if(myPlayer.stamina - number < 0) {
			myPlayer.stamina = 0;
		}
	}
	
	
	public static void main(String[] args) {
		

	}

}
