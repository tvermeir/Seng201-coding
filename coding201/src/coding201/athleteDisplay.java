package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;

public class athleteDisplay extends JPanel {

	/**
	 * Create the panel.
	 */
	public athleteDisplay(Athlete athlete) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Attack");
		lblNewLabel_1.setBounds(16, 54, 60, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Defense");
		lblNewLabel_2.setBounds(16, 79, 60, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Stamina");
		lblNewLabel_3.setBounds(16, 104, 60, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel(Integer.toString(athlete.getStamina()));
		lblNewLabel_3_1.setBounds(78, 104, 46, 14);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(Integer.toString(athlete.getDefense()));
		lblNewLabel_2_1.setBounds(78, 79, 46, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(Integer.toString(athlete.getAttack()));
		lblNewLabel_1_1.setBounds(78, 54, 46, 14);
		add(lblNewLabel_1_1);
		
		JTextArea txtrHi = new JTextArea();
		txtrHi.setWrapStyleWord(true);
		txtrHi.setLineWrap(true);
		txtrHi.setFont(new Font("Leelawadee", Font.PLAIN, 13));
		txtrHi.setText(athlete.name);
		txtrHi.setColumns(1);
		txtrHi.setRows(2);
		txtrHi.setBounds(16, 11, 108, 38);
		add(txtrHi);
		
		
		

	}
}
