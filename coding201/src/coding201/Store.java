package coding201;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
public class Store {
	
	Hashtable<String, Athlete> playersInTeam =  new Hashtable<>();
	Hashtable<String, Athlete> playerHashTable =  new Hashtable<>();
	Hashtable<String, Integer> itemHashtable = new Hashtable<>();
	PlayerClub myClub;
	
	public Store(PlayerClub myClub) {
		
		this.myClub = myClub;
	}
	public void refreshStore() {
		purchaseableAthletes playerHashTables = new purchaseableAthletes();
		playerHashTable = playerHashTables.addPurchasablePlayers();
	}
	
	public void purchaseAthlete() {
		purchaseAthlete athlete = new purchaseAthlete(playerHashTable,myClub);
		myClub.balance = athlete.purchaseAthletes();
	}
	public void sellPlayer() {
		sellPlayer playerSold = new sellPlayer(myClub);
		myClub.balance = playerSold.playerSell();
		
		
	}
	
	public int purchaseItem() {
		Integer ting = 5;
		return ting;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
