package coding201;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.util.List;


public class matchRunner extends JPanel	 {
	
	public Hashtable<String, Athlete> player;
	public opposingTeam opposition;
	
	public ArrayList<String> listKeysOfTeam;
	public ArrayList<String> listKeysOfOpposition;
	public PlayerClub playerClub;
	mainFrame frame;
	Stadium stadium;
	int myClubScore = 0;
	int oppScore = 0;

	private JTextArea textField;

	public matchRunner(PlayerClub player, opposingTeam opps, mainFrame frame, Stadium stad, Store store) {
		this.playerClub = player;
		this.opposition = opps;
		this.frame = frame;
		this.stadium = stad;
		
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
	
		 JButton backButton = new JButton("Finish Simulation");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePanel home = new HomePanel(frame);
					stad.currWeek +=1;
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
					
					if(stadium.currWeek < stadium.weeksToPlay) {
					
						store.refreshStore();
						home.setupPanel(stad, store);
					}
					else {
						JOptionPane.showMessageDialog(frame,"All weeks have passed! Game has ended");
						FinishPanel finishPanel = new FinishPanel(frame,stad);
						frame.setContentPane(finishPanel);
					}
				}
			});
			backButton.setBounds(10, 25, 150, 23);
			add(backButton);
			
		JLabel scoreLabel = new JLabel("Final Score = (" + opposition.name + " "+ oppScore + "-" + myClubScore + " " +  playerClub.name + ")" );
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		scoreLabel.setBounds(338, 617, 587, 53);
		add(scoreLabel);
		 
	}

	
	
	public void playMatch()  {
		int minutespassed = 10;
		
		
		Random random = new Random();
		
		otherEvents otherEvents = new otherEvents();
		goalEvents goalEvents = new goalEvents();
		List<String> otherEventsList = otherEvents.getList(); 
		List<String> goalEventsList = goalEvents.getList();
		
//		textField.setText("Match begins between " + playerClub.name + " and " + opposition.name);
//		
//		textField.setText(textField.getText() + "\nHere is the starting lineup for " + playerClub.name);
//		System.out.println(playerClub.printAthleteList());
//		
//		textField.setText(textField.getText()+ "\nHere is the starting lineup for " + opposition.name);
//		System.out.println(opposition.printAthleteList());	
//		for (int i = 0; i < 3; i++) {
//			try {
//				  Thread.sleep(1000); 
//				} catch (Exception e) {
//				    e.printStackTrace();
//				}
//			textField.setText(textField.getText()+" \n Simulating game.......\n");
//			
//		}
//		
		textField.setText("Game Events: \n");
		
		while (minutespassed <= 90) {
			
			
			
			int event = random.nextInt(2);
			
			int number = random.nextInt(4);
			List<String> listKeysOfTeam = new ArrayList<String>(playerClub.starterList.keySet());
			String playerName = listKeysOfTeam.get(number);
			Athlete myPlayer = playerClub.starterList.get(playerName);
			
			int number1 = random.nextInt(4);
			List<String> listKeysOfOpposition = new ArrayList<String>(opposition.athleteList.keySet());
			String oppositionPlayer = listKeysOfOpposition.get(number1);
			Athlete oppPlayer = opposition.athleteList.get(oppositionPlayer);
			
			textField.setText(textField.getText()+ "\nMinutes: "+ minutespassed + ":00");
			
			if(event == 0) {
				boolean working = true;
					//Randomly selects a player by converting the hashtable keys into an array list, before getting the persons name and getting their attack stat 
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
					minutespassed += 10;
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
					minutespassed += 10;
				
				}
			textField.setText(textField.getText()+ "\nScore = (" + opposition.name + " "+ oppScore + "-" + myClubScore + " " +  playerClub.name + ")");
			}
				
			
			
		stadium.PossibleOpponents.remove(opposition.name);
		stadium.fillOpponentTable();
		
			
		}
		
	//implement timer every 3 seconds output text that is randomly selected from some prompts eg (todd vermeir is through on goal but [opposingplayer] prevents a goal with his superior defense
	
	
	
	
	
	public void reduceStamina(Athlete myPlayer) {
		if(myPlayer.stamina - 3 >= 0) {
			myPlayer.stamina -= 3;
		}
		else if(myPlayer.stamina - 3 < 0) {
			myPlayer.stamina = 0;
		}
	}
	
	
	public static void main(String[] args) {
		

	}

}
