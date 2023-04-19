package coding201;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Hashtable;

public class purchaseAthlete {
 int purchaseAthlete() {
		
		System.out.println(playerHashTable);
		System.out.println("\nIf you want to purchase an athlete please type the corresponding name in. ");
		Scanner athleteName = new Scanner(System.in);
		String playerName = athleteName.nextLine();
		
		boolean isavailable = playerHashTable.containsKey(playerName);
		if (isavailable) { 
			String val = playerHashTable.get(playerName);
			List<String> athList = Arrays.asList(val.split(","));
			int price = Integer.valueOf(athList.get(3));
		
		
			if(balance - price >=0) {
				
				String swapPlayerString = doesContain(playerName, athleteName);
			
				playersInTeam.remove(swapPlayerString);
				playersInTeam.put(playerName, playerHashTable.get(playerName));
				playerHashTable.remove(playerName);
				balance -= price;
				
				
				
			}
			else if (balance - price < 0) {
				System.out.println("You do not have the funds to purchase this player!");
				purchaseAthlete();
				
			}
		}
		
		else if (!isavailable) {
			System.out.println("Please enter correct name");
			purchaseAthlete();
		}
		
		return balance;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
