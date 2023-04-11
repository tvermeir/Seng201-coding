package coding201;

import java.util.Random;
import java.util.List;


public class AthleteDatabase {

	playerDatabase nameList = new playerDatabase();
	List<String> nlist = nameList.getList();
	
	public String makeAthlete() {
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
		stats += (int)price;
		
		
		
		int rindex = random.nextInt(570);
		String name = nlist.get(rindex);
		return stats+name;
		
	}
	
	
	
	public static void main(String[] args) {
		AthleteDatabase ting = new AthleteDatabase();
		System.out.println(ting.makeAthlete());

	}

}
