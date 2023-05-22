package coding201.test;
import coding201.code.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AthleteTest {

	@Test
	void staminaTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		athlete.stamina = 0;
		athlete.useRecovery();
		assertEquals(50, athlete.getStamina());
	}
	@Test
	void staminaTooHighTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		athlete.stamina = 100;
		athlete.useRecovery();
		assertEquals(100, athlete.getStamina());
	}
	@Test
	void attackTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		athlete.attack = 0;
		athlete.useAttackTraining();
		assertEquals(15, athlete.getAttack());
	}
	@Test
	void attackTooHighTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		athlete.attack = 100;
		athlete.useAttackTraining();
		assertEquals(100, athlete.getAttack());
	}
	
	@Test
	void defenseTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		athlete.defense = 0;
		athlete.useDefenseTraining();
		assertEquals(15, athlete.getDefense());
	}
	@Test
	void defenseTooHighTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		athlete.defense = 100;
		athlete.useDefenseTraining();
		assertEquals(100, athlete.getDefense());
	}
	@Test
	void boostStatTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		athlete.defense = 0;
		athlete.attack = 0;
		athlete.boostStat();
		assertEquals(5, athlete.getDefense());
		assertEquals(5, athlete.getAttack());
	}
	@Test
	void boostStatTooHighTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		athlete.defense = 100;
		athlete.attack = 100;
		athlete.boostStat();
		assertEquals(100, athlete.getDefense());
		assertEquals(100, athlete.getAttack());
	}
	@Test
	void priceTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		assertEquals(50, athlete.getPrice());
	}
	@Test
	void nameTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		assertEquals("TestThlete", athlete.getName());
	}
	@Test
	void toStringTest() {
		Athlete athlete = new Athlete(50, 50, 50, "TestThlete");
		assertEquals(" Defense: 50, Attack: 50, Price: $50", athlete.toString());
	}
	
	
	

}
