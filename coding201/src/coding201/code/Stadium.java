package coding201.code;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Stadium
 * Stadium is the object that contains all the stats about the player's club and holds the hadhtable for the possible opponents.
 * The opponent hashtable can be filled with random teams.
 * @version 1.0
 * @author tve21
 * @author bro82
 */
public class Stadium {
	/**
	 * hashTable of the possible opponents
	 */
	public Hashtable<String, OpposingTeam> PossibleOpponents =  new Hashtable<>();
	
	/**
	 * Instance of the PlayerClub class
	 */
	public PlayerClub club;
	/**
	 * number of current weeks played
	 */
	public int currWeek = 1;
	/**
	 * number of weeks to play, default is 10
	 */
	public int weeksToPlay = 10;
	/**
	 * number of wins
	 */
	public int numWins = 0;
	/**
	 * number of draws
	 */
	public int numDraws = 0;
	/**
	 * number of losses
	 */
	public int numLosses = 0;
	
	/**
	 * Constructs the stadium using the player's club.
	 * @param club an instance of the PlayerClub club
	 */
	public Stadium(PlayerClub club) {
		this.club = club;
	}
	
	/**
	 * Fills the stadium's PossibleOpponent hashtable with 4 random teams.
	 * @return HashTable
	 */
	public Hashtable<String, OpposingTeam> fillOpponentTable() {
		while (PossibleOpponents.size() < 5) {
			Random random = new Random();
			TeamDatabase teamName = new TeamDatabase();
			List<String> nlist = teamName.getList();
			int rindex = random.nextInt(99);
			String name = nlist.get(rindex);
			Hashtable<String, Athlete> alist = new Hashtable<>();
			OpposingTeam team = new OpposingTeam(name, alist);
			team.Fill();
			PossibleOpponents.put(team.name, team);
			
		}
		return PossibleOpponents;
	}
	/**
	 * Takes the club balance, and finds the cheapest player in the store.
	 * The two values are compared and if the club balance is lower than the cheapest price and there are not enough players to start a match, true is returned. 
	 * Otherwise false.
	 * @param store an instance of a store class
	 * @return boolean 
	 */
	public boolean checkEnd(Store store) {
		int needsNAthletes = 4 - club.starterList.size();
		int needsNMoney = 0;
		ArrayList<Integer> storeprices = new ArrayList<Integer>();
		store.playerHashTable.forEach((name, thlete) -> {
			storeprices.add(thlete.price);
		});
		Collections.sort(storeprices);
		if(store.playerHashTable.size() == 1) {
			needsNMoney = storeprices.get(0);
		}
		else if (store.playerHashTable.size() != 1)
			for (int i = 0; i < needsNAthletes; i++) {
				needsNMoney += storeprices.get(i);
			}
		if (needsNMoney > club.balance) {
			return true;
		}
		return false;
	}
	
	
	


}
