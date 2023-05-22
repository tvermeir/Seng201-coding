package coding201.code;

import java.util.Hashtable;
/**
 * PurchaseableAthletes
 * This class contains a hashtable of random players that are used in the creation of the store and its refreshing.
 * @version 1.0
 *@author tve21
 *@author bro82
 */
public class purchaseableAthletes {
	Hashtable<String, Athlete> playerHashTable =  new Hashtable<>();
	
	/**
	 * Creates a hashtable that can be passed into other objects and contains 4 random athletes.
	 * @return playerHashtable
	 */
	public Hashtable<String, Athlete> addPurchasablePlayers() {
		AthleteDatabase newPlayers = new AthleteDatabase();
		
		int i = 0;
		
		while(i<4) {
			String athlete = newPlayers.makeAthleteString();
			Athlete athlete2 = newPlayers.makeAthlete(athlete);
			playerHashTable.put(athlete2.name, athlete2);
			i ++;
		}
		return playerHashTable;

	}

}
