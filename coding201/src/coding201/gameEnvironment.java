package coding201;
import java.util.Hashtable;



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
//		athletesOnTeam = myClub.getPlayers();
		PlayerClub userClub = new PlayerClub(money, clubName);
		System.out.println(userClub.balance);
		userClub.Fill();
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
	
//	public matchRunner startMatch(PlayerClub myClub) {
//		opposingTeam opps = new opposingTeam();
//		opps.Fill();
<<<<<<< HEAD
//		matchRunner match = new matchRunner(myClub, opps);
//		return match;
	//}
=======
////		matchRunner match = new matchRunner(myClub, opps);
//		return match;
//	}
>>>>>>> branch 'main' of https://github.com/tvermeir/Seng201-coding.git
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

		
	}
}



