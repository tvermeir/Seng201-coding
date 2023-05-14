package coding201;


import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class opposingTeam extends PlayerClub {

	
	int timesVersed = 0;
	double winReward = 100;
	
	//creates a random name if none is passed in
	teamDatabase teamnames = new teamDatabase();
	List<String> nlist = teamnames.getList();
	Random random = new Random();
	int rindex = random.nextInt(99);
	String rname = nlist.get(rindex);
	Hashtable<String, Athlete> newathleteList = new Hashtable<String, Athlete>();
	
	
	public opposingTeam() {
		name = rname;
	}
	
	
	
	public opposingTeam(String teamName ){
		name = teamName;
		
	}
	
	public opposingTeam(String teamName, Hashtable<String, Athlete> inathleteList) {
		name = teamName;
		newathleteList = inathleteList;
	}
	
	
	
	public void adjustWinReward(double difficulty){
		winReward *= difficulty;
	}
	
	public double getWinReward(){
		return winReward;
	}
	
	public String toString() {
		return athleteList.toString();
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
