package coding201.test;
import coding201.code.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Hashtable;
import org.junit.jupiter.api.Test;

class ClubTest {
	@Test
	void testNullConstructor() {
		PlayerClub club = new PlayerClub();
		assertNotEquals(club, null);
	}
	@Test
	void testFullConstructor() {
		Hashtable<String, Athlete> athleteList2 = new Hashtable<String, Athlete>();
		Athlete athlete = new Athlete(50, 50, 50, "Test");
		athleteList2.put("Test", athlete);
		PlayerClub club = new PlayerClub(5, "Test", athleteList2);
		assertEquals(club.athleteList.contains(athlete), true);
		assertEquals(club.getName(), "Test");
	}
	
	@Test
	void testAddPlayer() {
		PlayerClub club = new PlayerClub(10, "Testenham Testspurs");
		Athlete athlete = new Athlete(50, 50, 50, "Test");
		club.athleteList.clear();
		club.starterList.clear();
		
		club.athleteList.put("Test", athlete);
		club.addPlayer(athlete);
		Hashtable<String, Athlete> testTable = new Hashtable<String, Athlete>();
		testTable.put(athlete.name, athlete);
		assertEquals(testTable.get("Test"), club.athleteList.get("Test"));
	}
	@Test   
	void testnullAddPlayer() {
		PlayerClub club = new PlayerClub(10, "Testenham Testspurs");
		Athlete athlete = new Athlete(50, 50, 50, "Test");
		club.athleteList.clear();
		club.starterList.clear();
		club.addPlayer(athlete);
		
		assertEquals(athlete, club.athleteList.get("Test"));
	}
	@Test
	void testFullAddPlayer() {
		PlayerClub club = new PlayerClub(10, "Testenham Testspurs");
		club.Fill();
		club.athleteList.clear();
		club.starterList.clear();
		club.Fill();
		PlayerClub club2 = club;
		club2.Fill();
		assertEquals(club2, club);
	}
	@Test
	void testSetName() {
		PlayerClub club = new PlayerClub(10, "Testenham Testspurs");
		club.setName("Testsea");
		assertEquals(club.name, "Testsea");
	}
	@Test
	void test0AddBought() {
		PlayerClub club = new PlayerClub(10, "Testenham Testspurs");
		Athlete athlete = new Athlete(50, 50, 50, "Test");
		club.addBoughtPlayer(athlete);
		assertEquals(club.addBoughtPlayer(athlete), athlete);
	}
	@Test
	void test4AddBought() {
		PlayerClub club = new PlayerClub(10, "Testenham Testspurs");
		Athlete athlete1 = new Athlete(50, 50, 50, "Test1");
		club.addPlayer(athlete1);
		Athlete athlete2 = new Athlete(50, 50, 50, "Test2");
		club.addPlayer(athlete2);
		Athlete athlete3 = new Athlete(50, 50, 50, "Test3");
		club.addPlayer(athlete3);
		Athlete athlete4 = new Athlete(50, 50, 50, "Test4");
		club.addPlayer(athlete4);
		Athlete athlete5 = new Athlete(50, 50, 50, "Test5");
		club.addBoughtPlayer(athlete5);
		assertNotEquals(club.addBoughtPlayer(athlete5).name, athlete5);
	}
	@Test
	void testAddItem() {
		PlayerClub club = new PlayerClub(10, "Testenham Testspurs");
		PurchaseableItem item = new PurchaseableItem("test", 1, "Test");
		club.addItem(item);
		assertEquals(1, club.itemInventory.get(item.name).getPrice());
		club.removeItem(item.name);
		assertEquals(true, club.getInventory().isEmpty());
		
	}
	@Test
	void testPrintAthletes() {
		PlayerClub club = new PlayerClub(10, "Bott-Arsen-le FC");
		Athlete athlete1 = new Athlete(50, 50, 50, "Perling Paaland");
		club.addPlayer(athlete1);
		assertEquals("\nPerling Paaland:  Defense: 50, Attack: 50, Price: $50\n", club.printAthleteList());
	}
	@Test
	void testReShuffle() {
		PlayerClub club = new PlayerClub(10, "Bott-Arsen-le FC");
		Athlete athlete1 = new Athlete(50, 50, 50, "Test1");
		club.addPlayer(athlete1);
		Athlete athlete2 = new Athlete(50, 50, 50, "Test2");
		club.addPlayer(athlete2);
		Athlete athlete3 = new Athlete(50, 50, 50, "Test3");
		club.addPlayer(athlete3);
		Athlete athlete4 = new Athlete(50, 50, 50, "Test4");
		club.addPlayer(athlete4);
		Athlete athlete5 = new Athlete(50, 50, 50, "Perling Paaland");
		club.addPlayer(athlete5);
		club.athleteList.remove(athlete4.getName());
		club.starterList.remove(athlete4.getName());
		club.reShuffle();
		assertEquals(club.starterList.size(), 4);
		
	}
	
	

}
