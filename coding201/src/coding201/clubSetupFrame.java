package coding201;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class clubSetupFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	;
	mainFrame frame;
	public clubSetupFrame(mainFrame mainframe) {
		this.frame = mainframe;
		
		 setBounds(500, 500, 1280, 720);
		 setLayout(null);
		 
		 JPanel clubPanel = new JPanel();
		 add(clubPanel);
		 
		 JLabel titleLabel = new JLabel("Setup Your Club!");
		 titleLabel .setFont(new Font("Bahnschrift", Font.PLAIN, 33));
		 titleLabel .setHorizontalAlignment(SwingConstants.CENTER);
		 titleLabel .setBounds(0, 0, 1280, 99);
		 add(titleLabel);
		
	}

}
