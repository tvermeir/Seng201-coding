 package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinishPanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public FinishPanel(mainFrame frame, Stadium stad) {
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		
		JLabel titleLabel = new JLabel("The Game Has Been Finished");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		titleLabel.setBounds(166, 11, 948, 63);
		add(titleLabel);
		
		JLabel congratsLabel = new JLabel("Congratulations, Here are " + stad.club.name + "'s statistics");
		congratsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		congratsLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		congratsLabel.setBounds(166, 134, 948, 63);
		add(congratsLabel);
		
		JLabel winLabel = new JLabel("Wins: " + stad.numWins);
		winLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		winLabel.setBounds(580, 249, 120, 63);
		add(winLabel);
		
		JLabel lossLabel = new JLabel("Losses: " + stad.numLosses);
		lossLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lossLabel.setBounds(580, 327, 120, 63);
		add(lossLabel);
		
		JLabel drawLabel = new JLabel("Draws: " + stad.numDraws);
		drawLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		drawLabel.setBounds(580, 401, 120, 63);
		add(drawLabel);
		
		JLabel moneyLabel = new JLabel("Money: "+ stad.club.balance);
		moneyLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		moneyLabel.setBounds(580, 475, 120, 63);
		add(moneyLabel);
		
		JButton exitButton = new JButton("Exit Screen");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		exitButton.setBounds(519, 549, 229, 113);
		add(exitButton);
	}
}
