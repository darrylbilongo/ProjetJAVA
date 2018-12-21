package jUnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Mot;

class MotTest {

	@Test
	void test() {
		Mot m1 = new Mot("Souiller");
		Mot m2 = new Mot("Souiller");
		
		assertEquals(Mot.formatMot("Souiller"), "SOUILLER");
		assertEquals(Mot.formatMot("garçon"), "GARCON");
		assertEquals(Mot.formatMot("élévage"), "ELEVAGE");
	}

}
