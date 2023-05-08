package coding201;

import java.util.ArrayList;
import java.util.Hashtable;

public class PlayerClub {
	int balance;
	int playerCount;
	String teamName;
	Hashtable<String, Athlete> athleteList = new Hashtable<>();
	Hashtable<String, Athlete> starterList = new Hashtable<>();
	Hashtable<String, Athlete> reserveList = new Hashtable<>();
	Hashtable<String, PurchaseableItem> itemInventory = new Hashtable<>();
	ArrayList<Athlete> topScorer = new ArrayList<Athlete>();
	ArrayList<String> nameList = new ArrayList<String>();
	
	
	public PlayerClub(int balance, String name, Hashtable<String, Athlete> athleteList2) {
		this.balance = balance;
		teamName = name;
		this.athleteList = athleteList2;
	}
	
	
	public void makeReserve(Athlete athlete) {
		if (athleteList.contains(athlete.name)) {
			reserveList.put(athlete.name,athlete);
		}
		if (starterList.contains(athlete.name)) {
			starterList.remove(athlete.name);
		}
	}
	public void makeStarter(Athlete athlete) {
		if (athleteList.contains(athlete.name)) {
			starterList.put(athlete.name, athlete);
		}
		if (reserveList.contains(athlete.name)) {
			reserveList.remove(athlete.name);
		}
		
		
	}
	public float getBalance() {
		return balance;
	}
	
	public boolean canPlay() {
		if (starterList.size() >= 4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addPlayer(Athlete athlete) {
		if (athleteList == null) {
			athleteList.put(athlete.name,athlete);
			return;
		}
		
		if (!athleteList.contains(athlete)) {
			athleteList.put(athlete.name,athlete);
		}
		
		
	}
	
	public String getName() {
		return teamName;
	}
	
	public String printAthleteList() {
		String output = "";
		for (String name : athleteList.keySet()) {
			output += "\n" + name + " " + athleteList.get(name);
		}
		return output;
	}
	
	public Hashtable<String, PurchaseableItem> getInventory() {
		return itemInventory;
	}
	public void addItem(PurchaseableItem item) {
		itemInventory.put(item.getName(), item);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
