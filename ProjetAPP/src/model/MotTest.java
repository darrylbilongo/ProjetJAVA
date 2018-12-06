package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class MotTest {

	@Test
	void test() {
		Mot m1 = new Mot("Souiller");
		Mot m2 = new Mot("Souiller");
		
		assertTrue(m1.getValeur().equals(m2.getValeur()));
		assertTrue(m1.comparer(m2));
	}

}
