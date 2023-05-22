package coding201;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ItemDisplay extends JPanel {

	/**
	 * Creates a visual representation fo the purchaseableItem object, including all the stats.
	 * @param item
	 */
	public ItemDisplay(PurchaseableItem item) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(item.name);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNewLabel.setBounds(3, 5, 126, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(13, 115, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Integer.toString(item.price));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(72, 115, 46, 14);
		add(lblNewLabel_2);
		
		JTextArea txtrH = new JTextArea();
		txtrH.setForeground(Color.GRAY);
		txtrH.setText(item.info);
		txtrH.setRows(4);
		txtrH.setLineWrap(true);
		txtrH.setWrapStyleWord(true);
		txtrH.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrH.setEditable(false);
		txtrH.setBounds(11, 41, 110, 72);
		add(txtrH);

	}
}
