package coding201;
import java.util.Scanner;
public class gameEnvironment {
	String clubName;
	double difficulty;
	
	public void getDetails(clubSetup myClub) {
		clubName = myClub.clubName();
		difficulty = myClub.setDifficulty();
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		gameEnvironment helloEnvironment = new gameEnvironment();
		clubSetup myClub = new clubSetup();
		helloEnvironment.getDetails(myClub);
		
		
	}

}
