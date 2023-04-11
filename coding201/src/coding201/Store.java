package coding201;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;
public class Store {
	
	Hashtable<String, String> purchasableAthletes =  new Hashtable<>();
	public int balance;
	
	public Store(Hashtable<String, String> purchase, int balance) {
		this.purchasableAthletes = purchase;
		this.balance = balance;
	}
	public void purchaseAthlete() {
		System.out.println(purchasableAthletes);
		
		System.out.println("\nIf you want to purchase an athlete please type the corresponding name in. ");
		Scanner athleteName = new Scanner(System.in);
		String playerName = athleteName.nextLine();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
