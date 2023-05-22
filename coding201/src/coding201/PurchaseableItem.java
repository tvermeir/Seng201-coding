package coding201;

public class PurchaseableItem {
	int price;
	String name;
	String info;
	
	
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
