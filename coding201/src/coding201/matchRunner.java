package coding201;

import java.awt.desktop.AboutHandler;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import javax.management.openmbean.OpenMBeanParameterInfoSupport;

import java.util.List;


enum matchEvents{
	ATTACK, DEFENSE
}

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
	
	
	public void playMatch() {
		int minutespassed = 0;
		Random random = new Random();
		otherEvents otherEvents = new otherEvents();
		goalEvents goalEvents = new goalEvents();
		List<String> otherEventsList = otherEvents.getList(); 
		List<String> goalEventsList = goalEvents.getList();
		
		
		
		System.out.println("Match begins between " + playerClub.getName() + " and " + opposition.getName());
		while (minutespassed <= 90) {
			int event = random.nextInt(2);
//			System.out.println(playerClub.athleteList);
//			System.out.println(opposition.athleteList);			
			int number = random.nextInt(4);
			List<String> listKeysOfTeam = new ArrayList<String>(playerClub.athleteList.keySet());
			String playerName = listKeysOfTeam.get(number);
			Athlete myPlayer = playerClub.athleteList.get(playerName);
			
			int number1 = random.nextInt(4);
			List<String> listKeysOfOpposition = new ArrayList<String>(opposition.athleteList.keySet());
			String oppositionPlayer = listKeysOfOpposition.get(number1);
			System.out.println(oppositionPlayer);
			System.out.println(opposition.newathleteList.get(oppositionPlayer));
			Athlete oppPlayer = opposition.newathleteList.get(oppositionPlayer);
			
			if(event == 0) {
					//Randomly selects a player by converting the hashtable keys into an array list, before getting the persons name and getting their attack stat 
					
					int attackRatingPlayer = myPlayer.getAttack();
					
					
					int defenseRatingOpps = oppPlayer.getDefense();
					
					if(attackRatingPlayer >= defenseRatingOpps) {
						int eventNumber = random.nextInt(goalEventsList.size());
						System.out.println(myPlayer.name + goalEventsList.get(eventNumber));
					}
					else {
						int eventNumber = random.nextInt(otherEventsList.size());
						System.out.println(myPlayer.name + otherEventsList.get(eventNumber));
						}
					continue;
					
				
				
			
			}
			
			if(event == 1) {
					
					int defenseRatingPlayer = myPlayer.getDefense();
					
					
					int attackRatingOpp = oppPlayer.getAttack();
					
					if(defenseRatingPlayer <= attackRatingOpp) {
						int eventNumber = random.nextInt(goalEventsList.size());
						System.out.println(oppPlayer.name + " " + goalEventsList.get(eventNumber));
					}
					else {
						int eventNumber = random.nextInt(otherEventsList.size());
						System.out.println(oppPlayer.name + " " + otherEventsList.get(eventNumber));
						}
					
				
				break;
				}
			
			}
				
			
			minutespassed += 10;
			
			
		}
		
	//implement timer every 3 seconds output text that is randomly selected from some prompts eg (todd vermeir is through on goal but [opposingplayer] prevents a goal with his superior defense
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
