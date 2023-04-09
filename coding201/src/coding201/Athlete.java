package coding201;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

import java.awt.Dimension;


public class Athlete{
	public int attack;
	public int defense;
	public double health;
	public double price;
	public int stamina = 100;
	public String name;

	
	public Athlete(int attack, int defense, double health, double price, String name) {
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
	
	public String toString() {
		return name;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PionelPessi pepsi = new PionelPessi();

	}
	
	

}
