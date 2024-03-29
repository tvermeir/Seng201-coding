package coding201.code;
import java.util.Hashtable;
/**
 * Store is the object which contains the purchasable Players and the purchasable Items.
 * It is refreshed each week with 4 random players.
 * @version 1.0
 * @author tve21
 * @author bro82
 */
public class Store {
	/**
	 * Hashtable of the players in the team
	 */
	public Hashtable<String, Athlete> playerHashTable =  new Hashtable<>();
	/**
	 * hashTable of all the items
	 */
	public Hashtable<String, PurchaseableItem> itemHashtable = new Hashtable<>();
	/**
	 * instance of the Playerclub class
	 */
	public PlayerClub myClub;
	
	/**
	 * instance of the athlete class
	 */
	Athlete zero = new Athlete(0, 0, 0, "null");
	
	
	/**
	 * Uses the playerclub to create a store that can access all the parameters of the player club.
	 * Also calls the refreshStore method to initialise a full store of items and players.
	 * @param myClub an instance of a PlayerClub class
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
		PurchaseableAthletes playerHashTables = new PurchaseableAthletes();
		playerHashTable = playerHashTables.addPurchasablePlayers();
		PurchaseableItems itemHashtables = new PurchaseableItems();
		itemHashtable = itemHashtables.addPurchaseableItems();	
	}
	
	

}
