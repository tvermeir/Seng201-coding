package coding201;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JButton;




public class clubSetup {
	public double difficultyMultiplier = 1;
	public int money = 100;
	Hashtable<String, Athlete> clubPlayersHashtable  = new Hashtable<>();
	mainFrame frame;
	public String clubName;
	JPanel clubPanel;
	
	public clubSetup() {
		
		
	}
	public void setupFrame(mainFrame frame, JPanel clubPanel) {
		 this.frame = frame;
		 this.clubPanel = clubPanel;
		 frame.setBounds(500, 500, 1280, 720);
		 frame.setLayout(null);
		 
		 frame.add(clubPanel);
		 clubPanel.setLayout(null);
		 JLabel titleLabel = new JLabel("Setup Your Club!");
		 titleLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		 titleLabel .setHorizontalAlignment(SwingConstants.CENTER);
		 titleLabel .setBounds(0, 0, 1280, 99);
		 clubPanel.add(titleLabel);
		 
		 getTextFromTextField();
	}
//	public String clubName() {
//		
//		
//		String clubName = myObj.nextLine();
//		
//		
//		
//		System.out.println("Type y to confirm and n to go back");
//		
//		String letterConfirmString = myObj.nextLine();
//		
//		if(letterConfirmString.equals("y")) {
//			System.out.println("You have chosen: " + clubName +" as your team name");
//			return clubName;
//		}
//		else {
//			clubName();
//		}
//		return clubName;
//		
//	}
	
	public double setDifficulty() {
		
		Scanner difficulty = new Scanner(System.in);
		//System.out.println("Please select a difficulty \nEasy \nNormal \nHard");
		String decision = difficulty.nextLine();
		
	
		if(decision.toLowerCase().equals("easy")) {
			difficultyMultiplier = 0.5;
			return difficultyMultiplier;
		}
		else if(decision.toLowerCase().equals("normal")) {
			difficultyMultiplier = 1.00;
			return difficultyMultiplier;
		}
		else if(decision.toLowerCase().equals("hard")) {
			difficultyMultiplier = 2.00;
			return difficultyMultiplier;
		}
		else {
			//System.out.println("\nPlease enter either Easy, Normal or Hard\n\n");
			setDifficulty();
		}
		
		return difficultyMultiplier;
	}

	public int getMoney() {
		if(difficultyMultiplier == 2.00) {
			money = 75;
			return money;
		}
		else if(difficultyMultiplier == 1.00) {
			money = 100;
			return money;
		}
		else if(difficultyMultiplier == 0.5) {
			money = 150;
			return money;
		}
		return money;
	}
	public Hashtable<String, Athlete> getPlayers(){
		AthleteDatabase newPlayers = new AthleteDatabase();
		
		int i = 0;
		
		while(i<4) {
			String athlete = newPlayers.makeAthleteString();
			Athlete athlete2 = newPlayers.makeAthlete(athlete);
			clubPlayersHashtable.put(athlete2.name, athlete2);
			i ++;
		}
		return clubPlayersHashtable;
		
	}
	
	/**
	 * Create the panel.
	 */
	;
	
	public String getTextFromTextField() {
			
		 
		
		 JTextField nameInput = new JTextField();
		 nameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		 nameInput.setBounds(551, 139, 173, 56);
		 clubPanel.add(nameInput);
		 
		 nameInput.setColumns(10);
		 
		 JLabel nameLabel = new JLabel("Please Enter Team Name Below");
		 nameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		 nameLabel.setBounds(483, 90, 320, 38);
		 nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 clubPanel.add(nameLabel);
		 
		 JButton submitButton = new JButton("Submit");
		 submitButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		clubName = nameInput.getText();
		 	}
		 });
		 submitButton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		 submitButton.setBounds(594, 216, 99, 48);
		 clubPanel.add(submitButton);
		 
		 
		 return clubName;
	}


	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
