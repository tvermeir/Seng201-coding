package coding201.code;

import java.util.ArrayList;
import java.util.Random;
import java.util.Hashtable;

/**
 * Player Club
 * This class is responsible for creating the framework for the player club. It contains the complete
 * athleteList, starterList and reserveList as well as the name of the club and the starting balance of the club
 * 
 *@version 1.0
 *@author tve21
 *@author bro82
 */
public class PlayerClub {
	/**
	 * Balance of the Club
	 */
	public int balance;
	/**
	 * Name of the team
	 */
	public String teamName;
	/**
	 * HashTable of the athletes
	 */
	public Hashtable<String, Athlete> athleteList = new Hashtable<>();
	/**
	 * Hashtable of the Starters
	 */
	public Hashtable<String, Athlete> starterList = new Hashtable<>();
	/**
	 * Hashtable of the Reserves
	 */
	public Hashtable<String, Athlete> reserveList = new Hashtable<>();
	/**
	 * Hashtable of the items in the user's inventory
	 */
	public Hashtable<String, PurchaseableItem> itemInventory = new Hashtable<>();
	/**
	 * Array list of all the names
	 */
	public ArrayList<String> nameList = new ArrayList<String>();
	/**
	 * Array list of all the items
	 */
	public ArrayList<String> itemList = new ArrayList<String>();
	/**
	 * String representing a name
	 */
	public String name;
	/**
	 * integer of the total weeks to play
	 */
	public int weeksToPlay;
	
	
	
	/**
	 *These are constructors used to set up the variables within the PlayerClub class, there are three of them as there are three different calls to the class
	 * 
	 */
	public PlayerClub () {
		
	}
	/**
	 *These are constructors used to set up the variables within the PlayerClub class, there are three of them as there are three different calls to the class
	 * 
	 * 
	 *@param balance an integer value representing the money the club has
	 *@param name an string value representing the name of the team
	 */
	public PlayerClub(int balance, String name) {
		this.balance = balance;
		teamName = name;
	}
	
	
	/**
	 *These are constructors used to set up the variables within the PlayerClub class, there are three of them as there are three different calls to the class
	 * 
	 * 
	 *@param balance an integer value representing the money the club has
	 *@param name an string value representing the name of the team
	 *@param athleteList2 a list of athletes
	 */
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
	 * @param athlete an instance of the Athlete class
	 */
	
	public void addPlayer(Athlete athlete) {
		
		
		if (athleteList.isEmpty()) {
			starterList.put(athlete.name,athlete);
			athleteList.put(athlete.name,athlete);
			return;
		}
		
		else if (!athleteList.contains(athlete.name) && athleteList.size() < 8) {
			if (!starterList.contains(athlete) && starterList.size() < 4) {
				starterList.put(athlete.name, athlete);
			}
			else if (!reserveList.contains(athlete) && reserveList.size() < 4){
				reserveList.put(athlete.name, athlete);
			}
			athleteList.put(athlete.name,athlete);
		}
	}
	/**
	 * Adds the bought athlete to the starter list, swaps out the old
	 * starter with the new athlete and puts the old starter in reserve
	 * @param athlete an instance of the Athlete Class
	 * @return Athlete
	 */
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
	 * Gets the inventory of the club
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
	 * @param itemName a string representation of the name of the item
	 */
	public void removeItem(String itemName) {
		itemInventory.remove(itemName);
		itemList.remove(itemName);
	}
	/**
	 * Sets the clubs name as the input name
	 * @param name a string to set the name of the club to
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Fills up the club with 4 random athletes; 
	 * Only used when club first initialised along with OpposingTeam
	 */
	public void Fill() {
		while (athleteList.size() < 4) {
			AthleteDatabase ath = new AthleteDatabase();
			String athstring = ath.makeAthleteString();
			Athlete athlete = ath.makeAthlete(athstring);
			if (athleteList.contains(athlete.name)) {
				continue;
			}
			else {
				this.addPlayer(athlete);
			}
			
		}
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
