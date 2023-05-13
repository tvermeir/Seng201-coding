package coding201;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class clubSetupFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	;
	String clubName;
	mainFrame frame;
	private JTextField textField;
	public clubSetupFrame(mainFrame mainframe) {
		this.frame = mainframe;
		
		 setBounds(500, 500, 1280, 720);
		 setLayout(null);
		 
		 JPanel clubPanel = new JPanel();
		 add(clubPanel);
		 
		 JLabel titleLabel = new JLabel("Setup Your Club!");
		 titleLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		 titleLabel .setHorizontalAlignment(SwingConstants.CENTER);
		 titleLabel .setBounds(0, 0, 1280, 99);
		 add(titleLabel);
		 
		 getTextFromTextField();
		 
		 
		
	}
	public String getTextFromTextField() {
			
		 
		
		 JTextField nameInput = new JTextField();
		 nameInput.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		 nameInput.setBounds(551, 139, 173, 56);
		 add(nameInput);
		 
		 nameInput.setColumns(10);
		 
		 JLabel nameLabel = new JLabel("Please Enter Team Name Below");
		 nameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		 nameLabel.setBounds(483, 90, 320, 38);
		 nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 add(nameLabel);
		 
		 JButton submitButton = new JButton("Submit");
		 submitButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		clubName = nameInput.getText();
		 		System.out.println(clubName);
		 	}
		 });
		 submitButton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		 submitButton.setBounds(594, 216, 99, 48);
		 add(submitButton);
		 
		 JLabel lblNewLabel = new JLabel("Team Name");
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setBounds(551, 290, 173, 16);
		 add(lblNewLabel);
		 
		 JLabel setDifficultyLabel = new JLabel("Select a Difficulty");
		 setDifficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 setDifficultyLabel.setBounds(570, 400, 123, 16);
		 add(setDifficultyLabel);
		 
		 JRadioButton easyButton = new JRadioButton("Easy");
		 easyButton.setBounds(551, 475, 141, 23);
		 add(easyButton);
		 
		 JRadioButton mediumButton = new JRadioButton("Medium");
		 mediumButton.setBounds(551, 510, 141, 23);
		 add(mediumButton);
		 
		 JRadioButton hardButton = new JRadioButton("Hard");
		 hardButton.setBounds(551, 545, 141, 23);
		 add(hardButton);
		 
		 JButton confirmDifficultyButton = new JButton("Confirm Difficulty");
		 confirmDifficultyButton.setBounds(551, 600, 173, 29);
		 add(confirmDifficultyButton);
		 
		 
		 return clubName;
	}
}
