package coding201.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import coding201.code.*;
import java.util.Hashtable;

class StoreTest {

	@Test
	void testConstructor() {
		PlayerClub club = new PlayerClub(5, "Test");
		Store store = new Store(club);
		assertEquals(store.myClub, club);
	}
	@Test
	void testRefresh() {
		PlayerClub club = new PlayerClub(5, "Test");
		Store store = new Store(club);
		Hashtable<String, Athlete> players = store.playerHashTable;
		store.refreshStore();
		assertNotEquals(players, store.playerHashTable);
		
	}
	

}
