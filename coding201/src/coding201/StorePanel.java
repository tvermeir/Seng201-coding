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
		
		JPanel athletesDisplay = new JPanel();
		athletesDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		athletesDisplay.setBounds(167, 108, 530, 191);
		
		
		
		add(athletesDisplay);
			
			
		
			
	
		

		
		athletesDisplay.setLayout(null);
		JPanel playersInStorePanel = new JPanel();
		playersInStorePanel.setBounds(10, 7, 510, 147);
		athletesDisplay.add(playersInStorePanel);
		playersInStorePanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		
		
		
		
		playerList.forEach((v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playersInStorePanel.add(athleteDisplay);   
		});
		
		JLabel playerTitle = new JLabel("Players");
		playerTitle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		playerTitle.setBounds(167, 82, 750, 23);
		add(playerTitle);
		
if(playerList.size() == 0) {
			playerTitle.setText("Player Store is Empty, Come back next week to purchase more players!");
		}
		
		JPanel itemsDisplay = new JPanel();
		itemsDisplay.setLayout(null);
		itemsDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		itemsDisplay.setBounds(167, 335, 530, 179);
		add(itemsDisplay);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 7, 510, 132);
		itemsDisplay.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel itemsTitle = new JLabel("Items");
		itemsTitle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		itemsTitle.setBounds(167, 310, 134, 14);
		add(itemsTitle);
		
		JPanel purchaseAthletesDisplay = new JPanel();
		purchaseAthletesDisplay.setLayout(null);
		purchaseAthletesDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		purchaseAthletesDisplay.setBounds(707, 108, 153, 191);
		add(purchaseAthletesDisplay);
		
		JPanel currPlayerPanel = new JPanel();
		currPlayerPanel.setBounds(10, 7, 133, 147);
		purchaseAthletesDisplay.add(currPlayerPanel);
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
		                athletesDisplay.remove(selectedRadioButton);
		                athletesDisplay.validate();
		                athletesDisplay.repaint();
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
					athletesDisplay.revalidate();
					athletesDisplay.repaint();
				}
				
			}
		});
		
		
		btnNewButton_1.setBounds(23, 156, 106, 29);
		purchaseAthletesDisplay.add(btnNewButton_1);
		
		JPanel purchaseItemsDisplay = new JPanel();
		purchaseItemsDisplay.setLayout(null);
		purchaseItemsDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		purchaseItemsDisplay.setBounds(707, 335, 153, 179);
		add(purchaseItemsDisplay);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(10, 7, 133, 132);
		purchaseItemsDisplay.add(panel_1_2_1);
		panel_1_2_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("PURCHASE");
		btnNewButton.setBounds(23, 144, 106, 29);
		purchaseItemsDisplay.add(btnNewButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePanel home = new HomePanel(frame);
				home.setupPanel(stadium, store);
			}
		});
		backButton.setBounds(10, 25, 89, 23);
		add(backButton);
		
		
		
		
		
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
				athletesDisplay.add(buttonlist.get(i));
			}
		}
//		else {
//		    JLabel noPlayersLabel = new JLabel("No players available");
//		    noPlayersLabel.setBounds(10, 50, 100, 20);
//		    panel.add(noPlayersLabel);
//		}
		
		
		
		
		

	}
}
