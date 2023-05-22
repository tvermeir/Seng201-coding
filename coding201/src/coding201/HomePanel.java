package coding201;

/**
 * HomePanel
 *This is the main panel of the program, created after the club setup has been done. It contains 4 buttons, one to enter the store, one to enter the team view, one
 *to enter the stadium and one to exit the game. 
 *@version 1.0
 *@author tve21 & bro82
 */


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePanel extends JPanel {
	
	mainFrame frame;
	/**\
	 * The constructor here takes in the mainFrame class and adds the panel to it in the method setupPanel
	 * 
	 * @param mainFrame frame: takes in an instance of the mainFram class so that components can be added to it
	 * 
	 */
	public HomePanel (mainFrame frame) {
		this.frame = frame;
		
		
	}
	/**\
	 * The constructor here takes in the mainFrame class and adds the panel to it in the method setupPanel
	 * 
	 * @param mainFrame frame: takes in an instance of the mainFram class so that components can be added to it
	 * 
	 */
	public void setupPanel(Stadium stadium, Store store) {
		frame.setBounds(0,0, 1280, 720);
		frame.getContentPane().setLayout(null);
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(500, 500, 1280, 720);
		mainPanel.setLayout(null);
		
		 frame.setContentPane(mainPanel);
		 frame.revalidate();
		 
		 JLabel titleLabel = new JLabel("Home Screen");
		 titleLabel.setFont(new Font("Dialog", Font.PLAIN, 33));
		 titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 titleLabel.setBounds(526, 43, 232, 39);
		 mainPanel.add(titleLabel);
		 
		 
		JLabel balancelbl = new JLabel("Balance: " + stadium.club.balance);
		balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		balancelbl.setBounds(1050, 33, 144, 23);
		mainPanel.add(balancelbl);
			
		JLabel weekLabel = new JLabel("Week " + stadium.currWeek + " / " + stadium.weeksToPlay);
		weekLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		weekLabel.setBounds(932, 33, 108, 23);
		mainPanel.add(weekLabel);
		 
		 JButton btnTeamView = new JButton("Team View");
		 btnTeamView.addActionListener(new ActionListener() {
			 /* Before entering the TeamViewPanel class, the weeks are checked to make sure the current number of weeks
			  * is less than the required number of weeks. If it is not, the teamViewPanel is loaded. If it is, the finishPanel
			  * is loaded.*/
		 	public void actionPerformed(ActionEvent e) {
		 		if(stadium.currWeek < stadium.weeksToPlay) {
					
		 			TeamViewPanel teamView = new TeamViewPanel(stadium, store, frame);
			 		frame.setContentPane(teamView);
			 		frame.validate();
				}
				else {
					JOptionPane.showMessageDialog(frame,"All weeks have passed! Game has ended");
					FinishPanel finishPanel = new FinishPanel(frame,stadium);
					frame.setContentPane(finishPanel);
				}
		 		
		 	}
		 });
		 btnTeamView.setFont(new Font("Dialog", Font.PLAIN, 22));
		 btnTeamView.setBounds(470, 222, 336, 273);
		 mainPanel.add(btnTeamView);
		 
		 JButton btnStadium = new JButton("Stadium");
		 btnStadium.addActionListener(new ActionListener() {
			 /* Before entering the StadiumPanel class, the weeks are checked to make sure the current number of weeks
			  * is less than the required number of weeks. If it is not, the StadiumPanel is loaded. If it is, the finishPanel
			  * is loaded.*/
		 	public void actionPerformed(ActionEvent e) {
		 		if(stadium.currWeek < stadium.weeksToPlay) {
					
		 			StadiumPanel stadiumPanel = new StadiumPanel(stadium, store, frame);
			 		frame.setContentPane(stadiumPanel);
				}
				else {
					JOptionPane.showMessageDialog(frame,"All weeks have passed! Game has ended");
					FinishPanel finishPanel = new FinishPanel(frame,stadium);
					frame.setContentPane(finishPanel);
				}
		 		
		 	}
		 });
		 btnStadium.setFont(new Font("Dialog", Font.PLAIN, 22));
		 btnStadium.setBounds(40, 222, 336, 273);
		 mainPanel.add(btnStadium);
		 
		 JButton btnStore = new JButton("Store");
		 btnStore.addActionListener(new ActionListener() {
			 /* Before entering the StorePanel class, the weeks are checked to make sure the current number of weeks
			  * is less than the required number of weeks. If it is not, the Store Panel is loaded. If it is, the finishPanel
			  * is loaded.*/
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		if(stadium.currWeek < stadium.weeksToPlay) {
					
		 			StorePanel storePanel = new StorePanel(stadium, store, frame);
			 		frame.setContentPane(storePanel);
			 		frame.revalidate();
				}
				else {
					JOptionPane.showMessageDialog(frame,"All weeks have passed! Game has ended");
					FinishPanel finishPanel = new FinishPanel(frame,stadium);
					frame.setContentPane(finishPanel);
				}
		 		
		 	}
		 });
		 btnStore.setFont(new Font("Dialog", Font.PLAIN, 22));
		 btnStore.setBounds(904, 222, 336, 273);
		 mainPanel.add(btnStore);
		 
		 JButton backButton = new JButton("Quit Game");
			backButton.addActionListener(new ActionListener() {
				 /*Loads the FinishPanel up if the user desires to quit the game*/
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frame,"Game has ended");
					FinishPanel finishPanel = new FinishPanel(frame,stadium);
					frame.setContentPane(finishPanel);
				}
			});
			backButton.setBounds(10, 25, 100, 23);
			mainPanel.add(backButton);
		 
		 
		 
		 
	}
}
