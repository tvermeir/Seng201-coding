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
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.ButtonGroup;
import java.util.ArrayList;
public class TeamViewPanel extends JPanel {
	mainFrame frame;
	private final ButtonGroup starterButtonGroup = new ButtonGroup();
	private final ButtonGroup reserveButtonGroup = new ButtonGroup();
	Athlete currPlayer;
	Athlete currReserve;
	Athlete currStarter;
	ArrayList<JRadioButton> starterButtonList = new ArrayList<JRadioButton>();
	ArrayList<JRadioButton> reserveButtonList = new ArrayList<JRadioButton>();
	/**
	 * Create the panel.
	 */
	public TeamViewPanel(Stadium stadium, Store store, mainFrame frame) {
		setLayout(null);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBounds(932, 237, 166, 257);
		add(panel_4);
		panel_4.setLayout(null);
		
		JPanel currDisplay = new JPanel();
		currDisplay.setForeground(Color.WHITE);
		currDisplay.setBorder(null);
		currDisplay.setBounds(10, 11, 146, 154);
		panel_4.add(currDisplay);
		
		
		JLabel lblNewLabel = new JLabel("TEAM THINGS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 33));
		lblNewLabel.setBounds(555, 5, 215, 64);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(115, 118, 552, 211);
		add(panel);
		panel.setLayout(null);
		
		JPanel playerList = new JPanel();
		playerList.setBounds(10, 11, 532, 159);
		panel.add(playerList);
		playerList.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		starterButtonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(55, 177, 21, 23);
//		panel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = stadium.club.starterList.get(0);
				currStarter = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				currDisplay.revalidate();
				
				
			}
		});
		starterButtonList.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		starterButtonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(194, 177, 21, 23);
//		panel.add(rdbtnNewRadioButton_1);
		starterButtonList.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("");
		starterButtonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(349, 177, 21, 23);
//		panel.add(rdbtnNewRadioButton_1_1);
		starterButtonList.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("");
		starterButtonGroup.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setBounds(475, 177, 21, 23);
//		panel.add(rdbtnNewRadioButton_1_1_1);
		starterButtonList.add(rdbtnNewRadioButton_1_1_1);
		
		for (int i = 0; i < store.myClub.starterList.size(); i++) {
			panel.add(starterButtonList.get(i));
			revalidate();
		}
		
		
		stadium.club.starterList.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playerList.add(athleteDisplay);   
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(115, 392, 552, 211);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel reservePanel = new JPanel();
		reservePanel.setBounds(10, 11, 532, 162);
		panel_1.add(reservePanel);
		reservePanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		reserveButtonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(52, 181, 21, 23);
//		panel_1.add(rdbtnNewRadioButton_2);
		reserveButtonList.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1_1_1_1 = new JRadioButton("");
		reserveButtonGroup.add(rdbtnNewRadioButton_1_1_1_1);
		rdbtnNewRadioButton_1_1_1_1.setBounds(472, 181, 21, 23);
//		panel_1.add(rdbtnNewRadioButton_1_1_1_1);
		reserveButtonList.add(rdbtnNewRadioButton_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_2 = new JRadioButton("");
		reserveButtonGroup.add(rdbtnNewRadioButton_1_1_2);
		rdbtnNewRadioButton_1_1_2.setBounds(346, 181, 21, 23);
//		panel_1.add(rdbtnNewRadioButton_1_1_2);
		reserveButtonList.add(rdbtnNewRadioButton_1_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("");
		reserveButtonGroup.add(rdbtnNewRadioButton_1_2);
		rdbtnNewRadioButton_1_2.setBounds(191, 181, 21, 23);
//		panel_1.add(rdbtnNewRadioButton_1_2);
		reserveButtonList.add(rdbtnNewRadioButton_1_2);
//		System.out.println(reserveButtonList);
		for (int i = 0; i < stadium.club.reserveList.size(); i++) {
			panel_1.add(reserveButtonList.get(i));
			revalidate();
		}
		
		stadium.club.reserveList.forEach((k, v) -> {
			athleteDisplay athleteDisp = new athleteDisplay(v);
			reservePanel.add(athleteDisp);
			reservePanel.validate();
//			System.out.println(v.name);
		});
		
		JLabel lblStarters = new JLabel("Starters");
		lblStarters.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblStarters.setBounds(115, 80, 215, 27);
		add(lblStarters);
		
		JLabel lblNewLabel_1_1 = new JLabel("Reserves");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(115, 354, 215, 27);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(690, 118, 166, 485);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel InvPanel = new JPanel();
		InvPanel.setBounds(10, 11, 146, 463);
		panel_2.add(InvPanel);
		InvPanel.setLayout(new GridLayout(3, 1, 0, 0));
		stadium.club.itemInventory.forEach((k, v) -> {
			ItemDisplay itemdisp = new ItemDisplay(v);
			InvPanel.add(itemdisp);
			InvPanel.revalidate();
		});
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Item Inventory");
		lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(690, 80, 215, 27);
		add(lblNewLabel_1_1_1);
		
		
		
		JButton btnNewButton_1 = new JButton("Apply Attack Training");
		btnNewButton_1.setBounds(10, 176, 146, 23);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Apply Defense Training");
		btnNewButton_1_1.setBounds(10, 199, 146, 23);
		panel_4.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Apply Active Recovery");
		btnNewButton_1_1_1.setBounds(10, 222, 146, 23);
		panel_4.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Selected Player");
		lblNewLabel_1_1_1_1.setBounds(932, 199, 215, 27);
		add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));

	}
}
