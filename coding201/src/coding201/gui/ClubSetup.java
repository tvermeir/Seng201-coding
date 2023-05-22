package coding201.gui;

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

import coding201.code.Athlete;
import coding201.code.PlayerClub;
import coding201.code.Stadium;
import coding201.code.Store;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

/**
 * clubSetup
 *This method is responsible for setting up the club page. It takes in user data such as the name of the club, the difficulty setting and the number of weeks the user wants to play for
 *It utilizes both Java Swing and java to create a gui with multiple JPanels.
 *@version 1.0
 * @author tve21
 * @author bro82
 */

public class ClubSetup {
	/* */
	/**
	 * an integer, money
	 */
	public int money = 100;
	/**
	 * the main frame 
	 */
	public MainFrame frame;
	/**
	 * name of a club
	 */
	public String clubName;
	
	/**
	 * a JPanel
	 */
	public JPanel clubPanel;
	/**
	 * string of a name
	 */
	public String nameString;
	
	ButtonGroup difficultyButtons = new ButtonGroup();
	/**
	 * string that represents the difficulty
	 */
	public String difficultyString;
	
	Stadium stadium;
	/**
	 * the number of weeks to play
	 */
	public int weeksToPlay;
	PlayerClub userClub;
	Store store;
	

	/**\
	 * The constructor here take in a frame, a panel, an instance of a PlayerClub, Store and stadium. it also sets the bounds of the initial jPanel, before calling the 
	 * appropriate method that gets the intended name of the club
	 * 
	 * @param store  an instance of the store that is also created in the gameEnvironment class
	 * @param frame the mainframe that creates the whole frame.
	 * @param clubPanel the panel that the class will be built upon.
	 * @param stadium  An instance of stadium was initialized in the gameEnvironment class before being passed through
	 * @param userClub a playerClub that is initialized in the gameEnvironment before being passed through.
	 */
	public void setupFrame(MainFrame frame, JPanel clubPanel, Stadium stadium, PlayerClub userClub, Store store) {
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
	/**\
	 * The method gathers information from the user specifying how many weeks they would like to play for. 
	 * The number ranges from 5-15 and utilizes a JSlider with ticks at each integer value between those
	 * parameters. It then sets the variable in the stadium class, weekstoPlay, to the variable from the JSlider. 
	 */
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
				stadium.weeksToPlay = weeksSelected.getValue();
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
			 /*Gets the number of weeks to play for from the JSlider unit input*/
		 	public void actionPerformed(ActionEvent e) {
		 		if(stadium.weeksToPlay==0) {
		 			JOptionPane.showMessageDialog(frame, "Please Select a Number of Weeks to Play For");
		 		}
		 		else {
		 			HomePanel homePanel = new HomePanel(frame);
		 			JOptionPane.showMessageDialog(frame, stadium.club.name + " has been entered into a " + Integer.toString(stadium.weeksToPlay) + " week tournament. \n These starting players have been purchased: \n\n" + stadium.club.printAthleteList());
		 			
			 		homePanel.setupPanel(stadium, store);
			 		JOptionPane.showMessageDialog(frame,"Welcome to the HomePanel! Here you are able to do multiple things");
					JOptionPane.showMessageDialog(frame,"In the Store, you are able to purchase new players and items for your team");
					JOptionPane.showMessageDialog(frame,"In the Team View you are able to apply items, sell players, rename players and adjust your lineup ");
					JOptionPane.showMessageDialog(frame,"in the Stadium you are able to select your Opponent, Skip a Week and start a match");
			 	}
		 		
		 		}
		 		
		 });
		 continueButton.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		 continueButton.setBounds(493, 524, 293, 79);
		 weeksPanel.add(continueButton);
		
		
	}
	/**\
	 * This method uses radio buttons to get a specified difficulty from the user. There are three possible values, Easy, Medium and Hard.
	 * The difference between the 3 is the starting money, easy gives $150, medium uses $100, hard uses $50.
	 */
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
			 /*Gets the difficulty setting from the user depending on the selected button*/
		 	public void actionPerformed(ActionEvent e) {
		 		difficultyString = getSelectedButton();
		 		userClub.balance = getMoney();
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
	/**\
	 *The method iterates through the radio buttons, before returning the string value associated with the button
	 *Then the value for the string is passed back into the method above
	 *@return String value for the difficulty setting
	 */
	public String getSelectedButton()
	{  
	    for (Enumeration<AbstractButton> buttons = difficultyButtons.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = buttons.nextElement();
	        if (button.isSelected()) {
	                return button.getText();
	        }
	    }
	    return null;
	}
	
	/**\
	 *Depending on the value of the difficulty string, the initial balance will be set by the method below.
	 *@return int money
	 */
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
	
	/**\
	 *A method that gets the club name by reading the input from the given text field. The input has to be between 3-15 characters and can only contain numbers and letters. 
	 *The name is then set using the variable stored inside the PlayerClub before
	 */
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
			 /*Gets the name of the club depending on the user input. It checks that the name doesn't contain special characters and is in between 3 and 15 characters long. */
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		clubName = nameInput.getText();
			 		userClub.setName(clubName);
			 		
			 		if(clubName.length() < 3 || clubName.length() > 15){
			 			JOptionPane.showMessageDialog(frame, "Please Enter a Name that is 3-15 characters in length.");
			 			return;
			 		}
			 		Boolean hasSpecial = false;
			 		for (int i = 0; i < clubName.length(); i++) {
			 			if (!Character.isLetter(clubName.toLowerCase().charAt(i)) && !Character.isDigit(clubName.charAt(i)) && !Character.isWhitespace(clubName.charAt(i))) {
			 				hasSpecial = true;
			 			}
			 		}
			 		if (hasSpecial == true) {
			 			JOptionPane.showMessageDialog(frame, "Please Enter a Name that contains no special characters");
			 			return;
			 		}
			 		
			 		
			 		
			 		else {
			 			setDifficulty();
			 		}
			 		
			 	}
			 });
		 
		 
		 
		 submitButton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		 submitButton.setBounds(590, 336, 99, 48);
		 clubPanel.add(submitButton);
		
	}
		 
	
	

	
	
	
	
}
