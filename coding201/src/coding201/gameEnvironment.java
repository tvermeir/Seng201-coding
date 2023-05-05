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
		clubName = myClub.clubName();
		difficulty = myClub.setDifficulty();
		money = myClub.getMoney();
		athletesOnTeam = myClub.getPlayers();
		PlayerClub userClub = new PlayerClub(money, clubName, athletesOnTeam);
		return userClub;
		
	}
	
	public Stadium stadiumMethod() {
		Stadium stad = new Stadium();
		return stad;
	
	}
	
	public String getHelp() {
		String helpstring = """
				Here are the commands you can use to navigate the game:
				showteam : shows the current players in the team
				enterstore : enters the store
				exitstore : exits the store
				enterstadium : enters the stadium
				exitstadium : exits the stadium
				""";
		return helpstring;
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
		
		//Game Setup
		
		gameEnvironment helloEnvironment = new gameEnvironment();
		
		System.out.println("Welcome to sunday league simulator 2023");
	    System.out.println("To start the game, you need to set up your club.");
	    
	    //Club setup
	    
	    clubSetup myClub = new clubSetup();
	    PlayerClub userClub = helloEnvironment.getDetails(myClub);
	    System.out.println("Awesome, you have created a club called " + userClub.getName()  + ". The club has a balance of " + userClub.getBalance());
	    
	    //Store setup
	    
		Store store = helloEnvironment.storeMethod(userClub);
		store.refreshStore();
		
		//store.purchaseAthlete();
		
		//Stadium setup
		
		Stadium stadium = helloEnvironment.stadiumMethod();
		
		//If button is pressed {helloEnvironment.money = store.purchaseAthlete();
			// If week, store.refreshStore();
//		
//		System.out.println(userClub.balance);
//		store.sellPlayer();
//		
	    
	    
	    
	    
	    while (true) {
	      
	    Scanner scanner = new Scanner(System.in);
	      
	      String input = scanner.nextLine();
	      
	      // Check if the user has typed "get balance"
	      if (input.equals("get balance") && userClub != null) {
	    	  int balance = userClub.balance;
	    	  System.out.println("Your team's balance is: " + balance);
	      }
	      else if (input.equals("showteam") && userClub != null) {
	    	  System.out.println("These are the players in your team: " + userClub.printAthleteList());
	      }
	      else if (input.equals("enterstore") && userClub != null) {
	    	  store.enterStore();
	      }
	      else if (input.equals("/help") && userClub != null) {
	    	  System.out.println(helloEnvironment.getHelp());
	      }
	      
	      
	      
	      // Other game commands...
	    
		
		
		
	    }
	}
}


