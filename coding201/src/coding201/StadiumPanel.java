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
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;

public class StadiumPanel extends JPanel {
	opposingTeam currTeam;
	mainFrame frame;
	Stadium stadium;
	ArrayList<opposingTeam> oppsList = new ArrayList<opposingTeam>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Create the panel.
	 */
	public StadiumPanel(Stadium stadium, mainFrame frame) {
		this.frame = frame;
		this.stadium = stadium;
		
		
		
		
		
        
		
		
	
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
		playerPanel.setBounds(24, 82, 550, 369);
		add(playerPanel);
		playerPanel.setLayout(null);
		
		
		
		
		
		
		
		JLabel teamNameLabel = new JLabel(stadium.club.name);
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		teamNameLabel.setBounds(126, 11, 298, 14);
		playerPanel.add(teamNameLabel);
		
		JPanel playerList = new JPanel();
		playerList.setBounds(10, 36, 530, 138);
		playerPanel.add(playerList);
		playerList.setLayout(new GridLayout(1, 0, 0, 0));
		
		stadium.club.athleteList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playerList.add(athleteDisplay);   
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(657, 82, 550, 369);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel oppName = new JLabel(currTeam.name);
		oppName.setHorizontalAlignment(SwingConstants.CENTER);
		oppName.setBounds(144, 11, 261, 14);
		panel_1.add(oppName);
		
		JPanel oppList = new JPanel();
		oppList.setBounds(10, 36, 532, 137);
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
		buttonGroup.add(rdbtnNewRadioButton);
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
		buttonGroup.add(rdbtnNewRadioButton_1);
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
		buttonGroup.add(rdbtnNewRadioButton_2);
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
		buttonGroup.add(rdbtnNewRadioButton_3);
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
