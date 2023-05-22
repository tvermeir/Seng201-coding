package coding201;

import java.util.Hashtable;

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
