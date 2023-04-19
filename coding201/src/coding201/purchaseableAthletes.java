package coding201;

import java.util.Hashtable;

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
