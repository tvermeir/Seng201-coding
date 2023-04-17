package coding201;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Stadium {

	Hashtable<Integer, opposingTeam> PossibleOpponents =  new Hashtable<>();
	int gamesPlayed = 0;
	
	public Stadium(PlayerClub club){
		if (!club.canPlay()){
			System.out.println("Not enough players, purchase some more or its gonna be game over. You fucking Retard.");
		}
		else {
			System.out.println("Pitch lookin lovely today lads.");
		}
	}
	
	public ArrayList<String> viewOpponents() {
		ArrayList<String> oppview = new ArrayList<String>();
		int i = 0;
		while (i < PossibleOpponents.size()) {
			oppview.add(PossibleOpponents.get(i).teamName);
			i ++ ;
		}
		return oppview;
	}
	
	public void fillOpponentList() {
		if (PossibleOpponents.size() < 4) {
			Random random = new Random();
			teamDatabase ting = new teamDatabase();
			List<String> nlist = ting.getList();
			int rindex = random.nextInt(99);
			String name = nlist.get(rindex);
			
			
			int i = PossibleOpponents.size();
			opposingTeam team = new opposingTeam(name, null);
			while (i < 4) {
				AthleteDatabase ath = new AthleteDatabase();
				String athstring = ath.makeAthleteString();
				Athlete athlete = ath.makeAthlete(athstring);
				team.addPlayer(athlete);
				i ++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		

	}

}
