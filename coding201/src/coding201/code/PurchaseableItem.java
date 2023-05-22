package coding201.code;
/**
 * PurchaseableItem
 * PurchaseableItem is the class of the items that can be applied to each player in a team.
 * They have a price, name, and a short info string about what effect they have when applied.
 * @version 1.0
 * @author tve21 & bro82
 *
 */
public class PurchaseableItem {
	public int price;
	public String name;
	public String info;
	
	
	/**
	 * Initialises a purchaseable item with a name string, price integer, and a string info which contains the description of what the item does.
	 * @param name
	 * @param price
	 * @param info
	 */
	public PurchaseableItem(String name, int price, String info) {
		this.price = price;
		this.name = name;
		this.info = info;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	

}
