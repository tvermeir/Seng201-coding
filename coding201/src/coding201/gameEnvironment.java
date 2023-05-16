package coding201;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JFrame;


/**
 * Creates the game 
 * Initializes all other classes in the code by calling them in a specific order as per requirements
 * 
 *
 */
public class gameEnvironment {
	String clubName;
	
	double difficulty;
	int money = 198;
	
	Hashtable<String, Athlete> athletesOnTeam = new Hashtable<>();
	Hashtable<String, String> reserveListHashtable = new Hashtable<>();
	Hashtable<String, String> opposingTeam = new Hashtable<>();
	Hashtable<String, opposingTeam> possibleMatches = new Hashtable<>();
	
	
	/**
	 * Gathers details about the club from the user
	 * Such as, the name, the number of weeks they would like to play and the difficulty by utilizing scanners
	 * 
	 * 
	 * @param myClub the clubSetup class
	 * @return the complete and setup Club belonging to the user
	 */
	public mainFrame gameFrame(){
		mainFrame frame = new mainFrame();
		return frame;
	}
	public PlayerClub getDetails(clubSetup myClub) {
		
		//clubName = myClub.clubName;
		
		clubName = myClub.clubName;
		System.out.println(clubName);
		//difficulty = myClub.setDifficulty();
		money = myClub.getMoney();
		athletesOnTeam = myClub.getPlayers();
		PlayerClub userClub = new PlayerClub(money, clubName, athletesOnTeam);
		return userClub;
		
	}
	/**
	 * Returns an instance of the stadium class that can be used across all other classes
	 * It creates a hashtable of 3 different teams
	 * The user can select what team they would like to play against 
	 * This team is returned and then passed into the matchRunner class
	 * @return an instance of the Stadium class
	 * 
	 */
	public Stadium stadiumMethod(PlayerClub club) {
		Stadium stad = new Stadium(club);

		stad.fillOpponentTable();
		possibleMatches = stad.selectedTeam();
		

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
	 * @param myClub
	 * @return the store
	 */
	public Store storeMethod(PlayerClub myClub) {
		Store store = new Store(myClub);
		return store;
		
	}
	/**
	 * The match runner class is initialized within this method
	 * before being called inside the main function
	 * 
	 * It takes in a singular parameter, a PlayerClub
	 * which is passed into the match runner as it contains the complete list
	 * of players in the user's club
	 * 
	 * An opposing team class is also intialised here, to pass in the opposition team
	 * so a match can occur
	 * 
	 * @param myClub a PlayerClub setup in the getDetails() method
	 * @return match an instance of the matchrunner class
	 */
	
	public matchRunner startMatch(PlayerClub myClub) {
		opposingTeam opps = new opposingTeam();
		opps.Fill();
		matchRunner match = new matchRunner(myClub, opps);
		return match;
	}
	//public matchRunner matchMethod() {
		//matchRunner match = new matchRunner(athletesOnTeam, opposingTeam)
	//}
	
	
	
	public static void main(String[] args) {
		
		//Game Setup
		
		gameEnvironment helloEnvironment = new gameEnvironment();
		
		clubSetup myClub = new clubSetup();
	    PlayerClub userClub = helloEnvironment.getDetails(myClub);

		
		Stadium stadium = helloEnvironment.stadiumMethod(userClub);
		Store store = helloEnvironment.storeMethod(userClub);

		mainFrame pleaseFrame = new mainFrame();
		pleaseFrame.setupFrame(stadium, store, userClub);
		pleaseFrame.setVisible(true);

		//matchRunner match = helloEnvironment.startMatch(userClub, opposition );
		
		//Store Method 
		//Store store = helloEnvironment.storeMethod(userClub);
		//store.refreshStore();

//		System.out.println("Welcome to sunday league simulator 2023");
//	    System.out.println("To start the game, you need to set up your club.");
	    
	    //Club setup
	   
	    
	    
	    
	    //System.out.println("Awesome, you have created a club called " + userClub.getName()  + ". The club has a balance of " + userClub.getBalance());
	    
	    //Store setup
	    
//		Store store = helloEnvironment.storeMethod(userClub);
//		store.refreshStore();
		
		
		
		//store.purchaseAthlete();

		
		
		
//		matchRunner game = helloEnvironment.startMatch(userClub);
//		game.playMatch();
		
//		System.out.println(userClub.printAthleteList());
//		
//		userClub.doRandomEvent();
//		
//		System.out.println(userClub.printAthleteList());
		
		
		
		//store.purchaseAthlete();
		//System.out.println(userClub.balance);
		//store.sellPlayer();
		//System.out.println(userClub.balance);

//		store.purchaseAthlete();

//		System.out.println(userClub.balance);
//		store.sellPlayer();
//		

		//Dint balance = userClub.balance ; // Initialize the balance variable

	    

	    //Scanner scanner = new Scanner(System.in);

	    

	    // Main game loop
	    //while (true) {
	      //System.out.println("Enter a command:");
	      //String input = scanner.nextLine();

	    
	    
//	    while (true) {
//	      
//	    Scanner scanner = new Scanner(System.in);
//	      
//	      String input = scanner.nextLine();

	      
	      // Check if the user has typed "get balance"

	      //if (input.equals("get balance") && userClub != null) {
	        //System.out.println("Your team's balance is: " + balance);
	      //}
	     // else if (input.equals("setup club")) {
	    	//gameEnvironment helloEnvironment = new gameEnvironment();
	  		//clubSetup myClub = new clubSetup();
	  		//PlayerClub userClub = helloEnvironment.getDetails(myClub);
	      //}
		  
		  //}



	      

		//store.purchaseItem();
		//System.out.println(userClub.balance);
	}
}



