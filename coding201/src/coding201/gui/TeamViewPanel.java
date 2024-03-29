package coding201.gui;

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


import coding201.code.Athlete;
import coding201.code.Stadium;
import coding201.code.Store;

import javax.swing.ButtonGroup;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JTextField;

/**
 * TeamViewPanel
 * The TeamViewPanel is the JPanel from which all intra-team actions can take place. 
 * Players can be sold back to the market, renamed, swapped from the starters to the reserves (and vice versa), and stat-boosting items can be applied.
 * @version 1.0
 * @author tve21
 * @author bro82
 */
public class TeamViewPanel extends JPanel {
	/**
	 * The main game frame
	 */
	MainFrame frame;
	/**
	 * Button Group for the starter selectors
	 */
	private final ButtonGroup starterButtonGroup = new ButtonGroup();
	/**
	 * Button group for the reserve selectors
	 */
	private final ButtonGroup reserveButtonGroup = new ButtonGroup();
	/**
	 * Currently selected player (chosen by the most recently selected button)
	 */
	Athlete currPlayer;
	/**
	 * Most recently selected reserve player
	 */
	Athlete currReserve;
	/**
	 * Most recently selected starter player
	 */
	Athlete currStarter;
	/**
	 * balance
	 */
	Integer bal;
	/**
	 * List for starter buttons
	 */
	ArrayList<JRadioButton> starterButtonList = new ArrayList<JRadioButton>();
	/**
	 * List for reserve buttons
	 */
	ArrayList<JRadioButton> reserveButtonList = new ArrayList<JRadioButton>();
	/**
	 * List for reserve buttons to print onto the GUI
	 */
	ArrayList<JRadioButton> reserveButtonsToPrint = new ArrayList<JRadioButton>();
	/**
	 * List for starter buttons to print onto the GUI
	 */
	ArrayList<JRadioButton> starterButtonsToPrint = new ArrayList<JRadioButton>();
	/**
	 * List of starter players
	 */
	ArrayList<Athlete> starterList = new ArrayList<Athlete>();
	/**
	 * List of reserve players
	 */
	ArrayList<Athlete> reserveList = new ArrayList<Athlete>();
	/**
	 * List of names of players
	 */
	ArrayList<String> nameList = new ArrayList<String>();
	/**
	 * updated name of the renamed athlete
	 */
	String newname;
	/**
	 * Initialise textfield
	 */
	private JTextField textField;
	/**
	 * Initialise submitButton
	 */
	private JButton submitButton;
	
