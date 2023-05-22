package coding201.code;


import java.util.Hashtable;
import java.util.List;
import java.util.Random;
/**
 * opposingTeam
 * An extension of the PlayerClub, an OpposingTeam auto name generation.
 * This is the object whose athleteList is compared with the player's starter list in order to determine the outcome of a match.
 * @version 1.0
 * @author tve21
 * @author bro82
 *
 */
public class OpposingTeam extends PlayerClub {

	TeamDatabase teamnames = new TeamDatabase();
	List<String> nlist = teamnames.getList();
	Random random = new Random();
	int rindex = random.nextInt(99);
	String rname = nlist.get(rindex);
	/**
	 * a hashtable of new athletes
	 */
	public Hashtable<String, Athlete> newathleteList = new Hashtable<String, Athlete>();
	
	/**
	 * Constructors used to initialise the team. If no name is passed in, a random one is generated from the teamDatabase.
	 */
	public OpposingTeam() {
		name = rname;
	}
	
	/**
	 * Sets the name of the OpposingTeam object to the input teamName.
	 * @param teamName a string of the opposingTeam
	 */
	public OpposingTeam(String teamName){
		name = teamName;
	}
	/**
	 * Sets the name of the OpposingTeam object to the input teamName
	 * Sets the athleteList in the opposingTeam to the input inathleteList.
	 * @param teamName a string of the teamName
	 * @param inathleteList a HashTable of Strings and Athletes
	 */
	public OpposingTeam(String teamName, Hashtable<String, Athlete> inathleteList) {
		name = teamName;
		newathleteList = inathleteList;
	}
	
	
	/**
	 * Returns the string representation of the athleteList.
	 */
	public String toString() {
		return athleteList.toString();
	}
	
	
	
	
	
	

}
