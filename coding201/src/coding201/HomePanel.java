package coding201;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFrameLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePanel extends JPanel {
	
	mainFrame frame;
	
	public HomePanel (mainFrame frame) {
		this.frame = frame;
		
		
	}
	
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
		 
		 
		 JButton btnTeamView = new JButton("Team View");
		 btnTeamView.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		TeamViewPanel teamView = new TeamViewPanel(stadium, store, frame);
		 		frame.setContentPane(teamView);
		 		frame.validate();
		 	}
		 });
		 btnTeamView.setFont(new Font("Dialog", Font.PLAIN, 22));
		 btnTeamView.setBounds(400, 222, 336, 273);
		 mainPanel.add(btnTeamView);
		 
		 JButton btnStadium = new JButton("Stadium");
		 btnStadium.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		StadiumPanel stadiumPanel = new StadiumPanel(stadium, store, frame);
		 		frame.setContentPane(stadiumPanel);
		 	}
		 });
		 btnStadium.setFont(new Font("Dialog", Font.PLAIN, 22));
		 btnStadium.setBounds(40, 222, 336, 273);
		 mainPanel.add(btnStadium);
		 
		 JButton btnStore = new JButton("Store");
		 btnStore.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		StorePanel storePanel = new StorePanel(stadium, store, frame);
		 		frame.setContentPane(storePanel);
		 		frame.revalidate();
		 	}
		 });
		 btnStore.setFont(new Font("Dialog", Font.PLAIN, 22));
		 btnStore.setBounds(904, 222, 336, 273);
		 mainPanel.add(btnStore);
		 
		 
		 
		 
	}
}
