package coding201;

public class PurchaseableItem {
	int price;
	String name;
	String info;
	
	
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
