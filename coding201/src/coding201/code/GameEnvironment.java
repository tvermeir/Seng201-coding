package coding201.code;

import coding201.gui.ClubSetup;
import coding201.gui.MainFrame;



/**
 * Game Environment
 * The game environment class initializes all the main code based classes (not swing)  in the code by calling them in a specific order as per requirements
 * before passing the initialized classes into the mainFrame class, creating the JFrame 
 *@version 1.0
 *@author tve21
 *@author bro82
 */
public class GameEnvironment {
	/**
	 * Creates an instance of the mainframe account
	 * This frame instance is used across the whole program and is used to initialize the 
	 * 
	 * 
	 * @return an instance of the mainframe class
	 */
	public MainFrame gameFrame(){
		MainFrame frame = new MainFrame();
		return frame;
	}
	/**
	 * Gathers details about the club from the user
	 * Such as, the name, the number of weeks they would like to play and the difficulty by utilizing scanners
	 * 
	 * 
	 * @param myClub the clubSetup class
	 * @return the complete and setup Club belonging to the user
	 */
	public PlayerClub getDetails(ClubSetup myClub) {
//		clubName = myClub.clubName;
//		money = myClub.getMoney();
		PlayerClub userClub = new PlayerClub(myClub.getMoney(), myClub.clubName);
		userClub.Fill();
		return userClub;
	}
	/**
	 * Returns an instance of the stadium class that can be used across all other classes
	 * It creates a hashtable of 3 different teams
	 * The user can select what team they would like to play against 
	 * This team is returned and then passed into the matchRunner class
	 * @param club an instance of the PlayerClub class
	 * @return an instance of the Stadium class
	 * 
	 */
	public Stadium stadiumMethod(PlayerClub club) {
		Stadium stad = new Stadium(club);
		stad.fillOpponentTable();
		return stad;
	}
	/**
	 * The store class is initialized within this method
	 * before being called inside the main function
	 * 
	 * It takes in a singular parameter, a PlayerClub
	 * which is passed into the store as it contains
	 * the players on the user's team and the items that they have
	 * 
	 * @param myClub and instance of the PlayerClub class
	 * @return store
	 */
	public Store storeMethod(PlayerClub myClub) {
		Store store = new Store(myClub);
		return store;
		
	}
	
	
	/**
	 * The main class here calls the methods above and instantiates the program
	 * It creates the clubSetup, PlayerClub, and gameEnvironment instances 
	 * Before passing them into the setupFrame method of the mainFrame class
	 * 
	 * @param args a string
	 */
	public static void main(String[] args) {
		
		//Game Setup
		
		GameEnvironment helloEnvironment = new GameEnvironment();
		ClubSetup myClub = new ClubSetup();
	    PlayerClub userClub = helloEnvironment.getDetails(myClub);

		
		Stadium stadium = helloEnvironment.stadiumMethod(userClub);
		Store store = helloEnvironment.storeMethod(userClub);

		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setupFrame(stadium, store, userClub);
		mainFrame.setVisible(true);

		
	}
}



