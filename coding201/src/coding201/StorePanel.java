package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class StorePanel extends JPanel {
	ArrayList<Athlete> playerList = new ArrayList<Athlete>();
	ArrayList<JRadioButton> buttonlist = new ArrayList<JRadioButton>();
	Athlete currPlayer;
	/**
	 * Create the panel.
	 */
	
	mainFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public StorePanel(Stadium stadium, Store store, mainFrame frame) {
		setLayout(null);
		if (store.playerHashTable.size() > 0) {
			store.playerHashTable.forEach((k, v) -> {
				playerList.add(v);  
			});
		}
		System.out.println(playerList.size());
		
		
		
		JLabel lblNewLabel = new JLabel("Store");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(432, 5, 203, 47);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(167, 108, 530, 191);
		add(panel);
		panel.setLayout(null);
		
		JPanel playersInStorePanel = new JPanel();
		playersInStorePanel.setBounds(10, 7, 510, 147);
		panel.add(playersInStorePanel);
		playersInStorePanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		if (playerList.size() > 0) {
			playerList.forEach((v) -> {
				athleteDisplay athleteDisplay = new athleteDisplay(v);
				playersInStorePanel.add(athleteDisplay);   
			});
		}
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Players");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(167, 88, 134, 14);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(167, 335, 530, 179);
		add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 7, 510, 132);
		panel_2.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Items");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(167, 310, 134, 14);
		add(lblNewLabel_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(707, 108, 153, 191);
		add(panel_3);
		
		JPanel currPlayerPanel = new JPanel();
		currPlayerPanel.setBounds(10, 7, 133, 147);
		panel_3.add(currPlayerPanel);
		currPlayerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("PURCHASE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playerList.size() > 0) {
					store.myClub.addPlayer(currPlayer);
					playerList.remove(currPlayer);
					store.playerHashTable.remove(currPlayer.name);
					currPlayer = null;
					playersInStorePanel.removeAll();
					
					JRadioButton selectedRadioButton = buttonlist.get(buttonlist.size() - 1);
		            if (selectedRadioButton != null) {
		                buttonGroup.remove(selectedRadioButton);
		                buttonlist.remove(selectedRadioButton);
		                panel.remove(selectedRadioButton);
		                panel.validate();
		                panel.repaint();
		            }
					
					validate();
					repaint();
					playerList.forEach((v) -> {
						athleteDisplay athleteDisplay = new athleteDisplay(v);
						playersInStorePanel.add(athleteDisplay);   
					});
					currPlayerPanel.removeAll();
					
					validate();
					repaint();
					StorePanel.this.validate();
					StorePanel.this.repaint();
					panel.revalidate();
					panel.repaint();
				}
				
			}
		});
		
		
		btnNewButton_1.setBounds(23, 156, 106, 29);
		panel_3.add(btnNewButton_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3_1.setBounds(707, 335, 153, 179);
		add(panel_3_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(10, 7, 133, 132);
		panel_3_1.add(panel_1_2_1);
		panel_1_2_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("PURCHASE");
		btnNewButton.setBounds(23, 144, 106, 29);
		panel_3_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePanel home = new HomePanel(frame);
				home.setupPanel(stadium, store);
			}
		});
		btnNewButton_2.setBounds(10, 25, 89, 23);
		add(btnNewButton_2);
		
		
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (playerList.size() > 0) {
					currPlayer = playerList.get(0);
					currPlayerPanel.removeAll();
					athleteDisplay currbuying = new athleteDisplay(currPlayer);
					currPlayerPanel.add(currbuying);
					revalidate();
				}
				
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(65, 161, 21, 23);
//		panel.add(rdbtnNewRadioButton);
		buttonlist.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playerList.size() > 0) {
					currPlayer = playerList.get(1);
					currPlayerPanel.removeAll();
					athleteDisplay currbuying = new athleteDisplay(currPlayer);
					currPlayerPanel.add(currbuying);
					revalidate();
				}
			}
		});
		
		
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(192, 161, 21, 23);
//		panel.add(rdbtnNewRadioButton_1);
		buttonlist.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playerList.size() > 0) {
					currPlayer = playerList.get(2);
					currPlayerPanel.removeAll();
					athleteDisplay currbuying = new athleteDisplay(currPlayer);
					currPlayerPanel.add(currbuying);
					revalidate();
				}
			}
		});
		
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(320, 161, 21, 23);
//		panel.add(rdbtnNewRadioButton_2);
		buttonlist.add(rdbtnNewRadioButton_2);
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playerList.size() > 0) {
					currPlayer = playerList.get(3);
					currPlayerPanel.removeAll();
					athleteDisplay currbuying = new athleteDisplay(currPlayer);
					currPlayerPanel.add(currbuying);
					revalidate();
				}
			}
		});
		
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(450, 161, 21, 23);
//		panel.add(rdbtnNewRadioButton_3);
		buttonlist.add(rdbtnNewRadioButton_3);
		
		if (playerList.size() > 0) {
			for (int i = 0; i < playerList.size(); i++) {
				panel.add(buttonlist.get(i));
			}
		}
//		else {
//		    JLabel noPlayersLabel = new JLabel("No players available");
//		    noPlayersLabel.setBounds(10, 50, 100, 20);
//		    panel.add(noPlayersLabel);
//		}
		
		
		
		
		

	}
}
