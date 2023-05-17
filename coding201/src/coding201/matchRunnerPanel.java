package coding201;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class matchRunnerPanel extends JPanel{

	matchRunner runner; 
	mainFrame frame;
	Stadium stad;
	PlayerClub userClub;
	private JTextField textField;
	
	public matchRunnerPanel(matchRunner runner, mainFrame frame, Stadium stad, PlayerClub userClub) {
		this.runner = runner;
		this.frame  = frame;
		this.stad = stad;
		this.userClub = userClub;
		
		
		setBounds(0,0, 1280, 720);
		setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(402, 148, 476, 423);
		add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Match Between " + stad.club.name +  " & " + runner.opposition.name );
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(402, 30, 476, 46);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FInal Score");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(402, 624, 476, 53);
		add(lblNewLabel_1);
		
		

		
	}
	
	
	public static void main(String[] args) {
		
	}
}
