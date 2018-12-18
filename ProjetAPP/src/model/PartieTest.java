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
		
		assertEquals(mot.getValeur(), p.getMotATrouver().getValeur());
		
		p.traiterMot(mot);
		
		assertTrue(true);

	}

	@Test
	void testGetEssai() {
		Partie p = new Partie();
		p.init(1);
		/*p.getEssai();
		assertEquals(p.getMotATrouver().getValeur(),"");
		assertNotNull(p.getLettresActuelles());
		assertNotNull(p.getLettresGUI());	*/
		
	}
	
	@Test
	void testUpdateEtatActuel() {
		Partie p = new Partie();
		p.init(1);
		p.getEssai();
		p.initEtatActuel();
		int taille = p.getTaillemot();
		
		assertEquals(taille, p.getEtatActuel().longueur());
	}
	
	@Test
	void testInitEtatActuel() {
		Partie p = new Partie();
		p.init(1);
		//p.getEssai();
		p.initEtatActuel();
		
		Mot m = p.getMotATrouver();
		String [] tmp = {};
		String [] mot = m.getValeur().split(""); 
		
		for(int i = 0; i < mot.length ; i++) {
			tmp[i] = "*";
		}
		
		tmp[0] = mot[0];
		tmp[2] = mot[2];
		
		assertTrue(p.getEtatActuel().getValeur().equals(tmp.toString()));
	}
}