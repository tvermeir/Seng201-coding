package coding201;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class AthleteDatabase {

	playerDatabase nameList = new playerDatabase();
	List<String> nlist = nameList.getList();
	ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	
	public String makeAthleteString() {
		Random random =  new Random();
		String stats = "";
		int sum = 0;
		int i = 0;
		while (i < 3) {
			int num = random.nextInt(90) + 10;
			stats += num;
			stats += ",";
			sum += num;
			i += 1;
		}
		
		float price = sum/3;
		Math.floor(price);
		int pricevar = random.nextInt(5 + 5) + -5; 
		price += pricevar;
		stats += (int)price;
		stats += ",";
		
		
		
		int rindex = random.nextInt(572);
		String name = nlist.get(rindex);
		return stats+name;
		
	}
	
	public Athlete makeAthlete(String athleteString) {
		List<String> athList = Arrays.asList(athleteString.split(","));
		int attack = Integer.valueOf(athList.get(0));
		int defense = Integer.valueOf(athList.get(1));
		int health = Integer.valueOf(athList.get(2));
		int price = Integer.valueOf(athList.get(3));
		String name = athList.get(4);
		Athlete newAth = new Athlete(attack, defense, health, price, name);
		return newAth;
		
	}
	
	
	public Athlete getAthlete() {
		 return this.getAthlete(1);
	}
	
	public Athlete getAthlete(double difficulty) {
		
		Random random =  new Random();
		String stats = "";
		int sum = 0;
		int i = 0;
		while (i < 3) {
			int num = random.nextInt(80) + 10;
			num += (difficulty*12);
			if (num > 99) {
				num = 99;
			}
			stats += num;
			stats += ",";
			sum += num;
			i += 1;
		}
		
		float price = sum/3;
		Math.floor(price);
		int pricevar = random.nextInt(5 + 5) + -5; 
		price += pricevar;
		stats += (int)price;
		stats += ",";
		
		
		
		int rindex = random.nextInt(572);
		String name = nlist.get(rindex);
		stats += name;
		
		List<String> athList = Arrays.asList(stats.split(","));
		int attack = Integer.valueOf(athList.get(0));
		int defense = Integer.valueOf(athList.get(1));
		int health = Integer.valueOf(athList.get(2));
		int theprice = Integer.valueOf(athList.get(3));
		String thename = athList.get(4);
		Athlete newAth = new Athlete(attack, defense, health, theprice, thename);
		return newAth;
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		AthleteDatabase ting = new AthleteDatabase();
		
		Athlete man = ting.getAthlete(0.5);
		System.out.println(man);
		

	}

}