	/**
	 * Create the panel.\
	 * @param stadium an instance of the stadium class
	 * @param store an instance of the store class
	 * @param frame an instance of the frame class
	 */
	public TeamViewPanel(Stadium stadium, Store store, MainFrame frame) {
		setLayout(null);
		
		/**
		 * Adds each of the starterlist, reservelist, and athletelist objects to arrayLists in order to make them iterable.
		 */
		stadium.club.starterList.forEach((k, v) -> {
			starterList.add(v);   
		});
		
		stadium.club.reserveList.forEach((k, v) -> {
			reserveList.add(v);   
		});
		stadium.club.athleteList.forEach((k, v) -> {
			nameList.add(v.name);   
		});
		
		
		
		
		
		JPanel selectedPlayerPanel = new JPanel();
		selectedPlayerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		selectedPlayerPanel.setBounds(932, 237, 215, 310);
		add(selectedPlayerPanel);
		selectedPlayerPanel.setLayout(null);
		
		JPanel currDisplay = new JPanel();
		currDisplay.setForeground(Color.WHITE);
		currDisplay.setBorder(null);
		currDisplay.setBounds(34, 11, 146, 154);
		selectedPlayerPanel.add(currDisplay);
		currDisplay.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		JLabel nameLabel = new JLabel(stadium.club.name);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 33));
		nameLabel.setBounds(532, 5, 215, 64);
		add(nameLabel);
		
		JPanel starterPanel = new JPanel();
		starterPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		starterPanel.setBounds(115, 118, 552, 211);
		add(starterPanel);
		starterPanel.setLayout(null);
		
		JPanel playerListPanel = new JPanel();
		playerListPanel.setBounds(10, 11, 532, 159);
		starterPanel.add(playerListPanel);
		playerListPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel balancelbl = new JLabel("Balance: " + stadium.club.balance);
		balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		balancelbl.setBounds(1050, 33, 144, 23);
		add(balancelbl);
		
		JRadioButton starterButton1 = new JRadioButton("");
		starterButtonGroup.add(starterButton1);
		starterButton1.setBounds(65, 177, 21, 23);
		starterButton1.addActionListener(new ActionListener() {
			/**
			 * Selects player 1 in the playerListPanel
			 */
			public void actionPerformed(ActionEvent e) {
				currPlayer = starterList.get(0);
				currStarter = currPlayer;
				currDisplay.removeAll();
				AthleteDisplay disp = new AthleteDisplay(currPlayer);
				currDisplay.add(disp);
				if (textField != null) {
					TeamViewPanel.this.remove(textField);
					TeamViewPanel.this.remove(submitButton);
					
				}
				
				revalidate();
				repaint();
				
				
			}
		});
		starterButtonList.add(starterButton1);
		
		JRadioButton starterButton2 = new JRadioButton("");
		starterButtonGroup.add(starterButton2);
		starterButton2.setBounds(204, 177, 21, 23);
		starterButton2.addActionListener(new ActionListener() {
			/**
			 * Selects player 2 in the playerListPanel
			 */
			public void actionPerformed(ActionEvent e) {
				currPlayer = starterList.get(1);
				currStarter = currPlayer;
				currDisplay.removeAll();
				AthleteDisplay disp = new AthleteDisplay(currPlayer);
				currDisplay.add(disp);
				if (textField != null) {
					TeamViewPanel.this.remove(textField);
					TeamViewPanel.this.remove(submitButton);
					
				}
				revalidate();
				repaint();
				
			}
		});
		starterButtonList.add(starterButton2);
		
		JRadioButton starterButton3 = new JRadioButton("");
		starterButtonGroup.add(starterButton3);
		starterButton3.setBounds(330, 177, 21, 23);
		starterButton3.addActionListener(new ActionListener() {
			/**
			 * Selects player 3 in the playerListPanel
			 */
			public void actionPerformed(ActionEvent e) {
				currPlayer = starterList.get(2);
				currStarter = currPlayer;
				currDisplay.removeAll();
				AthleteDisplay disp = new AthleteDisplay(currPlayer);
				currDisplay.add(disp);
				if (textField != null) {
					TeamViewPanel.this.remove(textField);
					TeamViewPanel.this.remove(submitButton);
					
				}
				revalidate();
				repaint();
				
			}
		});
		starterButtonList.add(starterButton3);
		
		JRadioButton starterButton4 = new JRadioButton("");
		starterButtonGroup.add(starterButton4);
		starterButton4.setBounds(465, 177, 21, 23);
		starterButton4.addActionListener(new ActionListener() {
			/**
			 * Selects player 4 in the playerListPanel
			 */
			public void actionPerformed(ActionEvent e) {
				currPlayer = starterList.get(3);
				currStarter = currPlayer;
				currDisplay.removeAll();
				AthleteDisplay disp = new AthleteDisplay(currPlayer);
				currDisplay.add(disp);
				if (textField != null) {
					TeamViewPanel.this.remove(textField);
					TeamViewPanel.this.remove(submitButton);
				}
				revalidate();
				repaint();
				
			}
		});
		starterButtonList.add(starterButton4);
		
		/**
		 * Adds each button to the starterPanel for the number of athletes in the starterList.
		 */
		
		for (int i = 0; i < starterList.size(); i++) {
			starterPanel.add(starterButtonList.get(i));
			revalidate();
			
		}
		
		/**
		 * Adds an athleteDisplay representation for each athlete in the starterList
		 */
		
		starterList.forEach((v) -> {
			AthleteDisplay athleteDisplay = new AthleteDisplay(v);
			playerListPanel.add(athleteDisplay);   
		});
		
		JPanel reservePanel = new JPanel();
		reservePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		reservePanel.setBounds(115, 392, 552, 211);
		add(reservePanel);
		reservePanel.setLayout(null);
		
		JPanel reserveListPanel = new JPanel();
		reserveListPanel.setBounds(10, 11, 532, 162);
		reservePanel.add(reserveListPanel);
		reserveListPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton reserveButton1 = new JRadioButton("");
		reserveButtonGroup.add(reserveButton1);
		reserveButton1.setBounds(52, 181, 21, 23);
		reserveButton1.addActionListener(new ActionListener() {
			/**
			 * Selects player 1 in the reserveListPanel
			 */
			public void actionPerformed(ActionEvent e) {
				currPlayer = reserveList.get(0);
				currReserve = currPlayer;
				currDisplay.removeAll();
				AthleteDisplay disp = new AthleteDisplay(currPlayer);
				currDisplay.add(disp);
				if (textField != null) {
					TeamViewPanel.this.remove(textField);
					TeamViewPanel.this.remove(submitButton);
					
				}
				revalidate();
				repaint();
				
			}
		});
		reserveButtonList.add(reserveButton1);
		
		JRadioButton reserveButton2 = new JRadioButton("");
		reserveButtonGroup.add(reserveButton2);
		reserveButton2.setBounds(191, 181, 21, 23);
		
		reserveButton2.addActionListener(new ActionListener() {
			/**
			 * Selects player 2 in the reserveListPanel
			 */
			public void actionPerformed(ActionEvent e) {
				currPlayer = reserveList.get(1);
				currReserve = currPlayer;
				currDisplay.removeAll();
				AthleteDisplay disp = new AthleteDisplay(currPlayer);
				currDisplay.add(disp);
				if (textField != null) {
					TeamViewPanel.this.remove(textField);
					TeamViewPanel.this.remove(submitButton);
					
				}
				revalidate();
				repaint();
				
			}
		});
		reserveButtonList.add(reserveButton2);
		
		JRadioButton reserveButton3 = new JRadioButton("");
		reserveButtonGroup.add(reserveButton3);
		reserveButton3.setBounds(346, 181, 21, 23);
		reserveButton3.addActionListener(new ActionListener() {
			/**
			 * Selects player 3 in the reserveListPanel
			 */
			public void actionPerformed(ActionEvent e) {
				currPlayer = reserveList.get(2);
				currReserve = currPlayer;
				currDisplay.removeAll();
				AthleteDisplay disp = new AthleteDisplay(currPlayer);
				currDisplay.add(disp);
				if (textField != null) {
					TeamViewPanel.this.remove(textField);
					TeamViewPanel.this.remove(submitButton);
					
				}
				revalidate();
				repaint();
				
			}
		});
		reserveButtonList.add(reserveButton3);
		
		JRadioButton reserveButton4 = new JRadioButton("");
		reserveButtonGroup.add(reserveButton4);
		reserveButton4.setBounds(472, 181, 21, 23);
		reserveButton4.addActionListener(new ActionListener() {
			/**
			 * Selects player 4 in the reserveListPanel
			 */
			public void actionPerformed(ActionEvent e) {
				currPlayer = reserveList.get(3);
				currReserve = currPlayer;
				currDisplay.removeAll();
				AthleteDisplay disp = new AthleteDisplay(currPlayer);
				currDisplay.add(disp);
				if (textField != null) {
					TeamViewPanel.this.remove(textField);
					TeamViewPanel.this.remove(submitButton);
					
				}
				revalidate();
				repaint();
				
			}
		});
		reserveButtonList.add(reserveButton4);
		
		/**
		 * Initialises the label that contains the swap arrow.
		 * Swap arrow drawn in microsoft paint.
		 */
		
		JLabel arrowLabel = new JLabel("");
		arrowLabel.setIcon(new ImageIcon(TeamViewPanel.class.getResource("/img/SwapArrows.jpg")));
		arrowLabel.setBounds(41, 210, 73, 285);
		if (reserveList.size() > 0) {
			add(arrowLabel);
		}
		
		JButton swapButton = new JButton("Swap");
		
		swapButton.addActionListener(new ActionListener() {
			/**
			 * Swap button replaces the currently selected starter with the currently selected reserve and moves them to their respective lists.
			 * Does not work if there isn't both a currently selected starter or a currently selected reserve.
			 */
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
				playerListPanel.removeAll();
				reserveListPanel.removeAll();
				
				stadium.club.starterList.forEach((k, v) -> {
					starterList.add(v);   
				});
				starterList.forEach((v) -> {
					AthleteDisplay athleteDisplay = new AthleteDisplay(v);
					playerListPanel.add(athleteDisplay);
					playerListPanel.revalidate();
				});
				stadium.club.reserveList.forEach((k, v) -> {
					reserveList.add(v);   
				});
				reserveList.forEach((v) -> {
					AthleteDisplay athleteDisp = new AthleteDisplay(v);
					reserveListPanel.add(athleteDisp);
					reserveListPanel.revalidate();
				});
				
			}
		});
		swapButton.setFont(new Font("Tw Cen MT", Font.ITALIC, 14));
		swapButton.setHorizontalAlignment(SwingConstants.LEADING);
		swapButton.setBounds(29, 334, 81, 36);
		if (reserveList.size() > 0) {
			add(swapButton);
			this.setComponentZOrder(swapButton, 0);
		}
		
		
		
		for (int i = 0; i < reserveList.size(); i++) {
			reservePanel.add(reserveButtonList.get(i));
			revalidate();
		}
		
		reserveList.forEach((v) -> {
			AthleteDisplay athleteDisp = new AthleteDisplay(v);
			reserveListPanel.add(athleteDisp);
			reserveListPanel.validate();
		});
		
		JLabel lblStarters = new JLabel("Starters");
		lblStarters.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblStarters.setBounds(115, 80, 215, 27);
		add(lblStarters);
		
		JLabel lblReserves = new JLabel("Reserves");
		lblReserves.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblReserves.setBounds(115, 362, 215, 27);
		add(lblReserves);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * Takes the player back to the Home Panel.
			 */
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
		
		JLabel itemInventory = new JLabel("Item Inventory");
		itemInventory.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		itemInventory.setBounds(690, 80, 215, 27);
		add(itemInventory);
		
		
		
		JButton attackTrainingButton = new JButton("Apply Attack Training");
		attackTrainingButton.addActionListener(new ActionListener() {
			/**
			 * Applies an attack training item, if present, to the currently selected player.
			 * Produces error option panes in the case that no athlete is selcted or no attack training items are in the inventory.
			 */
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
						AthleteDisplay updated = new AthleteDisplay(stadium.club.starterList.get(currPlayer.name));
						currDisplay.add(updated);
						
						playerListPanel.removeAll();
						starterList.clear();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						
						starterList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							playerListPanel.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					else if (stadium.club.reserveList.contains(currPlayer)) {
						stadium.club.reserveList.get(currPlayer.name).useAttackTraining();
						currDisplay.removeAll();
						AthleteDisplay updated = new AthleteDisplay(stadium.club.reserveList.get(currPlayer.name));
						currDisplay.add(updated);
						revalidate();
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();;
						
						reserveListPanel.removeAll();
						reserveList.clear();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						
						reserveList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							reserveListPanel.add(athleteDisplay);   
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
		attackTrainingButton.setBounds(22, 176, 171, 23);
		selectedPlayerPanel.add(attackTrainingButton);
		
		JButton defenseTrainingButton = new JButton("Apply Defense Training");
		defenseTrainingButton.addActionListener(new ActionListener() {
			/**
			 * Applies a defense training item, if present, to the currently selected player.
			 * Produces error option panes in the case that no athlete is selcted or no defense training items are in the inventory.
			 */
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
						AthleteDisplay updated = new AthleteDisplay(stadium.club.starterList.get(currPlayer.name));
						currDisplay.add(updated);
						
						playerListPanel.removeAll();
						starterList.clear();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						
						starterList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							playerListPanel.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					else if (stadium.club.reserveList.contains(currPlayer)) {
						stadium.club.reserveList.get(currPlayer.name).useDefenseTraining();
						currDisplay.removeAll();
						AthleteDisplay updated = new AthleteDisplay(stadium.club.reserveList.get(currPlayer.name));
						currDisplay.add(updated);
						revalidate();
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();;
						
						reserveListPanel.removeAll();
						reserveList.clear();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						
						reserveList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							reserveListPanel.add(athleteDisplay);   
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
		defenseTrainingButton.setBounds(22, 198, 171, 23);
		selectedPlayerPanel.add(defenseTrainingButton);
		
		JButton activeRecoveryButton = new JButton("Apply Active Recovery");
		activeRecoveryButton.addActionListener(new ActionListener() {
			/**
			 * Applies an active recovery item, if present, to the currently selected player.
			 * Produces error option panes in the case that no athlete is selected or no agtive recovery items are in the inventory.
			 */
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
						AthleteDisplay updated = new AthleteDisplay(stadium.club.starterList.get(currPlayer.name));
						currDisplay.add(updated);
						
						playerListPanel.removeAll();
						starterList.clear();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						
						starterList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							playerListPanel.add(athleteDisplay);   
						});
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
					}
					else if (stadium.club.reserveList.contains(currPlayer)) {
						stadium.club.reserveList.get(currPlayer.name).useRecovery();
						currDisplay.removeAll();
						AthleteDisplay updated = new AthleteDisplay(stadium.club.reserveList.get(currPlayer.name));
						currDisplay.add(updated);
						revalidate();
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();;
						
						reserveListPanel.removeAll();
						reserveList.clear();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						
						reserveList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							reserveListPanel.add(athleteDisplay);   
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
		activeRecoveryButton.setBounds(22, 223, 171, 23);
		selectedPlayerPanel.add(activeRecoveryButton);
		
		JButton sellButton = new JButton("Sell Player");
		sellButton.addActionListener(new ActionListener() {
			/**
			 * Sells the currently selected player back to the market for the sell value of the player.
			 * Error option pane is created if no player is selected.
			 * CheckEnd method is called after the sale if the starterList has less than 4 players and the club balance is too low to afford any player in the store.
			 * @param e
			 */
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
						if (reserveList.size() > 0) {
							stadium.club.starterList.put(reserveList.get(0).name, reserveList.get(0));
							stadium.club.reserveList.remove(reserveList.get(0).name);
							
						}
						/**
						 * Refreshes all the containers of athleteDisplays to reflect the changes in the club.
						 */
						starterList.clear();
						playerListPanel.removeAll();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						starterList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							playerListPanel.add(athleteDisplay);
							playerListPanel.revalidate();
						});
						reserveList.clear();
						reserveListPanel.removeAll();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						reserveList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							reserveListPanel.add(athleteDisplay);
							reserveListPanel.revalidate();
						});
						
						
						stadium.club.balance += currPlayer.sellPrice;
						balancelbl.setText("Balance: " + Integer.toString(stadium.club.balance));
						stadium.club.athleteList.remove(currPlayer.name);
						currPlayer = null;
						currStarter = null;
						revalidate();
						repaint();
						
						JRadioButton selectedRadioButton = starterButtonList.get(starterButtonsToPrint.size() - 1);
						starterButtonGroup.remove(selectedRadioButton);
						starterPanel.remove(selectedRadioButton);
						starterButtonsToPrint.clear();
						starterPanel.revalidate();
						starterPanel.repaint();
						if (starterList.size() > 0) {
							for (int i = 0; i < starterList.size(); i++) {
								starterButtonsToPrint.add(starterButtonList.get(i));
							}
						}
						starterButtonsToPrint.forEach((v) -> {
							starterPanel.add(v);
						});
						JRadioButton selectedRadioButton2;
						if (reserveButtonsToPrint.size() == 0) {
							
							selectedRadioButton2 = reserveButtonList.get(reserveButtonsToPrint.size());
						}
						else {
							selectedRadioButton2 = reserveButtonList.get(reserveButtonsToPrint.size() - 1);
						}
						reserveButtonGroup.remove(selectedRadioButton2);
						reservePanel.remove(selectedRadioButton2);
						reserveButtonsToPrint.clear();
						reservePanel.revalidate();
						reservePanel.repaint();
						if (reserveList.size() > 0) {
							for (int i = 0; i < reserveList.size(); i++) {
								reserveButtonsToPrint.add(reserveButtonList.get(i));
							}
							reserveButtonsToPrint.forEach((v) -> {
								reservePanel.add(v);
							});
						}
						
						
						
						
						
						currDisplay.removeAll();
						validate();
						repaint();
					}
					else if (stadium.club.reserveList.contains(currPlayer)) {
						stadium.club.reserveList.remove(currPlayer.name);
						reserveList.clear();
						reserveListPanel.removeAll();
						/**
						 * Refreshes all the containers of athleteDisplays to reflect the changes in the club.
						 */
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						reserveList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							reserveListPanel.add(athleteDisplay);
							reserveListPanel.revalidate();
						});
						stadium.club.balance += currPlayer.sellPrice;
						balancelbl.setText("Balance: " + Integer.toString(stadium.club.balance));
						stadium.club.athleteList.remove(currPlayer.name);
						currPlayer = null;
						currReserve = null;
						TeamViewPanel.this.revalidate();
						TeamViewPanel.this.repaint();
						
						JRadioButton selectedRadioButton = reserveButtonList.get(reserveButtonsToPrint.size() - 1);
						reserveButtonGroup.remove(selectedRadioButton);
						reservePanel.remove(selectedRadioButton);
						reserveButtonsToPrint.clear();
						reservePanel.revalidate();
						reservePanel.repaint();
						if (reserveList.size() > 0) {
							for (int i = 0; i < reserveList.size(); i++) {
								reserveButtonsToPrint.add(reserveButtonList.get(i));
							}
						}
						reserveButtonsToPrint.forEach((v) -> {
							reservePanel.add(v);
						});
						currDisplay.removeAll();
						validate();
						repaint();
					}
					remove(arrowLabel);
					remove(swapButton);
					if (reserveList.size() > 0) {
						add(arrowLabel);
					}
					if (reserveList.size() > 0) {
						add(swapButton);
						TeamViewPanel.this.setComponentZOrder(swapButton, 0);
					}
					
					
				boolean lost = stadium.checkEnd(store);
				if (lost == true) {
					JOptionPane.showMessageDialog(frame,"Your team does not have enough players to play a match, and the club balance is too low to buy back to 4 players. Game over.");
					FinishPanel finishPanel = new FinishPanel(frame,stadium);
					frame.setContentPane(finishPanel);
					frame.revalidate();
				}	
				}
				
			}
		});
		sellButton.setBounds(22, 247, 171, 23);
		selectedPlayerPanel.add(sellButton);
		
		JButton renameButton = new JButton("Rename Player");
		renameButton.addActionListener(new ActionListener() {
			/**
			 * Creates a textField for name input and a submit button when pressed.
			 */
			public void actionPerformed(ActionEvent e) {
				if (currPlayer == null) {
					JOptionPane.showMessageDialog(frame, "Please select a player");
					return;
				}
				textField = new JTextField();
				textField.setBounds(932, 558, 127, 20);
				add(textField);
				textField.setColumns(10);
				revalidate();
				repaint();
				submitButton = new JButton("Submit");
				submitButton.setBounds(1058, 558, 89, 20);
				add(submitButton);
				submitButton.addActionListener(new ActionListener() {
					/**
					 * Checks the name length for compliance and checks if special characters are used.
					 * Renames the current player by removing the object from the list and creating a new athlete with the same stats but a different name.
					 * @param e
					 */
					public void actionPerformed(ActionEvent e) {
						newname = textField.getText();
						if (newname.length() < 3 || newname.length() > 15) {
							JOptionPane.showMessageDialog(frame, "Please enter a name between 3 and 15 characters.");
							return;
						}
						if (stadium.club.athleteList.containsKey(newname)) {
							JOptionPane.showMessageDialog(frame, newname + " Is already in your team. Please enter a unique name.");
							return;
						}
						Boolean hasSpecial = false;
				 		for (int i = 0; i < newname.length(); i++) {
				 			if (!Character.isLetter(newname.toLowerCase().charAt(i)) && !Character.isDigit(newname.charAt(i)) && !Character.isWhitespace(newname.charAt(i))) {
				 				hasSpecial = true;
				 			}
				 		}
				 		if (hasSpecial == true) {
				 			JOptionPane.showMessageDialog(frame, "Please Enter a Name that contains no special characters");
				 			return;
				 		}
						if (stadium.club.starterList.contains(currPlayer)) {
							stadium.club.starterList.remove(currPlayer.name);
							stadium.club.athleteList.remove(currPlayer.name);
							currPlayer.name = newname;
							stadium.club.addPlayer(currPlayer);
							
						}
						else if (stadium.club.reserveList.contains(currPlayer)) {
							stadium.club.reserveList.remove(currPlayer.name);
							stadium.club.athleteList.remove(currPlayer.name);
							currPlayer.name = newname;
							stadium.club.addPlayer(currPlayer);
						}
						
						/**
						 * Refreshes all the containers of athleteDisplays to reflect the changes in the club.
						 */
						currDisplay.removeAll();
						starterList.clear();
						playerListPanel.removeAll();
						stadium.club.starterList.forEach((k, v) -> {
							starterList.add(v);   
						});
						starterList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							playerListPanel.add(athleteDisplay);
							playerListPanel.revalidate();
						});
						reserveList.clear();
						reserveListPanel.removeAll();
						stadium.club.reserveList.forEach((k, v) -> {
							reserveList.add(v);   
						});
						reserveList.forEach((v) -> {
							AthleteDisplay athleteDisplay = new AthleteDisplay(v);
							reserveListPanel.add(athleteDisplay);
							reserveListPanel.revalidate();
						});
						AthleteDisplay newAth = new AthleteDisplay(currPlayer);
						currDisplay.add(newAth);
						TeamViewPanel.this.remove(textField);
						TeamViewPanel.this.remove(submitButton);
						revalidate();
						repaint();
						
					}
				});
				
				
				
			}
		});
		renameButton.setBounds(22, 271, 171, 23);
		selectedPlayerPanel.add(renameButton);
		
		JLabel selectedPlayerLabel = new JLabel("Selected Player");
		selectedPlayerLabel.setBounds(932, 199, 215, 27);
		add(selectedPlayerLabel);
		selectedPlayerLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		
		
		
		JLabel weekLabel = new JLabel("Week " + stadium.currWeek + " / " + stadium.weeksToPlay);
		weekLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		weekLabel.setBounds(910, 33, 130, 23);
		TeamViewPanel.this.add(weekLabel);
		
		/**
		 * Adds correct buttons that need to be printed based on the length of the starter list and the reserve list.
		 */
		
		if (starterList.size() > 0) {
			for (int i = 0; i < starterList.size(); i++) {
				starterButtonsToPrint.add(starterButtonList.get(i));
			}
		}
		
		starterButtonsToPrint.forEach((v) -> {
			starterPanel.add(v);
		});
		
		if (reserveList.size() > 0) {
			for (int i = 0; i < reserveList.size(); i++) {
				reserveButtonsToPrint.add(reserveButtonList.get(i));
			}
		}
		
		reserveButtonsToPrint.forEach((v) -> {
			reservePanel.add(v);
		});
		
		
		

	}
	
}
