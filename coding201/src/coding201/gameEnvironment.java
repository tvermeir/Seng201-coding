package coding201;
import java.util.ArrayList;

public class gameEnvironment {
	String clubName;
	double difficulty;
	int money;
	
	ArrayList<Athlete> purchasableAthletes = new ArrayList<Athlete>();
	ArrayList<Athlete> athletesinClub = new ArrayList<Athlete>();
	
	
	
	public void getDetails(clubSetup myClub) {
		clubName = myClub.clubName();
		difficulty = myClub.setDifficulty();
		money = myClub.getMoney();
		
	}
	public void addPurchasablePlayers(PionelPessi pepsi, PistaPenaldo penaldo, GuiltySiggurdson child, Darwizzey darwin) {
		purchasableAthletes.add(pepsi);
		purchasableAthletes.add(penaldo);
		purchasableAthletes.add(child);
		purchasableAthletes.add(darwin);
		System.out.println(purchasableAthletes);
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
		
		
	}

}
