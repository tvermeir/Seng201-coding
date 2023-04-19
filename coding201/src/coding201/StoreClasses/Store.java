package coding201.StoreClasses;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
public class Store {
	
	Hashtable<String, String> playersInTeam =  new Hashtable<>();
	Hashtable<String, String> playerHashTable =  new Hashtable<>();
	
	public int balance;
	
	public Store(int balance, Hashtable<String, String> team) {
		
		this.balance = balance;
		this.playersInTeam = team;
		
	}
	public void refreshStore() {
		purchaseableAthletes playerHashTables = new purchaseableAthletes();
		playerHashTable = playerHashTables.addPurchasablePlayers();
	}
	
	public int purchaseAthlete() {
		purchaseAthlete athlete = new purchaseAthlete(playerHashTable, playersInTeam, balance);
		balance = athlete.purchaseAthletes();
		return balance;
	}
	public int sellPlayer() {
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
