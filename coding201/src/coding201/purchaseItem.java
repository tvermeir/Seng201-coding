//package coding201;
//
//import java.util.Hashtable;
//import java.util.Scanner;
//
//public class purchaseItem {
//	PlayerClub myClub;
//	Hashtable<String, PurchaseableItem> itemsInStore = new Hashtable<>();
//	
//	public purchaseItem(Hashtable<String, PurchaseableItem> itemsInStore,PlayerClub myClub) {
//		this.myClub = myClub;
//		this.itemsInStore = itemsInStore;
//	}
//	public int purchaseItems() {
//		
//		
//		System.out.println(itemsInStore);
//		System.out.println("\nIf you want to purchase an item please type the item's name. ");
//		
//		Scanner itemNameGetter = new Scanner(System.in);
//		String itemName = itemNameGetter.nextLine();
//		boolean isavailable = itemsInStore.containsKey(itemName);
//		if (isavailable) {
//			PurchaseableItem item = itemsInStore.get(itemName);
//			int price = item.price;
//			
//			
//			if(myClub.balance - price >=0) {
//				myClub.balance -= price;
//				myClub.addItem(item);
//				System.out.println(item.name +  " Successfully bought. Check your club inventory to see it.");
//			}
//			else if (myClub.balance - price < 0) {
//				System.out.println("You do not have the funds to purchase this item!");
//				purchaseItems();
//				
//			}
//		}
//		
//		else if (!isavailable) {
//			System.out.println("Please enter correct name");
//			purchaseItems();
//		}
//		return myClub.balance;
//		
//		
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
