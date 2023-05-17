package coding201;


import java.awt.Font;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.List;


public class matchRunner extends JPanel	 {
	
	public Hashtable<String, Athlete> player;
	public opposingTeam opposition;
	
	public ArrayList<String> listKeysOfTeam;
	public ArrayList<String> listKeysOfOpposition;
	public PlayerClub playerClub;
	mainFrame frame;

	private JTextArea textField;

	public matchRunner(PlayerClub player, opposingTeam opps, mainFrame frame) {
		this.playerClub = player;
		this.opposition = opps;
		this.frame = frame;
		
		 frame.setBounds(0,0, 1280, 720);
		 frame.setLayout(null);
		 

			setBounds(0,0, 1280, 720);
			setLayout(null);
			
			textField = new JTextArea();
			textField.setEditable(false);
			textField.setBounds(402, 148, 476, 423);
			add(textField);
			textField.setColumns(10);
			textField.setLineWrap(true);
			
			
			
			JLabel lblNewLabel = new JLabel("Match Between " + playerClub.name +  " & " + opps.name);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel.setBounds(402, 30, 476, 46);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("FInal Score");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(402, 624, 476, 53);
			add(lblNewLabel_1);
		 
		 
		 
		 playMatch();
	
		
	}
	
	
	public void playMatch()  {
		int minutespassed = 10;
		int myClubScore = 0;
		int oppScore = 0;
		
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
			List<String> listKeysOfTeam = new ArrayList<String>(playerClub.athleteList.keySet());
			String playerName = listKeysOfTeam.get(number);
			Athlete myPlayer = playerClub.athleteList.get(playerName);
			
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
					
						
					minutespassed += 10;
				
				}
			textField.setText(textField.getText()+ "\n Score = (" + opposition.name + " "+ oppScore + "-" + myClubScore + " " +  playerClub.name + ")");
			}
				
			
			
		System.out.println("Game has ended");
		
			
		}
		
	//implement timer every 3 seconds output text that is randomly selected from some prompts eg (todd vermeir is through on goal but [opposingplayer] prevents a goal with his superior defense
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
