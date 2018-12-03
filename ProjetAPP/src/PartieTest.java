import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.Partie;

class PartieTest {

	@Test
	void testInit() {
		
		Partie p = new Partie();
	
		p.init(p.getNbJoueurs());
		
		assertEquals(p.getEtape(), 1);
		assertEquals(p.getEssaisRestant(), 10);

		//TODO
	}
	
	void testToString() {
		//TODO
	}
	
	
	void testEssai() {
		//TODO
	}
	
	

	void testTraitementReponse() {
		//TODO
	}
	
	void testUpdateEtatACtuel() {
		// TODO
	}
}
