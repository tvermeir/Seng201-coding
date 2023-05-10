package coding201;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

 
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainFrame extends JFrame {

    JPanel contentPane;
    
    

    /**
     * Launch the application.
     */
    
    
//    public void setstore() {
//        StoreScreen store = new StoreScreen(this);
//        this.setContentPane(store);
//        this.revalidate();
//        
//    }
//    
//    public void setmain() {
//        MainScreen main = new MainScreen(this);
//        this.setContentPane(main);
//        this.revalidate();
//        
//    }

    /**
     * Create the frame.
     */
    public mainFrame() {
    	
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        

        setContentPane(contentPane);
       
        contentPane.setLayout(null);
        
        JLabel titleLabel = new JLabel("Sunday League Simulator",SwingConstants.CENTER);
        titleLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 33));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 11, 1254, 173);
        contentPane.add(titleLabel);
  
        
        
        JButton playButton = new JButton("Play");
       playButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setupClub();
        	}
        });
        playButton.setFont(new Font("Bahnschrift", Font.PLAIN, 38));
        playButton.setBounds(503, 372, 227, 116);
  
        contentPane.add(playButton);
        
       
 
        
    }
    public void setupClub() {
    	clubSetupFrame club = new clubSetupFrame(this);
    	this.setContentPane(club);
        this.revalidate();
    }
    
    public static void main(String[] args) {
        
     mainFrame frame = new mainFrame();
    //frame.setstore();
    
    
    frame.setVisible(true);
             
    }
}