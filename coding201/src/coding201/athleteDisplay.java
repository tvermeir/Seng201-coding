package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
/**
 * athleteDisplay
 * This extension of JPanel is used throughout the game to visually represent an athlete and their stats. 
 * @version 1.0
 * @author tve21 & bro82
 *
 */
public class athleteDisplay extends JPanel {

	/**
	 * Creates a visual representation of a player, including their stats along with a buy and sellback price.
	 */
	public athleteDisplay(Athlete athlete) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Attack");
		lblNewLabel_1.setBounds(16, 72, 60, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Defense");
		lblNewLabel_2.setBounds(16, 88, 60, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Stamina");
		lblNewLabel_3.setBounds(16, 104, 60, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel(Integer.toString(athlete.getStamina()));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(78, 104, 46, 14);
		if (athlete.stamina == 0) {
			lblNewLabel_3_1.setText("Injured");
		}
		
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(Integer.toString(athlete.getDefense()));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(78, 88, 46, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(Integer.toString(athlete.getAttack()));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(78, 72, 46, 14);
		add(lblNewLabel_1_1);
		
		JTextArea txtrHi = new JTextArea();
		txtrHi.setForeground(new Color(128, 0, 0));
		txtrHi.setEditable(false);
		txtrHi.setWrapStyleWord(true);
		txtrHi.setLineWrap(true);
		txtrHi.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		txtrHi.setText(athlete.name);
		txtrHi.setColumns(1);
		txtrHi.setRows(2);
		txtrHi.setBounds(16, 11, 108, 62);
		add(txtrHi);
		
		JLabel lblNewLabel_3_2 = new JLabel("Price");
		lblNewLabel_3_2.setBounds(16, 120, 60, 14);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(Integer.toString(athlete.getPrice()));
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setBounds(78, 120, 46, 14);
		add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Sell Price");
		lblNewLabel_3_2_1.setBounds(16, 135, 60, 14);
		add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel(Integer.toString(athlete.sellPrice));
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setBounds(78, 135, 46, 14);
		add(lblNewLabel_3_1_1_1);
		
		
		

	}
}
