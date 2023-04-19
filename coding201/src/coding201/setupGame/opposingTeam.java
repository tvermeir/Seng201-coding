package coding201.setupGame;

import java.util.ArrayList;

import coding201.PlayerClub;
import coding201.AthleteClasses.Athlete;
import coding201.databases.AthleteDatabase;

public class opposingTeam extends PlayerClub {

	
	int timesVersed = 0;
	double winReward = 100;
	
	public opposingTeam(String name, ArrayList<Athlete> athleteList ){
		super(0, name, athleteList);
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
	
	public void Fill() {
		int i = athleteList.size();
		while (i < 4) {
			AthleteDatabase ath = new AthleteDatabase();
			String athstring = ath.makeAthleteString();
			Athlete athlete = ath.makeAthlete(athstring);
			this.addPlayer(athlete);
			i ++;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
