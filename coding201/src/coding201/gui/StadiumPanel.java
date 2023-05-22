package coding201.gui;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;

import coding201.code.Athlete;
import coding201.code.AthleteDatabase;
import coding201.code.PlayerClub;
import coding201.code.Stadium;
import coding201.code.Store;
import coding201.code.opposingTeam;

import java.awt.Color;
import javax.swing.JButton;

import javax.swing.JRadioButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
/**
 * StadiumPanel
 * StadiumPanel is the JPanel which allows the user to select an opposition team and begin a match.
 * An opponent can be selected from 4 possible teams
 * Each week, the 4 possible opponents are refreshed with new random teams.
 * @version 1.0
 * @author tve21 & bro82
 */
public class StadiumPanel extends JPanel {
	opposingTeam currTeam;
	mainFrame frame;
	Stadium stadium;
	Store store;
	Integer bal;
	ArrayList<opposingTeam> oppsListTable = new ArrayList<opposingTeam>();
	ArrayList<Athlete> starterList = new ArrayList<Athlete>();
	ArrayList<Athlete> reserveList = new ArrayList<Athlete>();
	ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
	ArrayList<String> nameList = new ArrayList<String>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Create the panel.
	 */
	JPanel playerListPanel = new JPanel();
	JPanel reservePanel = new JPanel();
	PlayerClub club;
	
