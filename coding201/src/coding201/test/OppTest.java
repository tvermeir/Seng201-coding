package coding201.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import org.junit.jupiter.api.Test;
import coding201.code.*;

class OppTest {

	@Test
	void testNullConstructor() {
		OpposingTeam opps = new OpposingTeam();
		assertNotEquals(null, opps.name);
	}
	@Test
	void testNameConstructor() {
		OpposingTeam opps = new OpposingTeam("Test");
		assertEquals("Test", opps.name);
	}
	@Test
	void testFullConstructor() {
		Hashtable<String, Athlete> inlist = new Hashtable<String, Athlete>();
		Athlete athlete = new Athlete(50, 50, 50, "Lionel Messi");
		inlist.put("Lionel Messi", athlete);
		OpposingTeam opps = new OpposingTeam("Test", inlist);
		assertEquals(opps.newathleteList.get("Lionel Messi"), athlete);
	}
	@Test
	void testString() {
		Hashtable<String, Athlete> inlist = new Hashtable<String, Athlete>();
		Athlete athlete = new Athlete(50, 50, 50, "Lionel Messi");
		inlist.put("Lionel Messi", athlete);
		OpposingTeam opps = new OpposingTeam("Test", inlist);
		assertNotEquals(opps.toString(), null);
	}
	

}
