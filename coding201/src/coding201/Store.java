package coding201;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
public class Store {
	
	Hashtable<String, Athlete> playersInTeam =  new Hashtable<>();
	Hashtable<String, Athlete> playerHashTable =  new Hashtable<>();
	Hashtable<String, PurchaseableItem> itemHashtable = new Hashtable<>();
	PlayerClub myClub;
	
	public Store(PlayerClub myClub) {
		
		this.myClub = myClub;
	}
	public void refreshStore() {
		purchaseableAthletes playerHashTables = new purchaseableAthletes();
		playerHashTable = playerHashTables.addPurchasablePlayers();
		PurchaseableItems itemHashtables = new PurchaseableItems();
		itemHashtable = itemHashtables.addPurchaseableItems();	
	}
	
	public void purchaseAthlete() {
		purchaseAthlete athlete = new purchaseAthlete(playerHashTable,myClub);
		myClub.balance = athlete.purchaseAthletes();
	}
	public void sellPlayer() {
		sellPlayer playerSold = new sellPlayer(myClub);
		myClub.balance = playerSold.playerSell();	
	}
	public void purchaseItem() {
		purchaseItem item = new purchaseItem(itemHashtable, myClub);
		myClub.balance = item.purchaseItems();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
