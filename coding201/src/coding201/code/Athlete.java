package coding201.code;

/**
 * Athlete
 *The athlete class is the constructor for all of the athletes in the game. 
 *When athletes are initialized, they are given stats from this class, 
 *including attack, defense, price and their name. The Athletes are used all over the program
 *
 *@version 1.0
 *@author tve21
 *@author bro82
 */
public class Athlete{ 
	/**\
	 * Attack rating 
	 */
	public int attack;
	/**\
	 * Defense rating 
	 */
	public int defense;
	/**\
	 * Price of player
	 */
	public int price = 0;
	/**\
	 * Player Stamina
	 */
	public int stamina = 100;
	/**\
	 * Player Name
	 */
	public String name;
	/**\
	 * Sell price of player
	 */
	public int sellPrice;
	

	/**\
	 * The constructor here takes in statistics of attack,defense,price and name
	 * and setting them equal to values in this class
	 * 
	 * @param attack an integer value for attack.
	 * @param defense an integer value for defense
	 * @param price an integer value for price
	 * @param name a string value for name
	 * 
	 */
	public Athlete(int attack, int defense, int price, String name) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.price = price;
		this.sellPrice = (price / 2);
	}
	/**\
	 * Returns the attack integer value of the player
	 *
	 * @return int attack
	 */
	public int getAttack() {
		return attack;
	}
	/**\
	 * Returns the defense integer value of the player
	 * 
	 * @return int defense
	 */
	public int getDefense() {
		return defense;
	}
	
	/**\
	 * Returns the name integer value of the player
	 *
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	/**\
	 * Returns the price integer value of the player
	 * 
	 * @return int price
	 */
	public int getPrice() {
		return price;
	}
	

	/**\
	 * Returns the stamina integer value of the player
	 * 
	 * @return int stamina
	 */
	public int getStamina() {
		return stamina;
	}
	
	/**\
	 * Called whenever the user wants to apply an active recovery to the player
	 * Increases the stamina of the player and ensures it does not go over 100
	 * 
	 */
	public void useRecovery() {
		stamina += 50;
		if (stamina >= 100) {
			stamina = 100;
		}
	}
	/**\
	 * Called whenever the user wants to apply an attack training boost to the player
	 * Increases the attack of the player by 15 and ensures it does not go over 100
	 * 
	 */
	public void useAttackTraining() {
		attack += 15;
		if (attack >= 100) {
			attack = 100;
		}
	}
	/**\
	 * Called whenever the user wants to apply an defense training boost to the player
	 * Increases the defense of the player by 15 and ensures it does not go over 100
	 * 
	 */
	public void useDefenseTraining() {
		defense += 15;
		if (defense >= 100) {
			defense = 100;
		}
	}
	
	/**\
	 * returns a String version of the Athlete's statistics
	 */
	public String toString() {
		return (" Defense: " + defense+ ", Attack: "+ attack + ", Price: $" + price);
	}
	
	
	/**\
	 * Called whenever the user skips a week and it randomly picks this method. It increases the player's atack and defense by 5 points each
	 * if it is close to 100, it increases it to 100.
	 * 
	 */
	public void boostStat() {
		attack += 5;
		if (attack >= 100) {
			attack = 100;
		}
		defense += 5;
		if (defense >= 100) {
			defense = 100;
		}
		
		
	}
	


	
	
	

}
