package coding201;

import java.util.ArrayList;

public class PlayerClub {
	float bankBalance;
	int playerCount;
	String teamName;
	ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
	ArrayList<Athlete> starterList = new ArrayList<Athlete>();
	ArrayList<Athlete> reserveList = new ArrayList<Athlete>();
	ArrayList<PurchaseableItem> itemInventory = new ArrayList<PurchaseableItem>();
	ArrayList<Athlete> topScorer = new ArrayList<Athlete>();
	//ArrayList<Playercard> Cardlist = new ArrayList<Playercard>();
	
	public PlayerClub(float balance, String name, ArrayList<Athlete> athleteList) {
		bankBalance = balance;
		teamName = name;
		this.athleteList = athleteList;
		
	}
	
	
	public void makeReserve(Athlete athlete) {
		if (athleteList.contains(athlete)) {
			reserveList.add(athlete);
		}
		if (starterList.contains(athlete)) {
			starterList.remove(athlete);
		}
	}
	public void makeStarter(Athlete athlete) {
		if (athleteList.contains(athlete)) {
			starterList.add(athlete);
		}
		if (reserveList.contains(athlete)) {
			reserveList.remove(athlete);
		}
		
		
	}
	public float getBalance() {
		return bankBalance;
	}
	
	public boolean canPlay() {
		if (starterList.size() >= 4) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addPlayer(Athlete athlete) {
		if (!athleteList.contains(athlete)) {
			athleteList.add(athlete);
		}
		
		
	}
	
	public String getName() {
		return teamName;
	}
	
	
	
	public ArrayList<Playercard> getCardList() {
		for (Athlete athlete: athleteList) {
			Playercard card = new Playercard(athlete);
			Cardlist.add(card);
		}
		return Cardlist;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
	
	}
	
}
