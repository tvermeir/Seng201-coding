package coding201;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

import javax.swing.JRadioButton;

import java.util.ArrayList;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

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
	public StadiumPanel(Stadium stadium, Store store, mainFrame frame) {
		this.frame = frame;
		this.stadium = stadium;
		
		
		
		
		
		
        
		
		
	
		stadium.PossibleOpponents.forEach((k, v) -> {
			  oppsListTable.add(v);
//			  System.out.println(v.printAthleteList());
		});
		
		currTeam = oppsListTable.get(0);
		

		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stadium");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(540, 21, 153, 33);
		add(lblNewLabel);
		
		JLabel teamNameLabel = new JLabel(stadium.club.name);
		teamNameLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		teamNameLabel.setBounds(142, 78, 298, 26);
		add(teamNameLabel);
		teamNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel oppName = new JLabel(currTeam.name);
		oppName.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 24));
		oppName.setBounds(806, 71, 261, 33);
		add(oppName);
		oppName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		playerPanel.setBounds(24, 115, 550, 431);
		add(playerPanel);
		playerPanel.setLayout(null);
		
		JPanel playerList = new JPanel();
		playerList.setBounds(10, 36, 530, 177);
		playerPanel.add(playerList);
		playerList.setLayout(new GridLayout(0, 4, 0, 0));
		stadium.club.starterList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playerList.add(athleteDisplay);   
		});
		
		JLabel lblNewLabel_1 = new JLabel("Starting Lineup");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 11, 134, 24);
		playerPanel.add(lblNewLabel_1);
		
		JPanel reservePanel = new JPanel();
		reservePanel.setBounds(10, 259, 530, 161);
		playerPanel.add(reservePanel);
		reservePanel.setLayout(new GridLayout(0, 4, 0, 0));
		stadium.club.reserveList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			reservePanel.add(athleteDisplay);   
		});
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Reserves");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 224, 134, 24);
		playerPanel.add(lblNewLabel_1_2);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(653, 224, 550, 236);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel oppList = new JPanel();
		oppList.setBounds(10, 36, 532, 177);
		panel_1.add(oppList);
		oppList.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Starting Lineup");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 11, 134, 24);
		panel_1.add(lblNewLabel_1_1);
		
		currTeam.athleteList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			oppList.add(athleteDisplay);   
		});
		
		
		JButton btnNewButton = new JButton("SIMULATE MATCH");
		btnNewButton.addActionListener(new ActionListener() {



			public void actionPerformed(ActionEvent e) {

				
				
				if(stadium.club.starterList.size() == 4 && stadium.weeksToPlay > stadium.currWeek) {
					matchRunner runner = new matchRunner(stadium.club, currTeam, frame, stadium, store);
					frame.setContentPane(runner);
				}
				else if(stadium.club.starterList.size() < 4) {
					JOptionPane.showMessageDialog(frame, "In order to Start a Match the Club Requires 4 Starters");
				}
				
				
				


				
			}
		});
		btnNewButton.setBounds(466, 557, 301, 23);
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
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(577, 132, 79, 33);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Opponent 2");
		rdbtnNewRadioButton_1.setVerticalTextPosition(SwingConstants.TOP);
		rdbtnNewRadioButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(1);
				oppList.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBounds(580, 222, 73, 37);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Opponent 3");
		rdbtnNewRadioButton_2.setVerticalTextPosition(SwingConstants.TOP);
		rdbtnNewRadioButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(2);
				oppList.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		rdbtnNewRadioButton_2.setBounds(580, 325, 73, 38);
		add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Opponent 4");
		rdbtnNewRadioButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtnNewRadioButton_3.setVerticalTextPosition(SwingConstants.TOP);
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currTeam = oppsListTable.get(3);
				oppList.removeAll();
				currTeam.starterList.forEach((k, v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					oppList.add(athleteDisplay);   
				});
				oppName.setText(currTeam.name);
				
				revalidate();
			}
		});
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_3.setBounds(580, 423, 73, 37);
		add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePanel home = new HomePanel(frame);

				home.setupPanel(stadium, store);

				
			}
		});
		btnNewButton_1.setBounds(24, 33, 89, 23);
		add(btnNewButton_1);
		
		
		JLabel balancelbl = new JLabel("Balance: " + stadium.club.balance);
		balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		balancelbl.setBounds(1050, 33, 144, 23);
		add(balancelbl);
			
		JLabel weekLabel = new JLabel("Week " + stadium.currWeek + " / " + stadium.weeksToPlay);
		weekLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		weekLabel.setBounds(932, 33, 108, 23);
		add(weekLabel);
		
		
		
		
		
		
		
		




	}

	
}
