package coding201.code;

import java.util.Hashtable;
/**
 * PurchaseableItems
 * PurchaseableItems contains a hashtable of the 3 types of purchaseable items in the game: Active recovery, Attack Training, and Defense Training.
 * Items can be added to the empty table.
 * @version 1.0
 * @author tve21 & bro82
 *
 */
public class PurchaseableItems {

	Hashtable<String, PurchaseableItem> itemHashtable =  new Hashtable<>();
	PurchaseableItem ActiveRecovery = new PurchaseableItem("Active Recovery", 30, "Restores a selected player's stamina by 50 points");
	PurchaseableItem AttackTraining = new PurchaseableItem("Attack Training", 40, "Increases a selected player's attack by 15 points");
	PurchaseableItem DefenseTraining = new PurchaseableItem("Defense Training", 40, "Increases a selected player's defense by 15 points");
	
	/**
	 * Adds each of the purchaseableItem types into the itemHashtable 
	 * @return itemHashtable
	 */
	
	public Hashtable<String, PurchaseableItem> addPurchaseableItems() {
		itemHashtable.put(ActiveRecovery.name, ActiveRecovery);
		itemHashtable.put(AttackTraining.name, AttackTraining);
		itemHashtable.put(DefenseTraining.name, DefenseTraining);
		return itemHashtable;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
