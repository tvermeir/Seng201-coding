package coding201.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import coding201.code.PlayerClub;
import coding201.code.Stadium;
import coding201.code.Store;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * mainFrame
 * This extension of JFrame is the main window in which the game runs.
 * 
 * @version 1.0
 * @author tve21
 * @author bro82
 *
 */
public class mainFrame extends JFrame {
	/**
	 * Declares the contentpane variable
	 */
    JPanel contentPane;
    /**
     * Declares the player club variable
     */
    PlayerClub mainclub;
    /**
     * Declares the stadium variable
     */
    Stadium stadium;
    /**
     * Declares the store variable
     */
    Store store;

    /**
     * Launch the application.
     */
    
    public mainFrame() {
    	
    }

    /**
     * Sets up the starting JPanel containing the playButton
     * @param stadium an instance of the stadium class
     * @param store an instance of the store class
     * @param userClub an instance of the userClub class
     */
    public void setupFrame(Stadium stadium, Store store, PlayerClub userClub) {
    	this.stadium = stadium;
    	this.mainclub = userClub;
    	this.store = store;
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
    /**
     * Calls the club.setupFrame method which initiates the creation of the player's club
     */
    public void setupClub() {
    	JPanel clubPanel = new JPanel();
    	clubSetup club = new clubSetup();
    	club.setupFrame(this, clubPanel, stadium, mainclub, store);
    	this.setContentPane(club.clubPanel);
        this.revalidate();
    }
    
    /**
     * Creates a stadium object that is used throughout the game.
     * @return stadium
     */
    public Stadium setupStadium() {
    	Stadium stadium = new Stadium(mainclub);
    	stadium.fillOpponentTable();
    	return stadium;
    	
    }
    
 
}