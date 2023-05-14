package coding201;

import java.util.ArrayList;
import java.util.Random;
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
	String name;
	
	
	public PlayerClub() {
		
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
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void doBoostStatEvent() {
		Random random = new Random();
		int number = random.nextInt(4);
		List<String> listKeysOfTeam = new ArrayList<String>(this.athleteList.keySet());
		String playerName = listKeysOfTeam.get(number);
		Athlete boostedAthlete = this.athleteList.get(playerName);
		boostedAthlete.boostStat();
		this.athleteList.remove(playerName);
		this.athleteList.put(playerName, boostedAthlete);
		System.out.println("A random athlete's stats have been boosted");
	}

	public void doAthleteQuitEvent() {
		Random random = new Random();
		int number = random.nextInt(4);
		List<String> listKeysOfTeam = new ArrayList<String>(this.athleteList.keySet());
		String playerName = listKeysOfTeam.get(number);
		this.athleteList.remove(playerName);
		System.out.println(playerName + " has quit the team.");
		if (athleteList.size() < 4) {
			System.out.println("Your team now only has " + athleteList.size() + " players. \nYou need to buy a player from the store if you want to play another match.");
		}
	}

	public void doRandomNewAthleteEvent() {
		AthleteDatabase athbase = new AthleteDatabase();
		Athlete newAthlete = athbase.getAthlete();
		athleteList.put(newAthlete.name, newAthlete);
		System.out.println(newAthlete.name + " has randomly been selected for the team");
	}

	public void doRandomEvent() {
		Random random = new Random();
		int number = random.nextInt(10);
		if (number <= 1) {
			this.doAthleteQuitEvent();
		}
		if (number < 4 && number >= 2) {
			this.doRandomNewAthleteEvent();
		}
		if (number >= 4) {
			this.doBoostStatEvent();
		}

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
