package coding201;
import java.util.ArrayList;
import java.util.Hashtable;

public class gameEnvironment {
	String clubName;
	double difficulty;
	int money;
	
	Hashtable<String, String> playerHashTable = new Hashtable<>();
	
	ArrayList<Athlete> purchasableAthletes = new ArrayList<Athlete>();
	ArrayList<Athlete> athletesinClub = new ArrayList<Athlete>();
	
	
	
	
	public void getDetails(clubSetup myClub) {
		clubName = myClub.clubName();
		difficulty = myClub.setDifficulty();
		money = myClub.getMoney();
		
	}
	public Hashtable<String, String> addPurchasablePlayers(PionelPessi pepsi, PistaPenaldo penaldo, GuiltySiggurdson child, Darwizzey darwin) {
		playerHashTable.put(pepsi.getName(), pepsi.getHashtable());
		playerHashTable.put(penaldo.getName(), penaldo.getHashtable());
		playerHashTable.put(child.getName(), child.getHashtable());
		playerHashTable.put(darwin.getName(), darwin.getHashtable());
		

		return playerHashTable;
	}
	public void storeMethod() {
		Store store = new Store(playerHashTable, money);
		store.purchaseAthlete();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		gameEnvironment helloEnvironment = new gameEnvironment();
		clubSetup myClub = new clubSetup();
		
		
		PlayerClub playerClub = new PlayerClub(helloEnvironment.money, helloEnvironment.clubName, null);
		//helloEnvironment.getDetails(myClub);
		
		
		
		PionelPessi pepsi = new PionelPessi();
		PistaPenaldo penaldo = new PistaPenaldo();
		GuiltySiggurdson child = new GuiltySiggurdson(); 
		Darwizzey darwin = new Darwizzey();
		helloEnvironment.addPurchasablePlayers(pepsi, penaldo, child, darwin);
		helloEnvironment.storeMethod();
		
		
	}

}
