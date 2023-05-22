package coding201;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
<<<<<<< HEAD

/**
 * AthleteDatabase
 *The athlete database is where an athlete is created. the name is taken from the playerDatabase list at random, given random stats
 * before the price is calculated using the average of all the stats. This lass is used to create alll athletes in the program.
 *@version 1.0
 *@author tve21 & bro82
 */
=======
/**
 * AthleteDatabase
 * This class uses random numbers, along with names generated from the playerDatabase to create random athlete objects.
 * @version 1.0
 * @author tve21 & bro82
 *
 */

>>>>>>> branch 'main' of https://github.com/tvermeir/Seng201-coding.git
public class AthleteDatabase {

	playerDatabase nameList = new playerDatabase();
	List<String> nlist = nameList.getList();
	ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	
	/**
	 * Uses random numbers to generate a string representation of an Athlete, uses the sum of the stats with some random variance to find the price.
	 * Price is not recalculated after stats change to prevent the player from capitalising after the weekly special training.
	 * @return String representation of an athlete object in the form "attack, defense, price, name"
	 */
	
	public String makeAthleteString() {
		Random random =  new Random();
		String stats = "";
		int sum = 0;
		int i = 0;
		while (i < 2) {
			int num = random.nextInt(90) + 10;
			stats += num;
			stats += ",";
			sum += num;
			i += 1;
		}
		
		float price = sum/2;
		Math.floor(price);
		int pricevar = random.nextInt(5 + 5) + -5; 
		price += pricevar;
		stats += (int)price;
		stats += ",";
		
		
		
		int rindex = random.nextInt(572);
		String name = nlist.get(rindex);
		return stats+name;
		
	}
	/**
	 * Takes the string representation of an athlete and returns an athlete object, using the random string to generate it.
	 * @param athleteString
	 * @return athlete
	 */
	
	public Athlete makeAthlete(String athleteString) {
		List<String> athList = Arrays.asList(athleteString.split(","));
		int attack = Integer.valueOf(athList.get(0));
		int defense = Integer.valueOf(athList.get(1));
		int price = Integer.valueOf(athList.get(2));
		String name = athList.get(3);
		Athlete newAth = new Athlete(attack, defense, price, name);
		return newAth;
		
	}
	
	
	
	public static void main(String[] args) {
		
		

	}

}
