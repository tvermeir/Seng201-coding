package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	ArrayList<PurchaseableItem> itemList = new ArrayList<PurchaseableItem>();
	ArrayList<JRadioButton> buttonlist = new ArrayList<JRadioButton>();
	ArrayList<JRadioButton> buttonsToPrint = new ArrayList<JRadioButton>();
	Athlete currPlayer;
	PurchaseableItem currItem;
	/**
	 * Create the panel.
	 */
	
	mainFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	public StorePanel(Stadium stadium, Store store, mainFrame frame) {
		setLayout(null);
		if (store.playerHashTable.size() > 0) {
			store.playerHashTable.forEach((k, v) -> {
				playerList.add(v);  
			});
		}
		
		store.itemHashtable.forEach((k, v) -> {
			itemList.add(v);  
		});
		
		
		
		
//		System.out.println(playerList.size());
		
		
		
		JLabel lblNewLabel = new JLabel("Store");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(538, 5, 203, 47);
		add(lblNewLabel);
		
		JPanel athletesDisplay = new JPanel();
		athletesDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		athletesDisplay.setBounds(306, 107, 530, 191);
		
		
		
		add(athletesDisplay);
			
			
		
			
	
		

		
		athletesDisplay.setLayout(null);
		JPanel playersInStorePanel = new JPanel();
		playersInStorePanel.setBounds(10, 7, 510, 157);
		athletesDisplay.add(playersInStorePanel);
		playersInStorePanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		
		
		
		
		playerList.forEach((v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playersInStorePanel.add(athleteDisplay);   
		});
		
		
		
		JLabel playerTitle = new JLabel("Players");
		playerTitle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		playerTitle.setBounds(306, 81, 750, 23);
		add(playerTitle);
		
		
		JPanel purchaseAthletesDisplay = new JPanel();
		purchaseAthletesDisplay.setLayout(null);
		purchaseAthletesDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		purchaseAthletesDisplay.setBounds(846, 107, 153, 191);
		add(purchaseAthletesDisplay);
		
		JPanel currPlayerPanel = new JPanel();
		currPlayerPanel.setBounds(10, 7, 133, 147);
		purchaseAthletesDisplay.add(currPlayerPanel);
		currPlayerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
if(playerList.size() == 0) {
			playerTitle.setText("Player Store is Empty, Come back next week to purchase more players!");
			remove(purchaseAthletesDisplay);
			remove(currPlayerPanel);
			
		}
		
		JPanel itemsDisplay = new JPanel();
		itemsDisplay.setLayout(null);
		itemsDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		itemsDisplay.setBounds(306, 334, 530, 193);
		add(itemsDisplay);
		
		JPanel ItemsPanel = new JPanel();
		ItemsPanel.setBounds(10, 7, 510, 154);
		itemsDisplay.add(ItemsPanel);
		ItemsPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		itemList.forEach((v) -> {
			ItemDisplay item = new ItemDisplay(v);
			ItemsPanel.add(item);
		});
		
		
		
		
		
		JLabel itemsTitle = new JLabel("Items");
		itemsTitle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		itemsTitle.setBounds(306, 309, 134, 14);
		add(itemsTitle);
		
		
		
		
//		JLabel balancelbl = new JLabel("Balance: " + Integer.toString(store.myClub.balance));
//		balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
//		balancelbl.setBounds(887, 29, 97, 23);
//		add(balancelbl);
		
		
		JLabel balancelbl = new JLabel("Balance: " + stadium.club.balance);
		balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		balancelbl.setBounds(1050, 33, 144, 23);
		add(balancelbl);
		
		JLabel weekLabel = new JLabel("Week " + stadium.currWeek + " / " + stadium.weeksToPlay);
		weekLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		weekLabel.setBounds(932, 33, 108, 23);
		add(weekLabel);
		
		JButton btnNewButton_1 = new JButton("PURCHASE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currPlayer == null) {
					JOptionPane.showMessageDialog(frame, "Please select a player." );
					return;
				}
				
				if (playerList.size() > 0 && store.myClub.balance - currPlayer.price >= 0  && stadium.club.reserveList.size() < 4) {
					Athlete swappedAthlete = store.myClub.addBoughtPlayer(currPlayer);
					if (swappedAthlete == currPlayer) {
						JOptionPane.showMessageDialog(frame, currPlayer.name + " Purchased and added to the starters.");
					}
					else {
						JOptionPane.showMessageDialog(frame, currPlayer.name + " Purchased and added to the starters.\n" + swappedAthlete.name + " has been swapped to the reserves." );
					}
					
					store.myClub.balance -= currPlayer.price;
					balancelbl.setText("Balance: " + Integer.toString(store.myClub.balance));
					playerList.remove(currPlayer);
					store.playerHashTable.remove(currPlayer.name);
					currPlayer = null;
					playersInStorePanel.removeAll();
					
					
					JRadioButton selectedRadioButton = buttonlist.get(buttonsToPrint.size() - 1);
					buttonGroup.remove(selectedRadioButton);
					athletesDisplay.remove(selectedRadioButton);
					buttonsToPrint.clear();
					athletesDisplay.revalidate();
					athletesDisplay.repaint();
					if (playerList.size() > 0) {
						for (int i = 0; i < playerList.size(); i++) {
							buttonsToPrint.add(buttonlist.get(i));
						}
					}
					
					
						
					
					
		            
					validate();
					repaint();
					playerList.forEach((v) -> {
						athleteDisplay athleteDisplay = new athleteDisplay(v);
						playersInStorePanel.add(athleteDisplay);   
					});
					
					
					currPlayerPanel.removeAll();
					
					buttonsToPrint.forEach((v) -> {
						athletesDisplay.add(v);
					});
					
					validate();
					repaint();
					StorePanel.this.validate();
					StorePanel.this.repaint();
					athletesDisplay.revalidate();
					athletesDisplay.repaint();
					
					
					
				}
				else if (stadium.club.reserveList.size() == 4) {
					JOptionPane.showMessageDialog(frame, "Only a maximum of 8 players allowed in the Team. Sell one if you want to buy " + currPlayer.name );
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "Club balance is too low. Cannot purchase " + currPlayer.name + "." );
				}
					
				
			}
		});
		
		
		btnNewButton_1.setBounds(23, 156, 106, 29);
		purchaseAthletesDisplay.add(btnNewButton_1);
		
		JPanel purchaseItemsDisplay = new JPanel();
		purchaseItemsDisplay.setLayout(null);
		purchaseItemsDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		purchaseItemsDisplay.setBounds(846, 334, 153, 193);
		add(purchaseItemsDisplay);
		
		JPanel currItemPanel = new JPanel();
		currItemPanel.setBounds(10, 7, 133, 146);
		purchaseItemsDisplay.add(currItemPanel);
		currItemPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("PURCHASE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currItem == null) {
					JOptionPane.showMessageDialog(frame, "Please select an item." );
					return;
				}
				if (store.myClub.balance - currItem.price >= 0 && !store.myClub.itemList.contains(currItem.name)) {
					store.myClub.addItem(currItem);
					store.myClub.balance -= currItem.price;
					balancelbl.setText("Balance: " + Integer.toString(store.myClub.balance));
					JOptionPane.showMessageDialog(frame, currItem.name + " Purchased." );
					currItem = null;
					currItemPanel.removeAll();
					currItemPanel.revalidate();
					currItemPanel.repaint();
				}
				else if (store.myClub.itemList.contains(currItem.name)) {
					JOptionPane.showMessageDialog(frame, currItem.name + "Already in club inventory. Use it before purchasing another." );
				}
				
				
				else {
					JOptionPane.showMessageDialog(frame, "Club balance is too low. Cannot purchase " + currItem.name + "." );
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(23, 158, 106, 29);
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
		
		
//		
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currItem = itemList.get(0);
				currItemPanel.removeAll();
				ItemDisplay currbuyingitem = new ItemDisplay(currItem);
				currItemPanel.add(currbuyingitem);
				revalidate();
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(63, 160, 21, 23);
		itemsDisplay.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_4_1 = new JRadioButton("");
		rdbtnNewRadioButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currItem = itemList.get(1);
				currItemPanel.removeAll();
				ItemDisplay currbuyingitem = new ItemDisplay(currItem);
				currItemPanel.add(currbuyingitem);
				revalidate();
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_4_1);
		rdbtnNewRadioButton_4_1.setBounds(193, 160, 21, 23);
		itemsDisplay.add(rdbtnNewRadioButton_4_1);
		
		JRadioButton rdbtnNewRadioButton_4_2 = new JRadioButton("");
		rdbtnNewRadioButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currItem = itemList.get(2);
				currItemPanel.removeAll();
				ItemDisplay currbuyingitem = new ItemDisplay(currItem);
				currItemPanel.add(currbuyingitem);
				revalidate();
				
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_4_2);
		rdbtnNewRadioButton_4_2.setBounds(319, 160, 21, 23);
		itemsDisplay.add(rdbtnNewRadioButton_4_2);
		
		if (playerList.size() > 0) {
			for (int i = 0; i < playerList.size(); i++) {
				buttonsToPrint.add(buttonlist.get(i));
			}
		}
		
		buttonsToPrint.forEach((v) -> {
			athletesDisplay.add(v);
		});
		
		
		
		
		
		
		
		

	}
	
	
}
