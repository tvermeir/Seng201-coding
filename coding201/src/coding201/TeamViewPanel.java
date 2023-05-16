package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamViewPanel extends JPanel {
	mainFrame frame;
	/**
	 * Create the panel.
	 */
	public TeamViewPanel(Stadium stadium, Store store, mainFrame frame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TEAM THINGS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 33));
		lblNewLabel.setBounds(555, 5, 215, 64);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(89, 115, 552, 181);
		add(panel);
		panel.setLayout(null);
		
		JPanel playerList = new JPanel();
		playerList.setBounds(10, 11, 532, 159);
		panel.add(playerList);
		playerList.setLayout(new GridLayout(0, 4, 0, 0));
		stadium.club.starterList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playerList.add(athleteDisplay);   
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(89, 358, 552, 167);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel reservePanel = new JPanel();
		reservePanel.setBounds(10, 11, 532, 145);
		panel_1.add(reservePanel);
		reservePanel.setLayout(new GridLayout(0, 4, 0, 0));
		stadium.club.reserveList.forEach((k, v) -> {
			athleteDisplay athleteDisp = new athleteDisplay(v);
			reservePanel.add(athleteDisp);
			reservePanel.validate();
			System.out.println(v.name);
		});
		
		JLabel lblStarters = new JLabel("Starters");
		lblStarters.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblStarters.setBounds(89, 77, 215, 27);
		add(lblStarters);
		
		JLabel lblNewLabel_1_1 = new JLabel("Reserves");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(89, 307, 215, 27);
		add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePanel home = new HomePanel(frame);
				home.setupPanel(stadium, store);
			}
		});
		btnNewButton.setBounds(10, 33, 89, 23);
		add(btnNewButton);

	}
}
