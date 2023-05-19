package coding201;

import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;


public class matchRunnerPanel extends JPanel{

	matchRunner runner; 
	mainFrame frame;
	Stadium stad;
	PlayerClub userClub;
	private JTextArea textField;
	
	public matchRunnerPanel(matchRunner runner, mainFrame frame, Stadium stad, PlayerClub userClub) {
		this.runner = runner;
		this.frame  = frame;
		this.stad = stad;
		this.userClub = userClub;
		
		
		 

			
			
			
			JLabel lblNewLabel = new JLabel("Match Between " );
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel.setBounds(402, 30, 476, 46);
			add(lblNewLabel);
			
			textField = new JTextArea();
			textField.setEditable(false);
			textField.setBounds(242, 71, 796, 630);
			
			add(textField);
			textField.setColumns(10);
			textField.setLineWrap(true);
			
			JLabel scoreLabel = new JLabel("FInal Score");
			scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			scoreLabel.setBounds(402, 661, 476, 53);
			add(scoreLabel);
		 
			
			JButton backButton = new JButton("Back");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePanel home = new HomePanel(frame);
					stad.currWeek +=1 ;
					//home.setupPanel(stad, store);
				}
			});
			backButton.setBounds(10, 25, 89, 23);
			add(backButton);
			
			
		
	}
	
	
	public static void main(String[] args) {
		
	}
}
