package coding201;

public class Athlete{
	public int attack;
	public int defense;
	public int health;
	public int price;
	public int stamina = 100;
	public String name;
	

	
	public Athlete(int attack, int defense, int health, int price, String name) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.price = price;
	}
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getHealth() {
		return health;
		
	}
	
	public int getStamina() {
		return stamina;
	}
	public String getHashtable(){
		String statsString = (attack + "," + defense + "," + health + "," + price);
		
		
		return statsString;
		
	}
	
	public void useBangage() {
		health = 100;
	}
	public void useAttackTraining() {
		attack += 5;
		if (attack >= 100) {
			attack = 100;
		}
	}
	public void useDefenseTraining() {
		defense += 5;
		if (defense >= 100) {
			defense = 100;
		}
	}
	
	
	
	public String toString() {
		return (" Defense: " + defense+ ", Attack: "+ attack + ", Price: $" + price);
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	

}
