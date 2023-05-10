package coding201;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;



import java.util.List;


public class matchRunner {
	
	public Hashtable<String, Athlete> player;
	public opposingTeam opposition;
	
	public ArrayList<String> listKeysOfTeam;
	public ArrayList<String> listKeysOfOpposition;
	public PlayerClub playerClub;




	public matchRunner(PlayerClub player, opposingTeam opps) {
		this.playerClub = player;
		this.opposition = opps;
	
		
	}
	
	
	public void playMatch()  {
		int minutespassed = 10;
		int myClubScore = 0;
		int oppScore = 0;
		
		Random random = new Random();
		
		otherEvents otherEvents = new otherEvents();
		goalEvents goalEvents = new goalEvents();
		List<String> otherEventsList = otherEvents.getList(); 
		List<String> goalEventsList = goalEvents.getList();
		
		System.out.println("Match begins between " + playerClub.getName() + " and " + opposition.name);
		
		System.out.println("\nHere is the starting lineup for " + playerClub.getName());
		System.out.println(playerClub.printAthleteList());
		
		System.out.println("\nHere is the starting lineup for " + opposition.name);
		System.out.println(opposition.printAthleteList());	
		for (int i = 0; i < 3; i++) {
			try {
				  Thread.sleep(1000); 
				} catch (Exception e) {
				    e.printStackTrace();
				}
			System.out.println("Simulating game.......\n");
			
		}
		
		System.out.println("\n Game Events: \n");
		
		while (minutespassed <= 90) {
			
			
			
			int event = random.nextInt(2);
			
			int number = random.nextInt(4);
			List<String> listKeysOfTeam = new ArrayList<String>(playerClub.athleteList.keySet());
			String playerName = listKeysOfTeam.get(number);
			Athlete myPlayer = playerClub.athleteList.get(playerName);
			
			int number1 = random.nextInt(4);
			List<String> listKeysOfOpposition = new ArrayList<String>(opposition.athleteList.keySet());
			String oppositionPlayer = listKeysOfOpposition.get(number1);
			Athlete oppPlayer = opposition.athleteList.get(oppositionPlayer);
			
			System.out.println("Minutes: "+ minutespassed + ":00");
			
			if(event == 0) {
				boolean working = true;
					//Randomly selects a player by converting the hashtable keys into an array list, before getting the persons name and getting their attack stat 
				while(working) {
					int attackRatingPlayer = myPlayer.getAttack();
					
					
					int defenseRatingOpps = oppPlayer.getDefense();
					
					if(attackRatingPlayer >= defenseRatingOpps) {
						int eventNumber = random.nextInt(goalEventsList.size());
						System.out.println(myPlayer.name + " " + goalEventsList.get(eventNumber) + "\n");
						myClubScore +=1;
						working = false;
					
					}
					else {
						int eventNumber = random.nextInt(otherEventsList.size());
						System.out.println(myPlayer.name + " " + otherEventsList.get(eventNumber) + "\n");
						working = false;
						
						}
					minutespassed += 10;
				}
					
					
				
				
			
			}
			
			if(event == 1) {
					boolean working = true;
					while(working) {
						int defenseRatingPlayer = myPlayer.getDefense();
						
						
						int attackRatingOpp = oppPlayer.getAttack();
						
						if(defenseRatingPlayer <= attackRatingOpp) {
							int eventNumber = random.nextInt(goalEventsList.size());
							System.out.println(oppPlayer.name + " " + goalEventsList.get(eventNumber) + "\n" );
							oppScore+=1;
							working = false;
							
						}
						else {
							int eventNumber = random.nextInt(otherEventsList.size());
							System.out.println(oppPlayer.name + " " + otherEventsList.get(eventNumber)+ "\n" );
							working = false;
							}
					}
					
						
					minutespassed += 10;
				
				}
			System.out.println("Score = (" + opposition.name + " "+ oppScore + "-" + myClubScore + " " +  playerClub.getName() + ")");
			}
				
			
			
		System.out.println("Game has ended");
		
			
		}
		
	//implement timer every 3 seconds output text that is randomly selected from some prompts eg (todd vermeir is through on goal but [opposingplayer] prevents a goal with his superior defense
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
