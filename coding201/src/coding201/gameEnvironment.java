package coding201;
import java.util.Hashtable;
import java.util.Scanner;
public class gameEnvironment {
	String clubName;
	double difficulty;
	int money = 198;
	
	Hashtable<String, Athlete> athletesOnTeam = new Hashtable<>();
	Hashtable<String, String> reserveListHashtable = new Hashtable<>();
	Hashtable<String, String> opposingTeam = new Hashtable<>();
	Hashtable<String, opposingTeam> possibleMatches = new Hashtable<>();
	
	
	
	public PlayerClub getDetails(clubSetup myClub) {
//		clubName = myClub.clubName();
//		difficulty = myClub.setDifficulty();
//		money = myClub.getMoney();
		athletesOnTeam = myClub.getPlayers();
		PlayerClub userClub = new PlayerClub(money, clubName, athletesOnTeam);
		return userClub;
		
	}
	
	public void possibleOpponents() {
		Stadium stad = new Stadium();
		possibleMatches = stad.fillOpponentTable();
		System.out.println(possibleMatches);
	
	}
	//public opposingTeam opposingTeamMethod() {
		//opposingTeam team = new opposingTeam(clubName, null);
	//}
	
	public Store storeMethod(PlayerClub myClub) {
		Store store = new Store(myClub);
		return store;
		
	}
	//public matchRunner matchMethod() {
		//matchRunner match = new matchRunner(athletesOnTeam, opposingTeam)
	//}
	
	
	
	public static void main(String[] args) {
		
		//Club Setup
		
		
		//helloEnvironment.possibleOpponents();
		
		
		//Store Method 
		Store store = helloEnvironment.storeMethod(userClub);
		store.refreshStore();
		//If button is pressed {helloEnvironment.money = store.purchaseAthlete();
			// If week, store.refreshStore();
//		store.purchaseAthlete();
//		System.out.println(userClub.balance);
//		store.sellPlayer();
//		
		int balance = userClub.balance ; // Initialize the balance variable
	    
	    Scanner scanner = new Scanner(System.in);
	    
	    // Main game loop
	    while (true) {
	      System.out.println("Enter a command:");
	      String input = scanner.nextLine();
	      
	      // Check if the user has typed "get balance"
	      if (input.equals("get balance") && userClub != null) {
	        System.out.println("Your team's balance is: " + balance);
	      }
	      else if (input.equals("setup club")) {
	    	gameEnvironment helloEnvironment = new gameEnvironment();
	  		clubSetup myClub = new clubSetup();
	  		PlayerClub userClub = helloEnvironment.getDetails(myClub);
	      }
		  
		  }
	      
	      // Other game commands...
	    
		
		
		store.purchaseItem();
		System.out.println(userClub.balance);
	}

}
