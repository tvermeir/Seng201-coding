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

public class StorePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	mainFrame frame;
	
	public StorePanel(Stadium stadium, Store store, mainFrame frame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Store");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(432, 5, 203, 47);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(167, 108, 511, 147);
		add(panel);
		panel.setLayout(null);
		
		JPanel playersInStorePanel = new JPanel();
		playersInStorePanel.setBounds(10, 7, 496, 132);
		panel.add(playersInStorePanel);
		playersInStorePanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		store.playerHashTable.forEach((k, v) -> {
			athleteDisplay athleteDisplay = new athleteDisplay(v);
			playersInStorePanel.add(athleteDisplay);   
		});
		
		JLabel lblNewLabel_1 = new JLabel("Players");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(167, 88, 134, 14);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(167, 292, 511, 147);
		add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 7, 496, 132);
		panel_2.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Items");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(167, 267, 134, 14);
		add(lblNewLabel_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBounds(688, 108, 144, 147);
		add(panel_3);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(10, 7, 124, 132);
		panel_3.add(panel_1_2);
		panel_1_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3_1.setBounds(688, 292, 144, 147);
		add(panel_3_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(10, 7, 124, 132);
		panel_3_1.add(panel_1_2_1);
		panel_1_2_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("PURCHASE");
		btnNewButton.setBounds(840, 292, 89, 147);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PURCHASE");
		btnNewButton_1.setBounds(840, 108, 89, 147);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePanel home = new HomePanel(frame);
				home.setupPanel(stadium, store);
			}
		});
		btnNewButton_2.setBounds(10, 25, 89, 23);
		add(btnNewButton_2);

	}
}
