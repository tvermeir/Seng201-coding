package coding201;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class clubSetupFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	;
	String clubName;
	JFrame frame = new JFrame();
	private JTextField textField;
	public clubSetupFrame() {
		
		
		 setBounds(500, 500, 1280, 720);
		 setLayout(null);
		 
		 JPanel clubPanel = new JPanel();
		 add(clubPanel);

		 JLabel titleLabel = new JLabel("Select the Number of Weeks You Would Like to Play For");

		 titleLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		 titleLabel .setHorizontalAlignment(SwingConstants.CENTER);
		 titleLabel .setBounds(0, 0, 1280, 99);
		 add(titleLabel);
		 
		 JSlider weeksSelected = new JSlider(5,15,10);
		 weeksSelected.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		int weeksToPlay = weeksSelected.getValue();
		 		System.out.println(weeksToPlay);
		 		}
		 });
		 weeksSelected.setPaintLabels(true);
		 weeksSelected.setPaintTicks(true);
		 weeksSelected.setMinorTickSpacing(1);
		 weeksSelected.setMajorTickSpacing(1);
		 weeksSelected.setBounds(269, 337, 741, 45);
		 add(weeksSelected);
		 
		 JButton continueButton = new JButton("Continue");
		 continueButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 continueButton.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		 continueButton.setBounds(493, 524, 293, 79);
		 add(continueButton);
		 
		 
		 

		 getTextFromTextField();

		 
		 
		
	}

	public String getTextFromTextField() {
		 
		 
		 return clubName;
	}

}
