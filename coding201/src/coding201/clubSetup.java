package coding201;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;


import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;



public class clubSetup {
	public int money = 100;
	Hashtable<String, Athlete> clubPlayersHashtable  = new Hashtable<>();
	mainFrame frame;
	public String clubName;
	JPanel clubPanel;
	public String nameString;
	ButtonGroup difficultyButtons = new ButtonGroup();
	public String difficultyString;
	Stadium stadium;
	public int weeksToPlay;
	PlayerClub userClub;
	Store store;
	

	/**
	 * @wbp.parser.entryPoint
	 */
	public void setupFrame(mainFrame frame, JPanel clubPanel, Stadium stadium, PlayerClub userClub, Store store) {
		 this.frame = frame;
		 this.clubPanel = clubPanel;
		 this.stadium = stadium;
		 this.userClub = userClub;
		 this.store = store;
		 
		 frame.setBounds(0,0, 1280, 720);
		 frame.getContentPane().setLayout(null);
		 
		 frame.getContentPane().add(clubPanel);
		 clubPanel.setLayout(null);
		 JLabel titleLabel = new JLabel("Setup Your Club!");
		 titleLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		 titleLabel .setHorizontalAlignment(SwingConstants.CENTER);
		 titleLabel .setBounds(0, 0, 1280, 99);
		 clubPanel.add(titleLabel);
		 
		 getTextFromTextField();
	}
	public void setWeeksToPlay() {
		JPanel weeksPanel = new JPanel(); 
		weeksPanel.setLayout(null);	
		frame.setContentPane(weeksPanel);
		frame.revalidate();
		
		JLabel titleLabel = new JLabel("Select the Number of Weeks You Would Like to Play For");
		titleLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		titleLabel .setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel .setBounds(0, 0, 1280, 99);
		weeksPanel.add(titleLabel);
		
		JSlider weeksSelected = new JSlider(5,15,10);
		weeksSelected.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				userClub.weeksToPlay= weeksSelected.getValue();
				System.out.println(userClub.weeksToPlay);
		 			}
		});
		 		
		weeksSelected.setPaintLabels(true);
		weeksSelected.setPaintTicks(true);
		weeksSelected.setMinorTickSpacing(1);
		weeksSelected.setMajorTickSpacing(1);
		weeksSelected.setBounds(269, 337, 741, 45);
		weeksPanel.add(weeksSelected);
		 
		JButton continueButton = new JButton("Continue");
		 continueButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		HomePanel homePanel = new HomePanel(frame);
		 		homePanel.setupPanel(stadium, store);
		 	}
		 });
		 continueButton.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		 continueButton.setBounds(493, 524, 293, 79);
		 weeksPanel.add(continueButton);
		
		
	}
	public void setDifficulty() {
		JPanel difficultyFrame = new JPanel();
		
		difficultyFrame.setLayout(null);
		frame.setTitle(clubName);
		frame.setContentPane(difficultyFrame);
		frame.revalidate();
		
		
		
		JLabel setDifficultyLabel = new JLabel("Select a Difficulty");
		setDifficultyLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		setDifficultyLabel .setHorizontalAlignment(SwingConstants.CENTER);
		setDifficultyLabel .setBounds(0, 0, 1280, 99);
		
		difficultyFrame.add(setDifficultyLabel);
		 
		JRadioButton easyButton = new JRadioButton("Easy");
		easyButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		easyButton.setBounds(569, 197, 141, 23);
		difficultyFrame.add(easyButton);
		difficultyButtons.add(easyButton);
		 
		JRadioButton mediumButton = new JRadioButton("Medium");
		mediumButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		mediumButton.setBounds(569, 263, 141, 23);
		difficultyFrame.add(mediumButton);
		difficultyButtons.add(mediumButton);
		 
		JRadioButton hardButton = new JRadioButton("Hard");
		hardButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		hardButton.setBounds(569, 344, 141, 23);
		difficultyFrame.add(hardButton);
		difficultyButtons.add(hardButton);
		
		JButton confirmDifficultyButton = new JButton("Confirm Difficulty");
		 confirmDifficultyButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		difficultyString = getSelectedButton();
		 		if(difficultyString == null) {
		 			JOptionPane.showMessageDialog(frame, "Please Select a Difficulty");
		 		}
		 		else {
		 		setWeeksToPlay();
		 		}

		 		

		 		
		 	}
		 });
		 confirmDifficultyButton.setBackground(Color.WHITE);
		 confirmDifficultyButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		 confirmDifficultyButton.setBounds(508, 448, 264, 29);
		 difficultyFrame.add(confirmDifficultyButton);
		

		
	}
	
	String getSelectedButton()
	{  
	    for (Enumeration<AbstractButton> buttons = difficultyButtons.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = buttons.nextElement();
	        if (button.isSelected()) {
	                return button.getText();
	        }
	    }
	    return null;
	}
	
	
	public int getMoney() {
		if(difficultyString == "Hard") {
			money = 75;
			return money;
		}
		else if(difficultyString == "Medium") {
			money = 100;
			return money;
		}
		else if(difficultyString == "Easy") {
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
	
	public void getTextFromTextField() {
			
		 
		
		JTextField nameInput = new JTextField();
		 nameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		 nameInput.setBounds(553, 139, 173, 56);
		 clubPanel.add(nameInput);
		 
		 nameInput.setColumns(10);
		 
		 JLabel nameLabel = new JLabel("Please Enter Team Name Below");
		 nameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		 nameLabel.setBounds(480, 90, 320, 38);
		 nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 clubPanel.add(nameLabel);
		 
		 
		 JButton submitButton = new JButton("Submit");
		 
		 
		 submitButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		clubName = nameInput.getText();
			 		userClub.setName(clubName);
			 		
			 		if(clubName.length() == 0){
			 			JOptionPane.showMessageDialog(frame, "Please Enter a Name Longer Than 0 Characters");
			 		}
			 		else {
			 			setDifficulty();
			 		}
			 		//System.out.println(nameInput.getText());
			 	}
			 });
		 
		 
		 
		 submitButton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		 submitButton.setBounds(590, 336, 99, 48);
		 clubPanel.add(submitButton);
		
	}
		 
	
	

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
