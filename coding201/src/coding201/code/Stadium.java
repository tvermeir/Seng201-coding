package coding201.code;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
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
	
	
//	public Hashtable<String, opposingTeam> selectedTeam(){
//		PossibleOpponents.entrySet().forEach( entry -> {
//		   System.out.println( entry.getKey() + ": \n" + entry.getValue()  + ("\n"));
//		});
//		Random random = new Random();
//		int number = random.nextInt(3);
//		List<String> listKeysOfTeam = new ArrayList<String>(PossibleOpponents.keySet());
//		String teamName = listKeysOfTeam.get(number);
//		
//		
//		
//		
//		return PossibleOpponents;
//
//	}
	


}
