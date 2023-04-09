package coding201;

public class PurchaseableItem {
	int price;
	String name;
	
	public PurchaseableItem(String name, int price) {
		this.price = price;
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	

}
