package coding201;

import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Stadium {

	Hashtable<String, opposingTeam> PossibleOpponents =  new Hashtable<>();
	Hashtable<String, Athlete> selectedTeam = new Hashtable<>();
	int gamesPlayed = 0;
	PlayerClub club;
	int currWeek = 1;
	int weeksToPlay = 10;
	
	
	public Stadium(PlayerClub club) {
		this.club = club;
	}
	
	
	public Hashtable<String, opposingTeam> fillOpponentTable() {
		while (PossibleOpponents.size() < 5) {
			Random random = new Random();
			teamDatabase teamName = new teamDatabase();
			List<String> nlist = teamName.getList();
			int rindex = random.nextInt(99);
			String name = nlist.get(rindex);
			Hashtable<String, Athlete> alist = new Hashtable<>();
			opposingTeam team = new opposingTeam(name, alist);
			team.Fill();
			PossibleOpponents.put(team.name, team);
			
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
		
	}

}
