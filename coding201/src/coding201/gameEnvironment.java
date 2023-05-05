package coding201;
import java.util.Hashtable;

import javax.swing.text.Position;

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
	
	public opposingTeam possibleOpponents() {
		Stadium stad = new Stadium();
		possibleMatches = stad.fillOpponentTable();
		System.out.println(possibleMatches);
		return possibleMatches;
	
	}
	//public opposingTeam opposingTeamMethod() {
		//opposingTeam team = new opposingTeam(clubName, null);
	//}
	
	public Store storeMethod(PlayerClub myClub) {
		Store store = new Store(myClub);
		return store;
		
	}
	
	public matchRunner startMatch(PlayerClub myClub, opposingTeam opposition) {
		
		matchRunner match = new matchRunner(myClub, opposition);
		return match;
	}
	//public matchRunner matchMethod() {
		//matchRunner match = new matchRunner(athletesOnTeam, opposingTeam)
	//}
	
	
	
	public static void main(String[] args) {
		
		//Club Setup
		gameEnvironment helloEnvironment = new gameEnvironment();
		clubSetup myClub = new clubSetup();
		PlayerClub userClub = helloEnvironment.getDetails(myClub);
		
		opposingTeam opposition = helloEnvironment.possibleOpponents();
		
		matchRunner match = helloEnvironment.startMatch(userClub, opposition );
		
		//Store Method 
		//Store store = helloEnvironment.storeMethod(userClub);
		//store.refreshStore();
		//If button is pressed {helloEnvironment.money = store.purchaseAthlete();
			// If week, store.refreshStore();
		//store.purchaseAthlete();
		//System.out.println(userClub.balance);
		//store.sellPlayer();
		//System.out.println(userClub.balance);
		
		
	}

}
