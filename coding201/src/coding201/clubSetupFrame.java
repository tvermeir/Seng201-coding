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
import java.awt.Color;

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
		 
		 JLabel titleLabel = new JLabel("Select a Difficulty");
		 titleLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		 titleLabel .setHorizontalAlignment(SwingConstants.CENTER);
		 titleLabel .setBounds(0, 0, 1280, 99);
		 add(titleLabel);
		 
		 getTextFromTextField();
		 
		 
		
	}
	public String getTextFromTextField() {
		 
		 JRadioButton easyButton = new JRadioButton("Easy");
		 easyButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		 easyButton.setBounds(569, 197, 141, 23);
		 add(easyButton);
		 
		 JRadioButton mediumButton = new JRadioButton("Medium");
		 mediumButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		 mediumButton.setBounds(569, 263, 141, 23);
		 add(mediumButton);
		 
		 JRadioButton hardButton = new JRadioButton("Hard");
		 hardButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		 hardButton.setBounds(569, 344, 141, 23);
		 add(hardButton);
		 
		 JButton confirmDifficultyButton = new JButton("Confirm Difficulty");
		 confirmDifficultyButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 confirmDifficultyButton.setBackground(Color.WHITE);
		 confirmDifficultyButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		 confirmDifficultyButton.setBounds(508, 448, 264, 29);
		 add(confirmDifficultyButton);
		 
		 
		 return clubName;
	}
}
