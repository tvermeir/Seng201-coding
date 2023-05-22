package coding201.code;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
/**
 * Store is the object which contains the purchasable Players and the purchasable Items.
 * It is refreshed each week with 4 random players.
 * @version 1.0
 * @author tve21 & bro82
 */
public class Store {
	
	Hashtable<String, Athlete> playersInTeam =  new Hashtable<>();
	public Hashtable<String, Athlete> playerHashTable =  new Hashtable<>();
	public Hashtable<String, PurchaseableItem> itemHashtable = new Hashtable<>();
	public PlayerClub myClub;
	
	/**
	 * Uses the playerclub to create a store that can access all the parameters of the player club.
	 * Also calls the refreshStore method to initialise a full store of items and players.
	 * @param myClub
	 */
	public Store(PlayerClub myClub) {
		
		this.myClub = myClub;
		this.refreshStore();
	}
	/**
	 * Refreshes the store with a completely random list of players to buy; 
	 * Items remain in the store for further shopping after being purchased so they are only called in this method in order to help the constructor during first initialisation.
	 */
	public void refreshStore() {
		purchaseableAthletes playerHashTables = new purchaseableAthletes();
		playerHashTable = playerHashTables.addPurchasablePlayers();
		PurchaseableItems itemHashtables = new PurchaseableItems();
		itemHashtable = itemHashtables.addPurchaseableItems();	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
