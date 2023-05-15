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
	ArrayList<opposingTeam> oppsListTable = new ArrayList<opposingTeam>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Create the panel.
	 */
	public StadiumPanel(Stadium stadium, mainFrame frame) {
		this.frame = frame;
		this.stadium = stadium;
		
		
		
		
		
        
		
		
	
		stadium.PossibleOpponents.forEach((k, v) -> {
			  oppsListTable.add(v);
//			  System.out.println(v.printAthleteList());
		});
		
		currTeam = oppsListTable.get(0);
		

		
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
				stadium.playMatch(currTeam.name);
			}
		});
		btnNewButton.setBounds(466, 524, 301, 23);
		add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Opponent 1");
		rdbtnNewRadioButton.setVerticalTextPosition(SwingConstants.TOP);
		rdbtnNewRadioButton.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(0);
				oppList.removeAll();
				currTeam.athleteList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(577, 99, 79, 33);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Opponent 2");
		rdbtnNewRadioButton_1.setVerticalTextPosition(SwingConstants.TOP);
		rdbtnNewRadioButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(1);
				oppList.removeAll();
				currTeam.athleteList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBounds(580, 189, 73, 37);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Opponent 3");
		rdbtnNewRadioButton_2.setVerticalTextPosition(SwingConstants.TOP);
		rdbtnNewRadioButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(2);
				oppList.removeAll();
				currTeam.athleteList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		rdbtnNewRadioButton_2.setBounds(580, 292, 73, 38);
		add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Opponent 4");
		rdbtnNewRadioButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtnNewRadioButton_3.setVerticalTextPosition(SwingConstants.TOP);
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(3);
				oppList.removeAll();
				currTeam.athleteList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_3.setBounds(580, 390, 73, 37);
		add(rdbtnNewRadioButton_3);

	}
}
