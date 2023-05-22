package coding201;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
public class Store {
	
	Hashtable<String, Athlete> playersInTeam =  new Hashtable<>();
	Hashtable<String, Athlete> playerHashTable =  new Hashtable<>();
	Hashtable<String, PurchaseableItem> itemHashtable = new Hashtable<>();
	PlayerClub myClub;
	
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
	
//	public void purchaseAthlete() {
//		purchaseAthlete athlete = new purchaseAthlete(playerHashTable,myClub);
//		myClub.balance = athlete.purchaseAthletes();
//	}
//	public void sellPlayer() {
//		sellPlayer playerSold = new sellPlayer(myClub);
//		myClub.balance = playerSold.playerSell();	
//	}
//	public void purchaseItem() {
//		purchaseItem item = new purchaseItem(itemHashtable, myClub);
//		myClub.balance = item.purchaseItems();
//	}
//	public void enterStore() {
//		System.out.println("Welcome to the store! Shop players with /shopplayers or shop items with /shopitems");
//		
//		Boolean instore = true;
//		
//		while (instore) {
//			Scanner scanner = new Scanner(System.in);
//			String input = scanner.nextLine();
//			if (input.equals("shopplayers")) {
//				System.out.println("Shopping on the transfer market.");
//				this.purchaseAthlete();
//			}
//			else if (input == "shopitems") {
//				System.out.println("Shopping in the item shop.");
//				this.purchaseItem();
//			}
//			else if (input == "exitstore" ) {
//				System.out.println("Exiting the store.");
//				instore = false;
//			}
//		}
//		
//	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
