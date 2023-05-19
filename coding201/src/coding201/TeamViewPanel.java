package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.ImageIcon;
import javax.swing.Timer;
public class TeamViewPanel extends JPanel {
	mainFrame frame;
	private final ButtonGroup starterButtonGroup = new ButtonGroup();
	private final ButtonGroup reserveButtonGroup = new ButtonGroup();
	Athlete currPlayer;
	Athlete currReserve;
	Athlete currStarter;
	Timer timer;
	ArrayList<JRadioButton> starterButtonList = new ArrayList<JRadioButton>();
	ArrayList<JRadioButton> reserveButtonList = new ArrayList<JRadioButton>();
	ArrayList<JRadioButton> reserveButtonsToPrint = new ArrayList<JRadioButton>();
	ArrayList<JRadioButton> starterButtonsToPrint = new ArrayList<JRadioButton>();
	ArrayList<Athlete> starterList = new ArrayList<Athlete>();
	ArrayList<Athlete> reserveList = new ArrayList<Athlete>();
	
	/**
	 * Create the panel.
	 */
	public TeamViewPanel(Stadium stadium, Store store, mainFrame frame) {
		setLayout(null);
		
		stadium.club.starterList.forEach((k, v) -> {
			starterList.add(v);   
		});
		
		stadium.club.reserveList.forEach((k, v) -> {
			reserveList.add(v);   
		});
		
		
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBounds(932, 237, 215, 284);
		add(panel_4);
		panel_4.setLayout(null);
		
		JPanel currDisplay = new JPanel();
		currDisplay.setForeground(Color.WHITE);
		currDisplay.setBorder(null);
		currDisplay.setBounds(34, 11, 146, 154);
		panel_4.add(currDisplay);
		currDisplay.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		JLabel lblNewLabel = new JLabel(stadium.club.name);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 33));
		lblNewLabel.setBounds(532, 5, 215, 64);
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
		
		JLabel balancelbl = new JLabel("Balance: " + stadium.club.balance);
		balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		balancelbl.setBounds(1050, 33, 97, 23);
		add(balancelbl);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = starterList.get(0);
				currStarter = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				revalidate();
				repaint();
				
			}
		});
		starterButtonList.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		starterButtonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(194, 177, 21, 23);
//		panel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = starterList.get(1);
				currStarter = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				revalidate();
				repaint();
				
			}
		});
		starterButtonList.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("");
		starterButtonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(349, 177, 21, 23);
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = starterList.get(2);
				currStarter = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				revalidate();
				repaint();
				
			}
		});
//		panel.add(rdbtnNewRadioButton_1_1);
		starterButtonList.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("");
		starterButtonGroup.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setBounds(475, 177, 21, 23);
//		panel.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = starterList.get(3);
				currStarter = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				revalidate();
				repaint();
				
			}
		});
		starterButtonList.add(rdbtnNewRadioButton_1_1_1);
		
		for (int i = 0; i < starterList.size(); i++) {
			panel.add(starterButtonList.get(i));
			revalidate();
			
		}
		
		
		starterList.forEach((v) -> {
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
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = reserveList.get(0);
				currReserve = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				revalidate();
				repaint();
				
			}
		});
		reserveButtonList.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("");
		reserveButtonGroup.add(rdbtnNewRadioButton_1_2);
		rdbtnNewRadioButton_1_2.setBounds(191, 181, 21, 23);
//		panel_1.add(rdbtnNewRadioButton_1_2);
		
		rdbtnNewRadioButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = reserveList.get(1);
				currReserve = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				revalidate();
				repaint();
				
			}
		});
		reserveButtonList.add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_1_2 = new JRadioButton("");
		reserveButtonGroup.add(rdbtnNewRadioButton_1_1_2);
		rdbtnNewRadioButton_1_1_2.setBounds(346, 181, 21, 23);
