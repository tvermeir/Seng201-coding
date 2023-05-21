package coding201;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

import javax.swing.JRadioButton;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;

public class StadiumPanel extends JPanel {
	opposingTeam currTeam;
	mainFrame frame;
	Stadium stadium;
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
	
	
	public StadiumPanel(Stadium stadium, Store store, mainFrame frame) {
		this.frame = frame;
		this.stadium = stadium;
		
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
		
		
		
		
		
		
        
		
		
	
		stadium.PossibleOpponents.forEach((k, v) -> {
			  oppsListTable.add(v);
//			  System.out.println(v.printAthleteList());
		});
		
		currTeam = oppsListTable.get(0);
		

		
		setLayout(null);
		setBounds(0, 0, 1280, 720);
		
		JLabel lblNewLabel = new JLabel("Stadium");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(540, 21, 153, 33);
		add(lblNewLabel);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Starting Lineup");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 11, 134, 24);
		playerPanel.add(lblNewLabel_1);
		
		
		reservePanel.setBounds(10, 259, 530, 161);
		playerPanel.add(reservePanel);
		reservePanel.setLayout(new GridLayout(0, 4, 0, 0));
		stadium.club.reserveList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			reservePanel.add(athleteDisplay);   
		});
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Reserves");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 224, 134, 24);
		playerPanel.add(lblNewLabel_1_2);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(653, 224, 550, 236);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel oppList = new JPanel();
		oppList.setBounds(10, 36, 532, 177);
		panel_1.add(oppList);
		oppList.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Starting Lineup");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 11, 134, 24);
		panel_1.add(lblNewLabel_1_1);
		
		currTeam.athleteList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			oppList.add(athleteDisplay);   
		});
		
		
		JButton btnNewButton = new JButton("SIMULATE MATCH");
		btnNewButton.addActionListener(new ActionListener() {



			public void actionPerformed(ActionEvent e) {
				int count = 0;
				boolean canPlay = true;
				if (stadium.club.starterList.size() < 4) {
					JOptionPane.showMessageDialog(frame, "In order to Start a Match the Club Requires 4 Starters");
				}
				else if(stadium.club.starterList.size() == 4) {
					for (int i = 0; i < nameList.size(); i++) {
						Athlete athlete = stadium.club.starterList.get(nameList.get(i));
						if(athlete.stamina <50 && count <1) {
							JOptionPane.showMessageDialog(frame,"One Player on your team does not have enough stamina, make sure it is greater than 50");
							count+=1;
							canPlay = false;
							break;
						}
						
						else if(athlete.stamina >= 50) {
							canPlay = true;
							
						}
					}
				}
				
				if(stadium.club.starterList.size() == 4 && stadium.weeksToPlay > stadium.currWeek && canPlay == true) {
					
					
					
					matchRunner runner = new matchRunner(stadium.club, currTeam, frame, stadium, store);
					frame.setContentPane(runner);
				}
				
				else if(stadium.currWeek >= stadium.weeksToPlay) {
						JOptionPane.showMessageDialog(frame,"All weeks have passed! Game has ended");
						FinishPanel finishPanel = new FinishPanel(frame,stadium);
						frame.setContentPane(finishPanel);
					
					}
				
				


				
			}
		});
		btnNewButton.setBounds(653, 557, 301, 23);
		add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Opponent 1");
		rdbtnNewRadioButton.setVerticalTextPosition(SwingConstants.TOP);
		rdbtnNewRadioButton.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(0);
				oppList.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(577, 132, 79, 33);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Opponent 2");
		rdbtnNewRadioButton_1.setVerticalTextPosition(SwingConstants.TOP);
		rdbtnNewRadioButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(1);
				oppList.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBounds(580, 222, 73, 37);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Opponent 3");
		rdbtnNewRadioButton_2.setVerticalTextPosition(SwingConstants.TOP);
		rdbtnNewRadioButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(2);
				oppList.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		rdbtnNewRadioButton_2.setBounds(580, 325, 73, 38);
		add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Opponent 4");
		rdbtnNewRadioButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtnNewRadioButton_3.setVerticalTextPosition(SwingConstants.TOP);
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(3);
				oppList.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_3.setBounds(580, 423, 73, 37);
		add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePanel home = new HomePanel(frame);

				home.setupPanel(stadium, store);

				
			}
		});
		btnNewButton_1.setBounds(24, 33, 89, 23);
		add(btnNewButton_1);
		
		
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
			public void actionPerformed(ActionEvent e) {
				if(stadium.currWeek < stadium.weeksToPlay) {
					stadium.currWeek +=1;
					weekLabel.setText("Week " + stadium.currWeek + " / " + stadium.weeksToPlay);
					doRandomEvent();
					frame.revalidate();
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
			stadium.club.reShuffle();
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
		}
		else if(stadium.club.reserveList.contains(currPlayer))
			System.out.println("true");
			stadium.club.reserveList.remove(currPlayer.name);
			stadium.club.athleteList.remove(currPlayer.name);
			athleteList.remove(currPlayer);
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
			athleteList.clear();
			stadium.club.athleteList.forEach((k, v) -> {
				athleteList.add(v);   
			});
			StadiumPanel.this.revalidate();
			StadiumPanel.this.repaint();
			JOptionPane.showMessageDialog(frame, currPlayer.name + " has quit the team");
	}

	public void doRandomNewAthleteEvent() {
		AthleteDatabase athbase = new AthleteDatabase();
		Athlete newAthlete = athbase.getAthlete();
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

	public void doRandomEvent() {
		Random random = new Random();
		int number1 = random.nextInt(10);
		
		if (number1 == 9) {
			this.doAthleteQuitEvent();
		}
		else if (number1 == 4) {
			if(reserveList.size() <4){
				this.doRandomNewAthleteEvent();
			}
			else {
				JOptionPane.showMessageDialog(frame,"Week has been successfully skipped.");
			}
		}
		else if (number1 <= 2) {
			this.doBoostStatEvent();
		}
		
		
		else{
			JOptionPane.showMessageDialog(frame,"Week has been successfully skipped.");
		}
		

	}
}
