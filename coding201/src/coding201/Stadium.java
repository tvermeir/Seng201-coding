package coding201;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Stadium {

	Hashtable<String, ArrayList<String>> PossibleOpponents =  new Hashtable<>();
	int gamesPlayed = 0;
	
	
	
	
	
	
	public void fillOpponentTable() {
		while (PossibleOpponents.size() < 3) {
			Random random = new Random();
			teamDatabase ting = new teamDatabase();
			List<String> nlist = ting.getList();
			int rindex = random.nextInt(99);
			String name = nlist.get(rindex);
			ArrayList<Athlete> alist = new ArrayList<Athlete>();
			opposingTeam team = new opposingTeam(name, alist);
			team.Fill();
			team.addNamess();
			PossibleOpponents.put(team.teamName, team.nameList);
			
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Stadium topspur = new Stadium();
		topspur.fillOpponentTable();
		System.out.println(topspur.PossibleOpponents);
		
		

	}

}