	public StadiumPanel(Stadium stadium, Store store, mainFrame frame) {
		this.frame = frame;
		this.stadium = stadium;
		this.club = stadium.club;
		this.store = store;
		
		/**
		 * Adds each item in the club's hashtables to a respective arrayList to make iteration possible.
		 */
		stadium.club.starterList.forEach((k, v) -> {
			starterList.add(v);   
		});
		
		stadium.club.reserveList.forEach((k, v) -> {
			reserveList.add(v);   
		});
		
		stadium.club.athleteList.forEach((k, v) -> {
			athleteList.add(v);   
		});
		
		stadium.club.starterList.forEach((k,v) -> {
			nameList.add(k);
		});
		
		/**
		 * Creates a list of all the possible opponent teams
		 */
	
		stadium.PossibleOpponents.forEach((k, v) -> {
			  oppsListTable.add(v);
//			  System.out.println(v.printAthleteList());
		});
		
		currTeam = oppsListTable.get(0);
		

		
		setLayout(null);
		setBounds(0, 0, 1280, 720);
		
		JLabel stadiumLabel = new JLabel("Stadium");
		stadiumLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 34));
		stadiumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stadiumLabel.setBounds(540, 21, 153, 33);
		add(stadiumLabel);
		
		JLabel teamNameLabel = new JLabel(stadium.club.name);
		teamNameLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		teamNameLabel.setBounds(142, 78, 298, 26);
		add(teamNameLabel);
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel oppName = new JLabel(currTeam.name);
		oppName.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		oppName.setBounds(806, 71, 261, 33);
		add(oppName);
		oppName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		playerPanel.setBounds(24, 115, 550, 431);
		add(playerPanel);
		playerPanel.setLayout(null);
		
		
		playerListPanel.setBounds(10, 36, 530, 177);
		playerPanel.add(playerListPanel);
		playerListPanel.setLayout(new GridLayout(0, 4, 0, 0));
		stadium.club.starterList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playerListPanel.add(athleteDisplay);   
		});
		
		JLabel starterLabel = new JLabel("Starting Lineup");
		starterLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		starterLabel.setBounds(10, 11, 134, 24);
		playerPanel.add(starterLabel);
		
		
		reservePanel.setBounds(10, 259, 530, 161);
		playerPanel.add(reservePanel);
		reservePanel.setLayout(new GridLayout(0, 4, 0, 0));
		stadium.club.reserveList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			reservePanel.add(athleteDisplay);   
		});
		
		
		JLabel reserveLabel = new JLabel("Reserves");
		reserveLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		reserveLabel.setBounds(10, 224, 134, 24);
		playerPanel.add(reserveLabel);
		
		
		JPanel oppPanel = new JPanel();
		oppPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		oppPanel.setBounds(653, 224, 550, 236);
		add(oppPanel);
		oppPanel.setLayout(null);
		
		JPanel oppListPanel = new JPanel();
		oppListPanel.setBounds(10, 36, 532, 177);
		oppPanel.add(oppListPanel);
		oppListPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Starting Lineup");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 11, 134, 24);
		oppPanel.add(lblNewLabel_1_1);
		
		currTeam.athleteList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			oppListPanel.add(athleteDisplay);   
		});
		
		
		JButton simulateButton = new JButton("SIMULATE MATCH");
		simulateButton.addActionListener(new ActionListener() {
			/**
			 * Checks if the club is elgible to start the match with the correct number of players and no injuries.
			 * Then initialises a matchRunner to begin the match
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				boolean canPlay = true;
				for (int i = 0; i < nameList.size(); i++) {
					Athlete athlete = stadium.club.starterList.get(nameList.get(i));
					if(athlete.stamina == 0 && count<1) {
						if (stadium.club.reserveList.size() == 0) {
							JOptionPane.showMessageDialog(frame,"One Player on your team is injured. Heal this player to start a match.");
						}
						else if (stadium.club.reserveList.size() > 0) {
							JOptionPane.showMessageDialog(frame,"One Player on your team is injured. Heal this player or swap them with a reserve who isn't injured to start a match.");
						}												
						count += 1;
						canPlay = false;
						break;
					}
					else if(athlete.stamina > 0) {
						canPlay = true;						
					}					
				}				
				if(stadium.club.starterList.size() == 4 && stadium.weeksToPlay > stadium.currWeek && canPlay == true) {															
					matchRunner runner = new matchRunner(stadium.club, currTeam, frame, stadium, store);
					frame.setContentPane(runner);
				}
				else if(stadium.club.starterList.size() < 4) {
					JOptionPane.showMessageDialog(frame, "In order to Start a Match the Club Requires 4 Starters");
				}
				else if(stadium.currWeek >= stadium.weeksToPlay) {
					JOptionPane.showMessageDialog(frame,"All weeks have passed! Game has ended");
					FinishPanel finishPanel = new FinishPanel(frame,stadium);
					frame.setContentPane(finishPanel);					
				}												
			}
		});
		simulateButton.setBounds(653, 557, 301, 23);
		add(simulateButton);
		
		JRadioButton opp1Button = new JRadioButton("Opponent 1");
		opp1Button.setVerticalTextPosition(SwingConstants.TOP);
		opp1Button.setHorizontalTextPosition(SwingConstants.CENTER);
		opp1Button.setSelected(true);
		buttonGroup.add(opp1Button);
		opp1Button.addActionListener(new ActionListener() {
			/**
			 * Selects opponent 1 as the current opposing team.
			 */
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(0);
				oppListPanel.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppListPanel.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		opp1Button.setHorizontalAlignment(SwingConstants.CENTER);
		opp1Button.setBounds(577, 132, 79, 33);
		add(opp1Button);
		
		JRadioButton opp2Button = new JRadioButton("Opponent 2");
		opp2Button.setVerticalTextPosition(SwingConstants.TOP);
		opp2Button.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonGroup.add(opp2Button);
		opp2Button.addActionListener(new ActionListener() {
			/**
			 * Selects opponent 2 as the current opposing team.
			 */
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(1);
				oppListPanel.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppListPanel.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		opp2Button.setHorizontalAlignment(SwingConstants.CENTER);
		opp2Button.setBounds(580, 222, 73, 37);
		add(opp2Button);
		
		JRadioButton opp3Button = new JRadioButton("Opponent 3");
		opp3Button.setVerticalTextPosition(SwingConstants.TOP);
		opp3Button.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonGroup.add(opp3Button);
		opp3Button.addActionListener(new ActionListener() {
			/**
			 * Selects opponent 3 as the current opposing team.
			 */
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(2);
				oppListPanel.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppListPanel.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		opp3Button.setHorizontalAlignment(SwingConstants.CENTER);
		
		opp3Button.setBounds(580, 325, 73, 38);
		add(opp3Button);
		
		JRadioButton opp4Button = new JRadioButton("Opponent 4");
		opp4Button.setHorizontalTextPosition(SwingConstants.CENTER);
		opp4Button.setVerticalTextPosition(SwingConstants.TOP);
		buttonGroup.add(opp4Button);
		opp4Button.addActionListener(new ActionListener() {
			/**
			 * Selects opponent 4 as the current opposing team.
			 */
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(3);
				oppListPanel.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppListPanel.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		opp4Button.setHorizontalAlignment(SwingConstants.CENTER);
		opp4Button.setBounds(580, 423, 73, 37);
		add(opp4Button);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			/**
			 * Takes the user back to the home panel.
			 */
			public void actionPerformed(ActionEvent e) {
				HomePanel home = new HomePanel(frame);
				home.setupPanel(stadium, store);				
			}
		});
		backButton.setBounds(24, 33, 89, 23);
		add(backButton);
		
		
		JLabel balancelbl = new JLabel("Balance: " + stadium.club.balance);
		balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		balancelbl.setBounds(1050, 33, 144, 23);
		add(balancelbl);
			
		JLabel weekLabel = new JLabel("Week " + stadium.currWeek + " / " + stadium.weeksToPlay);
		weekLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		weekLabel.setBounds(932, 33, 108, 23);
		add(weekLabel);
		
		JButton byeButton = new JButton("Skip Week");
		byeButton.addActionListener(new ActionListener() {
			/**
			 * Skips the current week, the opposition list of opposing teams is refreshed.
			 * All players in the starting lineup are revived back to 100 stamina.
			 * There is a chance for a random event to occur based on a random number.
			 * One player in the starting lineup can be selected for special extra training
			 */
			public void actionPerformed(ActionEvent e) {
				if(stadium.currWeek < stadium.weeksToPlay) {
					stadium.currWeek +=1;
					store.refreshStore();
					stadium.club.athleteList.forEach((k, v) -> {
						v.stamina = 100;
					});
					weekLabel.setText("Week " + stadium.currWeek + " / " + stadium.weeksToPlay);
					doRandomEvent();
					stadium.club.reShuffle();
					if (stadium.club.starterList.size() == 4) {
						String[] options = new String[] {starterList.get(0).name, starterList.get(1).name, starterList.get(2).name, starterList.get(3).name};
					    int response = JOptionPane.showOptionDialog(frame, "Select a starter who will receive special training this week", "Special Training",
					        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					        null, options, options[0]);
						ArrayList<String> starterList2 = selectedTraining(stadium, response);
						JOptionPane.showMessageDialog(frame, stadium.club.athleteList.get(starterList2.get(response)).name + " has had their defense and attack boosted by 20 points.");
					}
					
					stadium.PossibleOpponents.clear();
					stadium.fillOpponentTable();
					frame.revalidate();
					
					if (!stadium.checkEnd(store)) {
						HomePanel home = new HomePanel(frame);
						home.setupPanel(stadium, store);
					}
					
				}

					
				else {
					JOptionPane.showMessageDialog(frame,"All weeks have passed! Game has ended");
					FinishPanel finishPanel = new FinishPanel(frame,stadium);
					frame.setContentPane(finishPanel);
					
				}
			}
		});
		byeButton.setBounds(273, 557, 301, 23);
		add(byeButton);

	}
	/**
	 * Selects a random player from the club and boosts their stats using the Athlete.booststat method.
	 */
	public void doBoostStatEvent() {
		Random random = new Random();
		int number = random.nextInt(stadium.club.athleteList.size()-1);
		
		Athlete currPlayer = athleteList.get(number);
		if(stadium.club.starterList.contains(currPlayer)) {
			Athlete boostedAthlete = stadium.club.starterList.get(currPlayer.name);
			boostedAthlete.boostStat();
			playerListPanel.removeAll();
			athleteList.remove(currPlayer);
			athleteList.add(boostedAthlete);
//			stadium.club.reShuffle();
			stadium.club.starterList.remove(currPlayer.name);
			stadium.club.starterList.put(currPlayer.name, boostedAthlete);
			
			starterList.clear();
			stadium.club.starterList.forEach((k, v) -> {
				starterList.add(v);   
			});
			
			starterList.forEach((v) -> {
				athleteDisplay athleteDisplay = new athleteDisplay(v);
				playerListPanel.add(athleteDisplay);   
			});
			StadiumPanel.this.revalidate();
			StadiumPanel.this.repaint();
		}
		else if(stadium.club.reserveList.contains(currPlayer)) {
			Athlete boostedAthlete = stadium.club.reserveList.get(currPlayer.name);
			boostedAthlete.boostStat();
			playerListPanel.removeAll();
			athleteList.remove(currPlayer);
			athleteList.add(boostedAthlete);
//			stadium.club.reShuffle();
			stadium.club.reserveList.remove(currPlayer.name);
			stadium.club.reserveList.put(currPlayer.name, boostedAthlete);
			
			reserveList.clear();
			stadium.club.reserveList.forEach((k, v) -> {
				reserveList.add(v);   
			});
			
			reserveList.forEach((v) -> {
				athleteDisplay athleteDisplay = new athleteDisplay(v);
				playerListPanel.add(athleteDisplay);   
			});
			StadiumPanel.this.revalidate();
			StadiumPanel.this.repaint();
		}
		JOptionPane.showMessageDialog(frame, currPlayer.name + " has had his stats boosted");
		
		
		
		
	}
	/**
	 * Makes a randomly selected athlete quit the team.
	 */

	public void doAthleteQuitEvent() {
		Random random = new Random();
		int number;
		if (athleteList.size() == 1) {
			number = random.nextInt(athleteList.size());
		}
		else {
			number = random.nextInt(athleteList.size()-1);
		}
		
		
		
		Athlete currPlayer = athleteList.get(number);
		
		if (stadium.club.starterList.contains(currPlayer)) {	

			stadium.club.starterList.remove(currPlayer.name);
			stadium.club.athleteList.remove(currPlayer.name);
			athleteList.remove(currPlayer);
			playerListPanel.removeAll();
			reservePanel.removeAll();
			stadium.club.reShuffle();
			reserveList.clear();
			stadium.club.reserveList.forEach((k, v) -> {
				reserveList.add(v);   
			});
			
			reserveList.forEach((v) -> {
				athleteDisplay athleteDisplay = new athleteDisplay(v);
				reservePanel.add(athleteDisplay);   
			});
			starterList.clear();
			stadium.club.starterList.forEach((k, v) -> {
				starterList.add(v);   
			});
			
			starterList.forEach((v) -> {
				athleteDisplay athleteDisplay = new athleteDisplay(v);
				playerListPanel.add(athleteDisplay);   
			});
			
			athleteList.clear();
			stadium.club.athleteList.forEach((k, v) -> {
				athleteList.add(v);   
			});
			
			
			StadiumPanel.this.revalidate();
			StadiumPanel.this.repaint();
			JOptionPane.showMessageDialog(frame, currPlayer.name + " has quit the team");
		}
		else if(stadium.club.reserveList.contains(currPlayer)) {
			System.out.println("true");
			stadium.club.reserveList.remove(currPlayer.name);
			stadium.club.athleteList.remove(currPlayer.name);
			athleteList.remove(currPlayer);
			reservePanel.removeAll();
			stadium.club.reShuffle();
			
			athleteList.clear();
			stadium.club.athleteList.forEach((k, v) -> {
				athleteList.add(v);   
			});
			StadiumPanel.this.revalidate();
			StadiumPanel.this.repaint();
			JOptionPane.showMessageDialog(frame, currPlayer.name + " has quit the team");
		}
		boolean lost = stadium.checkEnd(store);
		if (lost == true) {
			JOptionPane.showMessageDialog(frame,"Your team does not have enough players to play a match, and the club balance is too low to buy back to 4 players. Game over.");
			FinishPanel finishPanel = new FinishPanel(frame,stadium);
			frame.setContentPane(finishPanel);
			frame.revalidate();
		}
	}

	/**
	 * Makes a random new athlete join the team
	 */
	public void doRandomNewAthleteEvent() {
		AthleteDatabase athbase = new AthleteDatabase();
		String athString = athbase.makeAthleteString();
		Athlete newAthlete = athbase.makeAthlete(athString);
		stadium.club.reserveList.put(newAthlete.name, newAthlete);
		stadium.club.reShuffle();
		reservePanel.removeAll();
		
		reserveList.clear();
		stadium.club.reserveList.forEach((k, v) -> {
			reserveList.add(v);   
		});
		
		reserveList.forEach((v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			reservePanel.add(athleteDisplay);   
		});
		
		playerListPanel.removeAll();
		starterList.clear();
		stadium.club.starterList.forEach((k, v) -> {
			starterList.add(v);   
		});
		
		starterList.forEach((v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playerListPanel.add(athleteDisplay);   
		});
		
		
		StadiumPanel.this.revalidate();
		StadiumPanel.this.repaint();
		JOptionPane.showMessageDialog(frame, newAthlete.name + " has joined  the team");
		
		
	}
	/**
	 * Generates a random number to determine if and how a random event will occur in the current weekskip.
	 */

	public void doRandomEvent() {
		Random random = new Random();
		int number1 = random.nextInt(20);
//		int number1 = 9;
		if (number1 == 9) {
			this.doAthleteQuitEvent();
			stadium.club.reShuffle();
//			
		}
		else if (number1 == 4 && reserveList.size() == 3) {
			if(reserveList.size() <4){
				doRandomNewAthleteEvent();
			}
			else {
				JOptionPane.showMessageDialog(frame,"Week has been successfully skipped.");
			}
		}
		else if (number1 == 4 || number1 == 5 && reserveList.size() == 2) {
			if(reserveList.size() <4){
				doRandomNewAthleteEvent();
			}
			else {
				JOptionPane.showMessageDialog(frame,"Week has been successfully skipped.");
			}
		}
		else if (number1 == 4 || number1 == 5 || number1 == 6 && reserveList.size() == 1) {
			if(reserveList.size() <4){
				doRandomNewAthleteEvent();
			}
			else {
				JOptionPane.showMessageDialog(frame,"Week has been successfully skipped.");
			}
		}
		else if (number1 == 4 || number1 == 5 || number1 == 6 || number1 == 7 && reserveList.size() == 0) {
			if(reserveList.size() <4){
				doRandomNewAthleteEvent();
			}
			else {
				JOptionPane.showMessageDialog(frame,"Week has been successfully skipped.");
			}
		}
		
		else if (number1 <= 3 || number1 >= 18) {
			this.doBoostStatEvent();
		}
		
		
		else{
			JOptionPane.showMessageDialog(frame,"Week has been successfully skipped.");
		}
		

	}
	
	/**
	 * Takes the stadium and a number, and uses that number to select an athlete who gets their stats significantly boosted.
	 * This is done by calling the Athlete.boostStat() method 4 times.
	 * @param stadium
	 * @param num
	 */
	public ArrayList<String> selectedTraining(Stadium stadium, int num) {
		ArrayList<String> tempStarts = new ArrayList<String>();
		stadium.club.starterList.forEach((k, v) -> {
			tempStarts.add(k);
		});
		stadium.club.starterList.get(tempStarts.get(num)).boostStat();
		stadium.club.starterList.get(tempStarts.get(num)).boostStat();
		stadium.club.starterList.get(tempStarts.get(num)).boostStat();
		stadium.club.starterList.get(tempStarts.get(num)).boostStat();
		return tempStarts;
		
	}
}
