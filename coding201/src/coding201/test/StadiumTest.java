package coding201.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import coding201.code.*;
class StadiumTest {

	@Test
	void testConstructor() {
		PlayerClub club = new PlayerClub(5, "Liverpool");
		Stadium anfield = new Stadium(club);
		assertEquals(anfield.club, club);
	}
	@Test
	void testTableFiller() {
		PlayerClub club = new PlayerClub(5, "Chelsea");
		Stadium stamfordBridge = new Stadium(club);
		stamfordBridge.fillOpponentTable();
		assertEquals(5, stamfordBridge.PossibleOpponents.size());
	}

}
