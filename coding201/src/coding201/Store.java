package coding201;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
public class Store {
	
	Hashtable<String, String> playersInTeam =  new Hashtable<>();
	Hashtable<String, String> playerHashTable =  new Hashtable<>();
	
	public int balance;
	
	public Store(int balance, Hashtable<String, String> team) {
		
		this.balance = balance;
		this.playersInTeam = team;
		
	}
	public void refreshStore() {
		purchaseableAthletes playerHashTables = new purchaseableAthletes();
		playerHashTable = playerHashTables.addPurchasablePlayers();
	}
	
	public int purchaseAthlete() {
		
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
