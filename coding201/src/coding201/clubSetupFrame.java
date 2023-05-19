package coding201;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class clubSetupFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	;
	String clubName;
	JFrame frame = new JFrame();
	private JTextArea textField;
	public clubSetupFrame() {
		
		
		frame.setBounds(0,0, 1280, 720);
		frame.getContentPane().setLayout(null);
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(500, 500, 1280, 720);
		mainPanel.setLayout(null);
		
		 frame.setContentPane(mainPanel);
		 frame.revalidate();
		 
//		 setBounds(0,0, 1280, 720);
			setLayout(null);
			
			textField = new JTextArea();
			textField.setEditable(false);
			textField.setBounds(1, 1, 199, 90);
			
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			textField.setLineWrap(true);
			
			
			
			JLabel lblNewLabel = new JLabel("gerrg");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel.setBounds(346, 30, 571, 46);
			frame.getContentPane().add(lblNewLabel);
		
		JLabel scoreLabel = new JLabel("fefe" );
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		scoreLabel.setBounds(338, 617, 587, 53);
		frame.getContentPane().add(scoreLabel);
		 
			
			
		 
		JScrollPane scroll = new JScrollPane (textField);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

		scroll.setBounds(254, 163, 689, 337);
		frame.getContentPane().add(scroll);

		 

		 JButton backButton = new JButton("Back");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//HomePanel home = new HomePanel(frame);
//					stad.currWeek +=1;
//					if(myClubScore > oppScore) {
//						stad.club.balance += 50;
//					}
//					else if(myClubScore == oppScore) {
//						stad.club.balance += 25;
//					}
//					else if(myClubScore < oppScore) {
//						stad.club.balance += 10;
//					}
//					store.refreshStore();
//					home.setupPanel(stad, store);
				}
			});
			backButton.setBounds(10, 25, 89, 23);
			frame.getContentPane().add(backButton);
		 
		 
		
		 
		 
		 


		 
		 
		
	}

	

}
