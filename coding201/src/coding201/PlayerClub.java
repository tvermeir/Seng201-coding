package coding201;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import java.util.Hashtable;
import java.util.List;

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
	ArrayList<String> itemList = new ArrayList<String>();
	String name;
	int weeksToPlay;
	
	
	public PlayerClub() {
		
	}
	
	public PlayerClub(int balance, String name) {
		this.balance = balance;
		teamName = name;
	}
	
	

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
	
	public void reShuffle() {
		while (starterList.size() < 4 && reserveList.size() > 0) {
			ArrayList<Athlete> tempAths = new ArrayList<Athlete>();
			reserveList.forEach((k, v) -> {
				tempAths.add(v);
			});
			starterList.put(tempAths.get(0).name, tempAths.get(0));
			reserveList.remove(tempAths.get(0).name);
			tempAths.remove(0);
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
			starterList.put(athlete.name,athlete);
			return;
		}
		
		else if (!athleteList.contains(athlete) && athleteList.size() < 8) {
			if (!starterList.contains(athlete) && starterList.size() < 4) {
				starterList.put(athlete.name, athlete);
			}
			else if (!reserveList.contains(athlete) && reserveList.size() < 4){
				reserveList.put(athlete.name, athlete);
			}
			athleteList.put(athlete.name,athlete);
		}
		
		
		
		
	}
	
	public String getName() {
		return teamName;
	}
	
	public String printAthleteList() {
		String output = "";
		for (String name : athleteList.keySet()) {
			output += "\n" + name + ": " + athleteList.get(name);
		}
		output += "\n";
		return output;
	}
	
	public Hashtable<String, PurchaseableItem> getInventory() {
		return itemInventory;
	}
	public void addItem(PurchaseableItem item) {
		itemInventory.put(item.getName(), item);
		itemList.add(item.name);
	}
	
	public void removeItem(String itemName) {
		itemInventory.remove(itemName);
		itemList.remove(itemName);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void Fill() {
		int i = athleteList.size();
		while (i < 4) {
			AthleteDatabase ath = new AthleteDatabase();
			String athstring = ath.makeAthleteString();
			Athlete athlete = ath.makeAthlete(athstring);
			this.addPlayer(athlete);
			i ++;
		}
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
