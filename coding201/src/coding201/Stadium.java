package coding201;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Stadium {

	Hashtable<String, opposingTeam> PossibleOpponents =  new Hashtable<>();
	int gamesPlayed = 0;
	
	
	
	
	
	
	public Hashtable<String, opposingTeam> fillOpponentTable() {
		while (PossibleOpponents.size() < 3) {
			Random random = new Random();
			teamDatabase ting = new teamDatabase();
			List<String> nlist = ting.getList();
			int rindex = random.nextInt(99);
			String name = nlist.get(rindex);
			Hashtable<String, Athlete> alist = new Hashtable<>();
			opposingTeam team = new opposingTeam(name, alist);
			team.Fill();
			PossibleOpponents.put(team.teamName, team);
			
		}
		return PossibleOpponents;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Stadium topspur = new Stadium();
		topspur.fillOpponentTable();
		System.out.println(topspur.PossibleOpponents);
		
		

	}

}
