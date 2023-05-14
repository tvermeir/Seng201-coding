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

import java.util.Hashtable;

public class mainFrame extends JFrame {

    JPanel contentPane;
    PlayerClub mainclub;
    Stadium stadium;
    

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
    	
    }
    public void setupFrame(Stadium stadium) {
    	this.stadium = stadium;
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 720);
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
    	JPanel clubPanel = new JPanel();
    	clubSetup club = new clubSetup();
    	club.setupFrame(this, clubPanel, stadium);
    	this.setContentPane(club.clubPanel);
        this.revalidate();
    }
    
    
    public Stadium setupStadium() {
    	Stadium stadium = new Stadium(mainclub);
    	stadium.fillOpponentTable();
    	return stadium;
    	
    }
//    public void showStadium(Stadium stadium) {
//    	StadiumPanel stadpan = new StadiumPanel(stadium);
//    	setContentPane(stadpan);
//    }
//    
    public static void main(String[] args) {
        
     mainFrame frame = new mainFrame();
    //frame.setstore();
    
    
    frame.setVisible(true);
//    frame.setupFrame();
    
    Hashtable<String, Athlete> ting = new Hashtable<>();
    PlayerClub test = new PlayerClub(0, "hi", ting);
    test.Fill();
    frame.mainclub = test;
    Stadium stad = frame.setupStadium();
    frame.showStadium(stad);
    
             
    }
}