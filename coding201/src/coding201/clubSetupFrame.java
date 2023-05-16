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
import javax.swing.JScrollBar;
import javax.swing.JSlider;

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
		 
		 JLabel titleLabel = new JLabel("Select the Number of Weeks You Would Like to Play For");
		 titleLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		 titleLabel .setHorizontalAlignment(SwingConstants.CENTER);
		 titleLabel .setBounds(0, 0, 1280, 99);
		 add(titleLabel);
		 
		 JSlider framesPerSecond = new JSlider();
		 framesPerSecond.setPaintLabels(true);
		 framesPerSecond.setPaintTicks(true);
		 framesPerSecond.setMinorTickSpacing(2);
		 framesPerSecond.setBounds(269, 347, 741, 45);
		 add(framesPerSecond);
		 
		 getTextFromTextField();
		 
		 
		
	}
	public String getTextFromTextField() {
		 
		
		 
		 
		 
	}
}
