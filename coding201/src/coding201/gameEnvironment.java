package coding201;
import java.util.Hashtable;

public class gameEnvironment {
	String clubName;
	double difficulty;
	int money = 198;
	
	Hashtable<String, String> athletesOnTeam = new Hashtable<>();
	Hashtable<String, String> reserveListHashtable = new Hashtable<>();
	Hashtable<String, String> opposingTeam = new Hashtable<>();
	Hashtable<String, opposingTeam> possibleMatches = new Hashtable<>();
	
	
	
	public void getDetails(clubSetup myClub) {
//		clubName = myClub.clubName();
//		difficulty = myClub.setDifficulty();
//		money = myClub.getMoney();
		athletesOnTeam = myClub.getPlayers();
		
	}
	public void possibleOpponents() {
		Stadium stad = new Stadium();
		possibleMatches = stad.fillOpponentTable();
		System.out.println(possibleMatches);
	
	}
	public opposingTeam opposingTeamMethod() {
		opposingTeam team = new opposingTeam(clubName, null)
	}
	
	public Store storeMethod() {
		Store store = new Store(money, athletesOnTeam);
		return store;
		
	}
	//public matchRunner matchMethod() {
		//matchRunner match = new matchRunner(athletesOnTeam, opposingTeam)
	//}
	
	
	
	public static void main(String[] args) {
		
		//Club Setup
		gameEnvironment helloEnvironment = new gameEnvironment();
		clubSetup myClub = new clubSetup();
		helloEnvironment.getDetails(myClub);
		
		helloEnvironment.possibleOpponents();
		
		
		//Store Method 
		//Store store = helloEnvironment.storeMethod();
		//store.refreshStore();
		//If button is pressed {helloEnvironment.money = store.purchaseAthlete();
		// If week, store.refreshStore();
		//helloEnvironment.money = store.purchaseAthlete();
		System.out.println(helloEnvironment.money);
		//helloEnvironment.money = store.sellPlayer();
		System.out.println(helloEnvironment.money);
		
		
	}

}
