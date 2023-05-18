package coding201;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class clubSetupFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	;
	String clubName;
	JFrame frame = new JFrame();
	private JTextField textField;
	public clubSetupFrame() {
		
		
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
