package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
/**
 * AthleteDisplay
 *The class that creates a visual representation of an Athlete object
 *@version 1.0
 *@author tve21 & bro82
 */
public class athleteDisplay extends JPanel {

	/**
	 * Creates a visual representation of a player, including their stats along with a buy and sellback price.
	 * @param Athlete: the athlete and his stats that we want to display
	 */
	public athleteDisplay(Athlete athlete) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel attackLabel = new JLabel("Attack");
		attackLabel.setBounds(16, 72, 60, 14);
		add(attackLabel);
		
		JLabel defenseLabel = new JLabel("Defense");
		defenseLabel.setBounds(16, 88, 60, 14);
		add(defenseLabel);
		
		JLabel staminaLabel = new JLabel("Stamina");
		staminaLabel.setBounds(16, 104, 60, 14);
		add(staminaLabel);
		
		JLabel staminaValue = new JLabel(Integer.toString(athlete.getStamina()));
		staminaValue.setHorizontalAlignment(SwingConstants.CENTER);
		staminaValue.setBounds(78, 104, 46, 14);
		if (athlete.stamina == 0) {
			staminaValue.setText("Injured");
		}
		
		add(staminaValue);
		
		JLabel defenseValue = new JLabel(Integer.toString(athlete.getDefense()));
		defenseValue.setHorizontalAlignment(SwingConstants.CENTER);
		defenseValue.setBounds(78, 88, 46, 14);
		add(defenseValue);
		
		JLabel attackValue = new JLabel(Integer.toString(athlete.getAttack()));
		attackValue.setHorizontalAlignment(SwingConstants.CENTER);
		attackValue.setBounds(78, 72, 46, 14);
		add(attackValue);
		
		JTextArea nameTextField = new JTextArea();
		nameTextField.setForeground(new Color(128, 0, 0));
		nameTextField.setEditable(false);
		nameTextField.setWrapStyleWord(true);
		nameTextField.setLineWrap(true);
		nameTextField.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		nameTextField.setText(athlete.name);
		nameTextField.setColumns(1);
		nameTextField.setRows(2);
		nameTextField.setBounds(16, 11, 108, 62);
		add(nameTextField);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(16, 120, 60, 14);
		add(priceLabel);
		
		JLabel priceValue = new JLabel(Integer.toString(athlete.getPrice()));
		priceValue.setHorizontalAlignment(SwingConstants.CENTER);
		priceValue.setBounds(78, 120, 46, 14);
		add(priceValue);
		
		JLabel sellPriceLabel = new JLabel("Sell Price");
		sellPriceLabel.setBounds(16, 135, 60, 14);
		add(sellPriceLabel);
		
		JLabel sellValue = new JLabel(Integer.toString(athlete.sellPrice));
		sellValue.setHorizontalAlignment(SwingConstants.CENTER);
		sellValue.setBounds(78, 135, 46, 14);
		add(sellValue);
		
		
		

	}
}
