package coding201;
import java.util.Hashtable;
import java.util.Scanner;
public class Store {
	
	Hashtable<String, String> playersInTeam =  new Hashtable<>();
	Hashtable<String, String> playerHashTable =  new Hashtable<>();
	Hashtable<String, Integer> itemHashtable = new Hashtable<>();
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
		sellPlayer playerSold = new sellPlayer(playersInTeam, balance);
		balance = playerSold.playerSell();
		return balance;
		
	}
	
	public int purchaseItem() {
		Integer ting = 5;
		return ting;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
