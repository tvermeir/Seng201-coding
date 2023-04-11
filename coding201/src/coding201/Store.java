package coding201;
import java.util.ArrayList;
public class Store {
	ArrayList<Athlete> purchasableAthletes = new ArrayList<Athlete>();
	public int balance;
	
	public Store(ArrayList<Athlete> purchasableAthletes, int balance) {
		this.purchasableAthletes = purchasableAthletes;
		this.balance = balance;
	}
	public void purchaseAthlete() {
		System.out.println(purchasableAthletes);
		
		System.out.println("If you want to purchase an athlete please type the corresponding name in. ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
