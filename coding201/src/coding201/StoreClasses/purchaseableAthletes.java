package coding201.StoreClasses;

import java.util.Hashtable;

import coding201.AthleteClasses.Athlete;
import coding201.databases.AthleteDatabase;

public class purchaseableAthletes {
	Hashtable<String, String> playerHashTable =  new Hashtable<>();
	public Hashtable<String, String> addPurchasablePlayers() {
		AthleteDatabase newPlayers = new AthleteDatabase();
		
		int i = 0;
		
		while(i<4) {
			String athlete = newPlayers.makeAthleteString();
			Athlete athlete2 = newPlayers.makeAthlete(athlete);
			playerHashTable.put(athlete2.name, athlete2.getHashtable());
			i ++;
		}
		return playerHashTable;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
