package coding201;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class sellPlayer {
	private Hashtable<String, Athlete> playersCanSell = new Hashtable<>();
	private int money;
	public sellPlayer(PlayerClub myClub) {
		playersCanSell = myClub.athleteList;
		money = myClub.balance;
	}
	public int playerSell() {
		System.out.println(playersCanSell);
		System.out.println("\nIf you want to sell an athlete please type the corresponding name in. ");
		
		Scanner athleteName = new Scanner(System.in);
		String playerName = athleteName.nextLine();
		

		boolean isavailable = playersCanSell.containsKey(playerName);
		if (isavailable) { 
			Athlete val = playersCanSell.get(playerName);
			
			int price = val.price;

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
