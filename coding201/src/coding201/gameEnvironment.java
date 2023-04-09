package coding201;

public class gameEnvironment {
	String clubName;
	double difficulty;
	int money;
	
	public void getDetails(clubSetup myClub) {
		clubName = myClub.clubName();
		difficulty = myClub.setDifficulty();
		money = myClub.getMoney();
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		gameEnvironment helloEnvironment = new gameEnvironment();
		clubSetup myClub = new clubSetup();
		helloEnvironment.getDetails(myClub);
		
		
	}

}