//		panel_1.add(rdbtnNewRadioButton_1_1_2);
		rdbtnNewRadioButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = reserveList.get(2);
				currReserve = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				revalidate();
				repaint();
				
			}
		});
		reserveButtonList.add(rdbtnNewRadioButton_1_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_1_1_1 = new JRadioButton("");
		reserveButtonGroup.add(rdbtnNewRadioButton_1_1_1_1);
		rdbtnNewRadioButton_1_1_1_1.setBounds(472, 181, 21, 23);
//		panel_1.add(rdbtnNewRadioButton_1_1_1_1);
		rdbtnNewRadioButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPlayer = reserveList.get(3);
				currReserve = currPlayer;
				currDisplay.removeAll();
				athleteDisplay disp = new athleteDisplay(currPlayer);
				currDisplay.add(disp);
				revalidate();
				repaint();
				
			}
		});
		reserveButtonList.add(rdbtnNewRadioButton_1_1_1_1);
		
		
		
		
		
//		System.out.println(reserveButtonList);
		for (int i = 0; i < reserveList.size(); i++) {
			panel_1.add(reserveButtonList.get(i));
			revalidate();
		}
		
		reserveList.forEach((v) -> {
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
		lblNewLabel_1_1.setBounds(115, 362, 215, 27);
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currPlayer == null) {
					JOptionPane.showMessageDialog(frame, "Please select a player" );
					return;
				}
				if (stadium.club.itemInventory.containsKey("Attack Training")) {
					stadium.club.itemInventory.remove("Attack Training");
					stadium.club.itemList.remove("Attack Training");
					InvPanel.removeAll();
					stadium.club.itemInventory.forEach((k, v) -> {
						ItemDisplay itemdisp = new ItemDisplay(v);
						InvPanel.add(itemdisp);
						InvPanel.revalidate();
					});
					if (stadium.club.starterList.contains(currPlayer)) {
						stadium.club.starterList.get(currPlayer.name).useAttackTraining();
						currDisplay.removeAll();
						athleteDisplay updated = new athleteDisplay(stadium.club.starterList.get(currPlayer.name));
						currDisplay.add(updated);
						
						playerList.removeAll();
						starterList.clear();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						
						starterList.forEach((v) -> {
							athleteDisplay athleteDisplay = new athleteDisplay(v);
							playerList.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					else if (stadium.club.reserveList.contains(currPlayer)) {
						stadium.club.reserveList.get(currPlayer.name).useAttackTraining();
						currDisplay.removeAll();
						athleteDisplay updated = new athleteDisplay(stadium.club.reserveList.get(currPlayer.name));
						currDisplay.add(updated);
						revalidate();
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();;
						
						reservePanel.removeAll();
						reserveList.clear();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						
						reserveList.forEach((v) -> {
							athleteDisplay athleteDisplay = new athleteDisplay(v);
							reservePanel.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					
					
				}
				else {
					JOptionPane.showMessageDialog(frame, "No Attack Training in Inventory." );
				}
				
				
			}
		});
		btnNewButton_1.setBounds(34, 176, 146, 23);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Apply Defense Training");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currPlayer == null) {
					JOptionPane.showMessageDialog(frame, "Please select a player" );
					return;
				}
				if (stadium.club.itemInventory.containsKey("Defense Training")) {
					stadium.club.itemInventory.remove("Defense Training");
					stadium.club.itemList.remove("Defense Training");
					InvPanel.removeAll();
					stadium.club.itemInventory.forEach((k, v) -> {
						ItemDisplay itemdisp = new ItemDisplay(v);
						InvPanel.add(itemdisp);
						InvPanel.revalidate();
					});
					if (stadium.club.starterList.contains(currPlayer)) {
						stadium.club.starterList.get(currPlayer.name).useDefenseTraining();
						currDisplay.removeAll();
						athleteDisplay updated = new athleteDisplay(stadium.club.starterList.get(currPlayer.name));
						currDisplay.add(updated);
						
						playerList.removeAll();
						starterList.clear();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						
						starterList.forEach((v) -> {
							athleteDisplay athleteDisplay = new athleteDisplay(v);
							playerList.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					else if (stadium.club.reserveList.contains(currPlayer)) {
						stadium.club.reserveList.get(currPlayer.name).useDefenseTraining();
						currDisplay.removeAll();
						athleteDisplay updated = new athleteDisplay(stadium.club.reserveList.get(currPlayer.name));
						currDisplay.add(updated);
						revalidate();
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();;
						
						reservePanel.removeAll();
						reserveList.clear();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						
						reserveList.forEach((v) -> {
							athleteDisplay athleteDisplay = new athleteDisplay(v);
							reservePanel.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					
					
				}
				else {
					JOptionPane.showMessageDialog(frame, "No Defense Training in Inventory." );
				}
				
			}
		});
		btnNewButton_1_1.setBounds(34, 198, 146, 23);
		panel_4.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Apply Active Recovery");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currPlayer == null) {
					JOptionPane.showMessageDialog(frame, "Please select a player" );
					return;
				}
				if (stadium.club.itemInventory.containsKey("Active Recovery")) {
					stadium.club.itemInventory.remove("Active Recovery");
					stadium.club.itemList.remove("Active Recovery");
					InvPanel.removeAll();
					stadium.club.itemInventory.forEach((k, v) -> {
						ItemDisplay itemdisp = new ItemDisplay(v);
						InvPanel.add(itemdisp);
						InvPanel.revalidate();
					});
					if (stadium.club.starterList.contains(currPlayer)) {
						stadium.club.starterList.get(currPlayer.name).useRecovery();
						currDisplay.removeAll();
						athleteDisplay updated = new athleteDisplay(stadium.club.starterList.get(currPlayer.name));
						currDisplay.add(updated);
						
						playerList.removeAll();
						starterList.clear();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						
						starterList.forEach((v) -> {
							athleteDisplay athleteDisplay = new athleteDisplay(v);
							playerList.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					else if (stadium.club.reserveList.contains(currPlayer)) {
						stadium.club.reserveList.get(currPlayer.name).useRecovery();
						currDisplay.removeAll();
						athleteDisplay updated = new athleteDisplay(stadium.club.reserveList.get(currPlayer.name));
						currDisplay.add(updated);
						revalidate();
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();;
						
						reservePanel.removeAll();
						reserveList.clear();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						
						reserveList.forEach((v) -> {
							athleteDisplay athleteDisplay = new athleteDisplay(v);
							reservePanel.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					
					
				}
				else {
					JOptionPane.showMessageDialog(frame, "No Active Recovery in Inventory." );
				}
				
				
			}
		});
		btnNewButton_1_1_1.setBounds(34, 223, 146, 23);
		panel_4.add(btnNewButton_1_1_1);
		
		JButton sellButton = new JButton("Sell Player");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currPlayer == null) {
					JOptionPane.showMessageDialog(frame, "Please select a player" );
					return;
				}
				
				else {
					
					
					if (stadium.club.starterList.contains(currPlayer)) {
						int choice = JOptionPane.showOptionDialog(frame,
				                "Are you sure you want to sell " + currPlayer.name + "?",
				                "Confirmation",
				                JOptionPane.YES_NO_OPTION,
				                JOptionPane.QUESTION_MESSAGE,
				                null,
				                new Object[]{"Continue", "Cancel"},
				                "Continue");

				        if (choice == JOptionPane.YES_OPTION) {
				        	
				      
				        } else {
				            return;
				        }
						stadium.club.starterList.remove(currPlayer.name);
						starterList.clear();
						playerList.removeAll();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						starterList.forEach((v) -> {
							athleteDisplay athleteDisplay = new athleteDisplay(v);
							playerList.add(athleteDisplay);
							playerList.revalidate();
						});
						stadium.club.balance += currPlayer.price;
						balancelbl.setText("Balance: " + Integer.toString(stadium.club.balance));
						stadium.club.athleteList.remove(currPlayer.name);
						currPlayer = null;
						currStarter = null;
						revalidate();
						repaint();
						
						JRadioButton selectedRadioButton = starterButtonList.get(starterButtonsToPrint.size() - 1);
						starterButtonGroup.remove(selectedRadioButton);
						panel.remove(selectedRadioButton);
						starterButtonsToPrint.clear();
						panel.revalidate();
						panel.repaint();
						if (starterList.size() > 0) {
							for (int i = 0; i < starterList.size(); i++) {
								starterButtonsToPrint.add(starterButtonList.get(i));
							}
						}
						starterButtonsToPrint.forEach((v) -> {
							panel.add(v);
						});
						currDisplay.removeAll();
						validate();
						repaint();
					}
					else if (stadium.club.reserveList.contains(currPlayer)) {
						stadium.club.reserveList.remove(currPlayer.name);
						reserveList.clear();
						reservePanel.removeAll();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						reserveList.forEach((v) -> {
							athleteDisplay athleteDisplay = new athleteDisplay(v);
							reservePanel.add(athleteDisplay);
							reservePanel.revalidate();
						});
						stadium.club.balance += currPlayer.price;
						balancelbl.setText("Balance: " + Integer.toString(stadium.club.balance));
						stadium.club.athleteList.remove(currPlayer.name);
						currPlayer = null;
						currReserve = null;
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
						
						JRadioButton selectedRadioButton = starterButtonList.get(reserveButtonsToPrint.size() - 1);
						reserveButtonGroup.remove(selectedRadioButton);
						panel_1.remove(selectedRadioButton);
						starterButtonsToPrint.clear();
						panel_1.revalidate();
						panel_1.repaint();
						if (reserveList.size() > 0) {
							for (int i = 0; i < reserveList.size(); i++) {
								reserveButtonsToPrint.add(reserveButtonList.get(i));
							}
						}
						reserveButtonsToPrint.forEach((v) -> {
							panel_1.add(v);
						});
						currDisplay.removeAll();
						validate();
						repaint();
					}
					
					
					
				}
				
			}
		});
		sellButton.setBounds(34, 247, 146, 23);
		panel_4.add(sellButton);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Selected Player");
		lblNewLabel_1_1_1_1.setBounds(932, 199, 215, 27);
		add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		

//		JLabel balancelbl = new JLabel("Balance: " + stadium.club.balance);
//		balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
//		balancelbl.setBounds(1050, 33, 144, 23);
//		add(balancelbl);

		
		JLabel weekLabel = new JLabel("Week " + stadium.currWeek + " / " + stadium.weeksToPlay);
		weekLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		weekLabel.setBounds(932, 33, 108, 23);
		TeamViewPanel.this.add(weekLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TeamViewPanel.class.getResource("/img/SwapArrows.jpg")));
		lblNewLabel_1.setBounds(41, 210, 73, 285);
		if (reserveList.size() > 0) {
			add(lblNewLabel_1);
		}
		
		JButton btnNewButton_2 = new JButton("Swap");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currPlayer == null || currStarter == null || currReserve == null) {
					JOptionPane.showMessageDialog(frame, "Please select a starter and a reserve" );
					return;
				}
				stadium.club.starterList.put(currReserve.name, currReserve);
				stadium.club.reserveList.put(currStarter.name, currStarter);
				stadium.club.starterList.remove(currStarter.name);
				stadium.club.reserveList.remove(currReserve.name);
				
				
				currPlayer = null;
				currStarter = null;
				currReserve = null;
				
				starterList.clear();
				reserveList.clear();
				playerList.removeAll();
				reservePanel.removeAll();
				
				stadium.club.starterList.forEach((k, v) -> {
					starterList.add(v);   
				});
				starterList.forEach((v) -> {
					athleteDisplay athleteDisplay = new athleteDisplay(v);
					playerList.add(athleteDisplay);
					playerList.revalidate();
				});
				stadium.club.reserveList.forEach((k, v) -> {
					reserveList.add(v);   
				});
				reserveList.forEach((v) -> {
					athleteDisplay athleteDisp = new athleteDisplay(v);
					reservePanel.add(athleteDisp);
					reservePanel.revalidate();
//					System.out.println(v.name);
				});
				
			}
		});
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.ITALIC, 14));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setBounds(29, 334, 81, 36);
		if (reserveList.size() > 0) {
			add(btnNewButton_2);
		}
		
		if (starterList.size() > 0) {
			for (int i = 0; i < starterList.size(); i++) {
				starterButtonsToPrint.add(starterButtonList.get(i));
			}
		}
		
		starterButtonsToPrint.forEach((v) -> {
			panel.add(v);
		});
		
		if (reserveList.size() > 0) {
			for (int i = 0; i < reserveList.size(); i++) {
				reserveButtonsToPrint.add(reserveButtonList.get(i));
			}
		}
		
		reserveButtonsToPrint.forEach((v) -> {
			panel_1.add(v);
		});
		
		
		

	}
}
