package coding201.code;


import java.util.Hashtable;
import java.util.List;
import java.util.Random;
/**
 * opposingTeam
 * An extension of the PlayerClub, an OpposingTeam auto name generation.
 * This is the object whose athleteList is compared with the player's starter list in order to determine the outcome of a match.
 * @version 1.0
 * @author tve21 & bro82
 *
 */
public class opposingTeam extends PlayerClub {

	//creates a random name if none is passed in
	teamDatabase teamnames = new teamDatabase();
	List<String> nlist = teamnames.getList();
	Random random = new Random();
	int rindex = random.nextInt(99);
	String rname = nlist.get(rindex);
	public Hashtable<String, Athlete> newathleteList = new Hashtable<String, Athlete>();
	
	/**
	 * Constructors used to initialise the team. If no name is passed in, a random one is generated from the teamDatabase.
	 */
	public opposingTeam() {
		name = rname;
	}
	
	/**
	 * Sets the name of the OpposingTeam object to the input teamName.
	 * @param teamName
	 */
	public opposingTeam(String teamName){
		name = teamName;
	}
	/**
	 * Sets the name of the OpposingTeam object to the input teamName
	 * Sets the athleteList in the opposingTeam to the input inathleteList.
	 * @param teamName
	 * @param inathleteList
	 */
	public opposingTeam(String teamName, Hashtable<String, Athlete> inathleteList) {
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
