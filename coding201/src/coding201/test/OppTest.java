package coding201.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import org.junit.jupiter.api.Test;
import coding201.code.*;

class OppTest {

	@Test
	void testNullConstructor() {
		opposingTeam opps = new opposingTeam();
		assertNotEquals(null, opps.name);
	}
	@Test
	void testNameConstructor() {
		opposingTeam opps = new opposingTeam("Test");
		assertEquals("Test", opps.name);
	}
	@Test
	void testFullConstructor() {
		Hashtable<String, Athlete> inlist = new Hashtable<String, Athlete>();
		Athlete athlete = new Athlete(50, 50, 50, "Lionel Messi");
		inlist.put("Lionel Messi", athlete);
		opposingTeam opps = new opposingTeam("Test", inlist);
		assertEquals(opps.newathleteList.get("Lionel Messi"), athlete);
	}
	@Test
	void testString() {
		Hashtable<String, Athlete> inlist = new Hashtable<String, Athlete>();
		Athlete athlete = new Athlete(50, 50, 50, "Lionel Messi");
		inlist.put("Lionel Messi", athlete);
		opposingTeam opps = new opposingTeam("Test", inlist);
		assertNotEquals(opps.toString(), null);
	}
	

}
