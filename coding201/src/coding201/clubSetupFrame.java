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
		
		
		 frame.setBounds(0, 0, 1280, 720);
		 frame.getContentPane().setLayout(null);
		 
		 JPanel clubPanel = new JPanel();
		 frame.getContentPane().add(clubPanel);
		 clubPanel.setBounds(0, 0, 1280, 720);
		 clubPanel.setLayout(null);

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
			 		
			 		//System.out.println(nameInput.getText());
			 	}
			 });
		 
		 
		 
		 submitButton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		 submitButton.setBounds(590, 336, 99, 48);
		 clubPanel.add(submitButton);
		
		 
		 
		 


		 
		 
		
	}

	

}
