package coding201.code;
/**
 * PurchaseableItem
 * PurchaseableItem is the class of the items that can be applied to each player in a team.
 * They have a price, name, and a short info string about what effect they have when applied.
 * @version 1.0
 *	@author tve21
 *	@author bro82
 *
 */
public class PurchaseableItem {
	/**
	 * Integer of the price
	 */
	public int price;
	/**
	 * String of the name of the item
	 */
	public String name;
	/**
	 * The item information
	 */
	public String info;
	
	
	/**
	 * Initialises a purchaseable item with a name string, price integer, and a string info which contains the description of what the item does.
	 * @param name a string representing the name of the item
	 * @param price an integer value for the price
	 * @param info a description of the item
	 */
	public PurchaseableItem(String name, int price, String info) {
		this.price = price;
		this.name = name;
		this.info = info;
	}
	/**
	 * returns the price
	 * @return int
	 */
	
	public int getPrice() {
		return price;
	}
	/**
	 * returns the name of the item
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	

}
