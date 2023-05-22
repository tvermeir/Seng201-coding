package coding201.gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import coding201.code.PlayerClub;
import coding201.code.Stadium;
import coding201.code.Store;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Hashtable;
/**
 * mainFrame
 * This extension of JFrame is the main window in which the game runs.
 * 
 * @version 1.0
 * @author tve21 & bro82
 *
 */
public class mainFrame extends JFrame {

    JPanel contentPane;
    PlayerClub mainclub;
    Stadium stadium;
    Store store;

    /**
     * Launch the application.
     */
    
    public mainFrame() {
    	
    }

    /**
     * Sets up the starting JPanel containing the playButton
     * @param stadium
     * @param store
     * @param userClub
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
    
    public static void main(String[] args) {
    
             
    }
}