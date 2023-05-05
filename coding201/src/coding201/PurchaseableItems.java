package coding201;

import java.util.Hashtable;

public class PurchaseableItems {

	Hashtable<String, PurchaseableItem> itemHashtable =  new Hashtable<>();
	PurchaseableItem Bandage = new PurchaseableItem("Bandage", 10);
	PurchaseableItem AttackTraining = new PurchaseableItem("Attack Training", 20);
	PurchaseableItem DefenseTraining = new PurchaseableItem("Defense Training", 20);
	
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
