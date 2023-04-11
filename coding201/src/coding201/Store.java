package coding201;
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
		
		System.out.println("\nIf you want to purchase an athlete please type the corresponding name in. ");
		Scanner athleteName = new Scanner(System.in);
		String playerName = athleteName.nextLine();
		
		boolean isavailable = purchasableAthletes.containsKey(playerName);
		
		if(isavailable) {
			System.out.println(purchasableAthletes.get(playerName));
			
		}
		else {
			System.out.println("Please enter correct name");
			purchaseAthlete();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
