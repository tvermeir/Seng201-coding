package coding201;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Stadium {

	Hashtable<String, opposingTeam> PossibleOpponents =  new Hashtable<>();
	Hashtable<String, Athlete> selectedTeam = new Hashtable<>();
	int gamesPlayed = 0;
	
	
	
	
	
	
	public Hashtable<String, opposingTeam> fillOpponentTable() {
		while (PossibleOpponents.size() < 4) {
			Random random = new Random();
			teamDatabase teamName = new teamDatabase();
			List<String> nlist = teamName.getList();
			int rindex = random.nextInt(99);
			String name = nlist.get(rindex);
			Hashtable<String, Athlete> alist = new Hashtable<>();
			opposingTeam team = new opposingTeam(name, alist);
			team.Fill();
			PossibleOpponents.put(team.teamName, team);
			
		}
		return PossibleOpponents;
	}
	
	
	public Hashtable<String, opposingTeam> selectedTeam(){
		PossibleOpponents.entrySet().forEach( entry -> {
		   System.out.println( entry.getKey() + ": \n" + entry.getValue()  + ("\n"));
		});
		Random random = new Random();
		int number = random.nextInt(3);
		List<String> listKeysOfTeam = new ArrayList<String>(PossibleOpponents.keySet());
		String teamName = listKeysOfTeam.get(number);
		
		
		
		
		return PossibleOpponents;

	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Stadium topspur = new Stadium();
		topspur.fillOpponentTable();
		//System.out.println(topspur.PossibleOpponents);
		
		topspur.selectedTeam();
	}

}
