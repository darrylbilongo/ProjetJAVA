package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class PartieTest {

	@Test
	void testInit() {
		
		Partie p = new Partie();
		
		p.init(1);
		
		assertEquals(p.getNbJoueurs(), 1);
		assertEquals(p.getEtape(), 1);
		assertTrue((p.getJoueurActuel().isMain()));
	}

}
