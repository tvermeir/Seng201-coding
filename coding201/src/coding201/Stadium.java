package coding201;

import java.util.ArrayList;

public class Stadium {

	ArrayList<opposingTeam> PossibleOpponents = new ArrayList<opposingTeam>();
	int gamesPlayed = 0;
	
	public Stadium(PlayerClub club){
		if (!club.canPlay()){
			System.out.println("Not enough players, purchase some more or its gonna be game over. You fucking Retard.");
		}
		else {
			System.out.println("Pitch lookin lovely today lads.");
		}
	}
	
	public ArrayList<opposingTeam> viewOpponents() {
		return PossibleOpponents;
	}
	
	
	public static void main(String[] args) {
		

	}

}
