package coding201;
import java.util.ArrayList;
import java.util.Hashtable;

public class gameEnvironment {
	String clubName;
	double difficulty;
	int money = 198;
	
	Hashtable<String, String> playerHashTable = new Hashtable<>();
	Hashtable<String, String> athletesOnTeam = new Hashtable<>();
	ArrayList<Athlete> purchasableAthletes = new ArrayList<Athlete>();
	ArrayList<Athlete> athletesinClub = new ArrayList<Athlete>();
	
	
	
	
	public void getDetails(clubSetup myClub) {
		clubName = myClub.clubName();
		difficulty = myClub.setDifficulty();
		money = myClub.getMoney();
		athletesOnTeam = myClub.getPlayers();
		
	}
	public Hashtable<String, String> addPurchasablePlayers(PionelPessi pepsi, PistaPenaldo penaldo, GuiltySiggurdson child, Darwizzey darwin) {
		playerHashTable.put(pepsi.getName(), pepsi.getHashtable());
		playerHashTable.put(penaldo.getName(), penaldo.getHashtable());
		playerHashTable.put(child.getName(), child.getHashtable());
		playerHashTable.put(darwin.getName(), darwin.getHashtable());
		

		return playerHashTable;
	}
	public void storeMethod() {
		Store store = new Store(playerHashTable, money, athletesOnTeam);
		money = store.purchaseAthlete();
		System.out.println(money);
	}
	
	
	public static void main(String[] args) {
		
		
		gameEnvironment helloEnvironment = new gameEnvironment();
		clubSetup myClub = new clubSetup();
		helloEnvironment.getDetails(myClub);
		
		
		
		AthleteDatabase ting = new AthleteDatabase();
		Athlete nignog = ting.getAthlete(myClub.difficultyMultiplier);
		System.out.println(nignog);
		
		
//		
		
		
		
//		PionelPessi pepsi = new PionelPessi();
//		PistaPenaldo penaldo = new PistaPenaldo();
//		GuiltySiggurdson child = new GuiltySiggurdson(); 
//		Darwizzey darwin = new Darwizzey();
//		helloEnvironment.addPurchasablePlayers(pepsi, penaldo, child, darwin);
//		helloEnvironment.storeMethod();
		
		
	}

}
