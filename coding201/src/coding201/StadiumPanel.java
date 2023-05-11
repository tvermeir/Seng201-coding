package coding201;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class StadiumPanel extends JPanel {
	opposingTeam currTeam;
	/**
	 * Create the panel.
	 */
	public StadiumPanel(Stadium stadium) {
		
		ArrayList<opposingTeam> oppsList = new ArrayList<opposingTeam>();
		
		
		stadium.PossibleOpponents.forEach((k, v) -> {
			  oppsList.add(v);
			  System.out.println(v.printAthleteList());
		});
		
		currTeam = oppsList.get(0);
		
		
        
		
		
		
		
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stadium");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(550, 0, 133, 33);
		add(lblNewLabel);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		playerPanel.setBounds(24, 82, 570, 369);
		add(playerPanel);
		playerPanel.setLayout(null);
		
		
		
		
		
		JLabel teamNameLabel = new JLabel(stadium.club.getName());
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLabel.setBounds(192, 11, 89, 14);
		playerPanel.add(teamNameLabel);
		
		JPanel playerList = new JPanel();
		playerList.setBounds(36, 36, 504, 138);
		playerPanel.add(playerList);
		playerList.setLayout(new GridLayout(1, 0, 0, 0));
		
		stadium.club.athleteList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playerList.add(athleteDisplay);   
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(638, 82, 569, 369);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel oppName = new JLabel(currTeam.name);
		oppName.setHorizontalAlignment(SwingConstants.CENTER);
		oppName.setBounds(182, 11, 109, 14);
		panel_1.add(oppName);
		
		JPanel oppList = new JPanel();
		oppList.setBounds(36, 36, 506, 137);
		panel_1.add(oppList);
		oppList.setLayout(new GridLayout(1, 0, 0, 0));
		
		currTeam.athleteList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			oppList.add(athleteDisplay);   
		});
		
		
		JButton btnNewButton = new JButton("START MATCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stadium.playMatch(currTeam.getName());
			}
		});
		btnNewButton.setBounds(466, 524, 301, 23);
		add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsList.get(0);
				oppList.removeAll();
				revalidate();
			}
		});
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(600, 79, 32, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsList.get(1);
				oppList.removeAll();
				revalidate();
			}
		});
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBounds(600, 105, 32, 23);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsList.get(2);
				oppList.removeAll();
				revalidate();
			}
		});
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_2.setBounds(601, 131, 31, 23);
		add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsList.get(3);
				oppList.removeAll();
				revalidate();
			}
		});
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_3.setBounds(601, 157, 31, 23);
		add(rdbtnNewRadioButton_3);

	}
}
