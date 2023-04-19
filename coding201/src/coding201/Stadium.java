package coding201;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import coding201.AthleteClasses.Athlete;
import coding201.setupGame.opposingTeam;

import java.util.ArrayList;

public class Stadium {

	Hashtable<String, ArrayList<Athlete>> PossibleOpponents =  new Hashtable<>();
	int gamesPlayed = 0;
	
	
	
	
	
	
	public void fillOpponentTable() {
		while (PossibleOpponents.size() < 2) {
			Random random = new Random();
			teamDatabase ting = new teamDatabase();
			List<String> nlist = ting.getList();
			int rindex = random.nextInt(99);
			String name = nlist.get(rindex);
			ArrayList<Athlete> alist = new ArrayList<Athlete>();
			opposingTeam team = new opposingTeam(name, alist);
			team.Fill();
			PossibleOpponents.put(team.teamName, team.athleteList);
			
		}
	}
	
	
	public static void main(String[] args) {
		
		Stadium topspur = new Stadium();
		topspur.fillOpponentTable();
		System.out.println(topspur.PossibleOpponents);
		
		

	}

}
