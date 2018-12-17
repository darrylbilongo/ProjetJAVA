package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

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
	
	@Test
	void testTraitementReponse() {
		
		Partie p = new Partie();
		p.init(1);
		Mot mot = new Mot("Sauce");
		
		try {
			p.setMotATrouver(new Mot("Sauce"));
			assertTrue(p.traitementReponse(mot));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testTraiterMot() {
		
		Partie p = new Partie();
		p.init(1);
		p.setMotATrouver(new Mot("Traitement"));
		
		Mot mot = new Mot("Traitement");
		
		p.traiterMot(mot);
		
		String[] lettresAct = p.getLettresActuelles();
		
		for(int i = 0; i < mot.getValeur().length() ; i++) {
			lettresAct[i] = Character.toString(mot.getValeur().charAt(i));
		}
		
		assertEquals(p.getLettresActuelles().toString(), lettresAct.toString());
		
	}

	
	@Test
	void test
}
