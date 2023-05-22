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
 * @author tve21 & bro82
 */
public class Stadium {

	public Hashtable<String, opposingTeam> PossibleOpponents =  new Hashtable<>();
	public Hashtable<String, Athlete> selectedTeam = new Hashtable<>();
	public int gamesPlayed = 0;
	public PlayerClub club;
	public int currWeek = 1;
	public int weeksToPlay = 10;
	public int numWins = 0;
	public int numDraws = 0;
	public int numLosses = 0;
	
	/**
	 * Constructs the stadium using the player's club.
	 * @param club
	 */
	public Stadium(PlayerClub club) {
		this.club = club;
	}
	
	/**
	 * Fills the stadium's PossibleOpponent hashtable with 4 random teams.
	 * @return
	 */
	public Hashtable<String, opposingTeam> fillOpponentTable() {
		while (PossibleOpponents.size() < 5) {
			Random random = new Random();
			teamDatabase teamName = new teamDatabase();
			List<String> nlist = teamName.getList();
			int rindex = random.nextInt(99);
			String name = nlist.get(rindex);
			Hashtable<String, Athlete> alist = new Hashtable<>();
			opposingTeam team = new opposingTeam(name, alist);
			team.Fill();
			PossibleOpponents.put(team.name, team);
			
		}
		return PossibleOpponents;
	}
	/**
	 * Takes the club balance, and finds the cheapest player in the store.
	 * The two values are compared and if the club balance is lower than the cheapest price and there are not enough players to start a match, true is returned. 
	 * Otherwise false.
	 * @param store
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
		for (int i = 0; i < needsNAthletes; i++) {
			needsNMoney += storeprices.get(i);
		}
		if (needsNMoney > club.balance) {
			return true;
		}
		return false;
	}
	
	
	


}