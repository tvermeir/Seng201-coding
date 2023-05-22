package coding201.code;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * AthleteDatabase
 *The athlete database is where an athlete is created. the name is taken from the playerDatabase list at random, given random stats
 * before the price is calculated using the average of all the stats. This class is used to create all athletes in the program.
 *@version 1.0
 *@author tve21
 *@author bro82
 */




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
	 * @param athleteString a visual representation of an athlete in string form
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
	
	

}
