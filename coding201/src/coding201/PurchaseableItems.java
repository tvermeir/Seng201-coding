package coding201;

import java.util.Hashtable;

public class PurchaseableItems {

	Hashtable<String, PurchaseableItem> itemHashtable =  new Hashtable<>();
	PurchaseableItem Bandage = new PurchaseableItem("Active Recovery", 30, "Restores a selected player's stamina by 50 points");
	PurchaseableItem AttackTraining = new PurchaseableItem("Attack Training", 40, "Increases a selected player's attack by 15 points");
	PurchaseableItem DefenseTraining = new PurchaseableItem("Defense Training", 40, "Increases a selected player's defense by 15 points");
	
	public Hashtable<String, PurchaseableItem> addPurchaseableItems() {
		itemHashtable.put(Bandage.name, Bandage);
		itemHashtable.put(AttackTraining.name, AttackTraining);
		itemHashtable.put(DefenseTraining.name, DefenseTraining);
		return itemHashtable;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
