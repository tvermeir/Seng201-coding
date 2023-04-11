package coding201;

import java.util.ArrayList;

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
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
