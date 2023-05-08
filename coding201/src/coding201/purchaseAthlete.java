package coding201;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Hashtable;

public class purchaseAthlete {
	public Hashtable<String, Athlete> playerHashTable = new Hashtable<>();
	public Hashtable<String, Athlete> playersInTeam = new Hashtable<>();
	public int balance;
	
	public purchaseAthlete(Hashtable<String, Athlete> athletesInStore,PlayerClub myClub) {
		playerHashTable = athletesInStore;
		playersInTeam = myClub.athleteList;
		balance = myClub.balance;
		
	}
 public int purchaseAthletes() {
		
		System.out.println(playerHashTable);
		System.out.println("\nIf you want to purchase an athlete please type the corresponding name in. ");
		Scanner athleteName = new Scanner(System.in);
		String playerName = athleteName.nextLine();
		
		boolean isavailable = playerHashTable.containsKey(playerName);
		if (isavailable) { 
			Athlete val = playerHashTable.get(playerName);
			
			int price = val.price;
		
		
			if(balance - price >=0) {
				
				String swapPlayerString = doesContain(playerName, athleteName);
			
				playersInTeam.remove(swapPlayerString);
				playersInTeam.put(playerName, playerHashTable.get(playerName));
				playerHashTable.remove(playerName);
				balance -= price;
				
				
				
				
			}
			else if (balance - price < 0) {
				System.out.println("You do not have the funds to purchase this player!");
				purchaseAthletes();
				
			}
		}
		
		else if (!isavailable) {
			System.out.println("Please enter correct name");
			purchaseAthletes();
		}
		
		return balance;
		
	}
 	public String doesContain( String playerName, Scanner athleteName) {
		System.out.println(playersInTeam);
		System.out.println("Please enter the player you want to swap "+ playerName + " with from your club:");
		String swapPlayerString = athleteName.nextLine();
		if(playersInTeam.containsKey(swapPlayerString)) {
			return swapPlayerString;
			
		}
		else
		{
			System.out.println("Please enter in a correct name");
			doesContain(playerName, athleteName);
		}
		return "ffss";
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
