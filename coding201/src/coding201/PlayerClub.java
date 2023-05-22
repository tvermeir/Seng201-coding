package coding201;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import java.util.Hashtable;
import java.util.List;
/**
 * <h1>Player Club<h1>
 * This class is responsible for creating the framework for the player club. It contains the complete
 * athleteList, starterList and reserveList as well as the name of the club and the starting balance of the club
 * 
 *@version 1.0
 *@author toddv & benzene26
 */
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
	
	
	/**
	 *These are constructors used to set up the variables within the PlayerClub class, there are three of them as there are three different calls to the class
	 * 
	 * 
	 *@param Balance: an integer value representing the money the club has, Name: an string value representing the name of the team
	 *@return sets the balance and teamName within the class equal to the constructor values, the 3rd constructor, the hashtable athleteList from the opposing team class
	 */
	
	public PlayerClub () {
		
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
	


	/**
	 * This method is called when an event occurs that removes a player from the club's starter list. It moves a player, if in the reserve list, to fill the empty space in the starter list.
	 * 
	 */
	
	
	
	
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
	
	
	/**
	 * Adds a player to the club's athletelist table and either the starterlist or reservelist depending on how many players are in the starters.
	 *
	 * @param athlete
	 */
	
	public void addPlayer(Athlete athlete) {
		if (athleteList == null) {
			starterList.put(athlete.name,athlete);
			athleteList.put(athlete.name,athlete);
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
	public Athlete addBoughtPlayer(Athlete athlete) {
		if (starterList.size() < 4) {
			starterList.put(athlete.name, athlete);
			athleteList.put(athlete.name, athlete);
			Athlete swappedAthlete = athlete;
			return swappedAthlete;
		}
		
		ArrayList<String> namelist = new ArrayList<String>();
		starterList.forEach((k, v) -> {
			namelist.add(k);
		});
		Random random = new Random();
		int number = random.nextInt(3);
		Athlete swappedAthlete = starterList.get(namelist.get(number));
		reserveList.put(swappedAthlete.name, swappedAthlete);
		starterList.remove(swappedAthlete.name);
		starterList.put(athlete.name, athlete);
		athleteList.put(athlete.name, athlete);
		return swappedAthlete;
	}
	
	
	
	/**
	 *This method returns the name of the team
	 *@param N/A
	 *@return returns the string form of the teamName
	 */
	public String getName() {
		return teamName;
	}
	
	
	
	/**
	 * Returns a "nicer" version of the athleteLIst hashtable.
	 * @return string form of the AthleteList hashtable.
	 */
	public String printAthleteList() {
		String output = "";
		for (String name : athleteList.keySet()) {
			output += "\n" + name + ": " + athleteList.get(name);
		}
		output += "\n";
		return output;
	}
	/**
	 * @return Returns the hashtable of the Club's inventory.
	 */
	public Hashtable<String, PurchaseableItem> getInventory() {
		return itemInventory;
	}
	/**
	 * Adds an item into the club's inventory.
	 * @param item to be added.
	 */
	public void addItem(PurchaseableItem item) {
		itemInventory.put(item.getName(), item);
		itemList.add(item.name);
	}
	/**
	 * Removes an item from the inventory by passing the item's name as the key into the hashtable.
	 * @param itemName
	 */
	public void removeItem(String itemName) {
		itemInventory.remove(itemName);
		itemList.remove(itemName);
	}
	/**
	 * Sets the clubs name as the input name
	 * @param name to set the club's name to.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Fills up the club with 4 random athletes; 
	 * Only used when club first initialised along with OpposingTeam
	 */
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
