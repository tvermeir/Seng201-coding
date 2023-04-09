package coding201;

import java.util.Scanner;

public class clubSetup {
	public double difficultyMultiplier = 1;
	public int money = 100;

	public String clubName() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Please enter your club name: ");
		String clubName = myObj.nextLine();
		
		
		
		System.out.println("Type y to confirm and n to go back");
		
		String letterConfirmString = myObj.nextLine();
		
		if(letterConfirmString.equals("y")) {
			System.out.println("You have chosen: " + clubName +" as your team name");
		}
		else {
			clubName();
		}
		return clubName;
	}
	
	public double setDifficulty() {
		
		Scanner difficulty = new Scanner(System.in);
		System.out.println("Please select a difficulty \nEasy \nNormal \nHard");
		String decision = difficulty.nextLine();
		
		if(decision.toLowerCase().equals("easy")) {
			difficultyMultiplier = 0.5;
			return difficultyMultiplier;
		}
		else if(decision.toLowerCase().equals("normal")) {
			difficultyMultiplier = 1.00;
			return difficultyMultiplier;
		}
		else if(decision.toLowerCase().equals("hard")) {
			difficultyMultiplier = 2.00;
			return difficultyMultiplier;
		}
		else {
			System.out.println("\nPlease enter either Easy, Normal or Hard\n\n");
			setDifficulty();
		}
		
		return difficultyMultiplier;
	}
	public int getMoney() {
		if(difficultyMultiplier == 2.00) {
			money = 75;
			return money;
		}
		else if(difficultyMultiplier == 1.00) {
			money = 100;
			return money;
		}
		else if(difficultyMultiplier == 0.5) {
			money = 150;
			return money;
		}
		return money;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
