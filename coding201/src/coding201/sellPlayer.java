package coding201;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class sellPlayer {
	private Hashtable<String, String> playersCanSell = new Hashtable<>();
	private int money;
	public sellPlayer(Hashtable<String, String> playersInTeam, int balance) {
		playersCanSell = playersInTeam;
		money = balance;
	}
	public int playerSell() {
		System.out.println(playersCanSell);
		System.out.println("\nIf you want to sell an athlete please type the corresponding name in. ");
		
		Scanner athleteName = new Scanner(System.in);
		String playerName = athleteName.nextLine();
		

		boolean isavailable = playersCanSell.containsKey(playerName);
		if (isavailable) { 
			String val = playersCanSell.get(playerName);
			List<String> athList = Arrays.asList(val.split(","));
			int price = Integer.valueOf(athList.get(3));

			playersCanSell.remove(playerName);
			money += (price*0.75);
						
			
		}	
		else {
			System.out.println("Please enter correct name");
			playerSell();
		}
		
		return money;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
