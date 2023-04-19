package coding201;
import java.util.Hashtable;

import coding201.StoreClasses.Store;
import coding201.setupGame.clubSetup;

public class gameEnvironment {
	String clubName;
	double difficulty;
	int money = 198;
	
	Hashtable<String, String> athletesOnTeam = new Hashtable<>();
	Hashtable<String, String> reserveListHashtable = new Hashtable<>();
	
	
	
	
	public void getDetails(clubSetup myClub) {
//		clubName = myClub.clubName();
//		difficulty = myClub.setDifficulty();
//		money = myClub.getMoney();
		athletesOnTeam = myClub.getPlayers();
		
	}
	
	public Store storeMethod() {
		Store store = new Store(money, athletesOnTeam);
		return store;
		
	}
	
	
	
	public static void main(String[] args) {
		
		//Club Setup
		gameEnvironment helloEnvironment = new gameEnvironment();
		clubSetup myClub = new clubSetup();
		helloEnvironment.getDetails(myClub);
		
		
		
		
		//Store Method 
		Store store = helloEnvironment.storeMethod();
		store.refreshStore();
		//If button is pressed {helloEnvironment.money = store.purchaseAthlete();
		// If week, store.refreshStore();
		helloEnvironment.money = store.purchaseAthlete();
		System.out.println(helloEnvironment.money);
		helloEnvironment.money = store.purchaseAthlete();
		System.out.println(helloEnvironment.money);
		
		
	}

}
