package jUnitTest;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import model.Mot;
import model.Partie;

public class PartieTest {
	Partie partie1 ;
	Partie partie2;
	
	//initiation des attributs
	@Before
	public void setUp() {
		partie1 = new Partie();
		partie2 = new Partie();
		try {
			partie1.init(1);//cas où le nombre de joueurs est égal à 1
			partie2.init(2);//cas où le nombre de joueurs est égal à 2
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//test de la methode init()
	@Test
	public void testInit() {	
		assertEquals(partie1.getNbJoueurs(), 1); 
		assertEquals(partie1.getEtape(), 1);
		assertTrue((partie1.getJoueurActuel().isMain()));
		
		assertEquals(partie2.getNbJoueurs(), 2);
		assertEquals(partie2.getEtape(), 1);
		assertTrue((partie2.getJoueurActuel().isMain()));
	}
	
	@Test
	public void testTraitementReponse() {
		partie1 = new Partie();
		try {
			partie1.getEssai();
			String tab[] = {"poposs", "arbusse", "Toulosse", "broquantt", "mystrrieux"};//vue que les mots sont tirés au hasard je m'assure que ces mots ne figurent dans le dictionnaire
			String str = "";
			for(int i = 0; i < tab.length; i++) {
				if(Partie.getTaillemot() == tab[i].length()) {
					str = tab[i];
				}
			}

			assertFalse(partie1.traitementReponse(new Mot(str)));
			assertFalse(partie1.traitementReponse(new Mot("")));
			assertFalse(partie1.traitementReponse(new Mot("L")));
			assertTrue(partie1.traitementReponse(partie1.getMotATrouver()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//test de la methode Traitermot()
	/*@Test
	public void testTraiterMot() {
		partie1 = new Partie();
		try {
			partie1.init(1);//cas où le nombre de joueurs est égal à 1
			partie1.getEssai();
			String tab[] = {"poposs", "arbusse", "Toulosse", "broquantt", "mystrrieux"};//vue que les mots sont tirés au hasard je m'assure que ces mots ne figurent dans le dictionnaire
			String str = "";
			for(int i = 0; i < tab.length; i++) {
				if(Partie.getTaillemot() == tab[i].length()) {
					str = tab[i];
				}
			}
			partie1.traiterMot(new Mot("str"));
			assertNotNull(partie1.getLettresActuelles());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}*/

	//test de la méthode getEssai()
	@Test
	public void testGetEssai() {
		partie1 = new Partie();
		try {
			partie1.init(1);
			partie1.getEssai();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(partie1.getMotATrouver().getValeur().length(), Partie.getTaillemot());
		assertEquals(partie1.getLettresActuelles().length, Partie.getTaillemot());
		
	}
	
	//Test de la methode countOccurences()
	@Test
	public void testCountOccurences() {
		partie1 = new Partie();
		try {
			partie1.init(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(partie1.countOccurences("e", "eliminer".split("")), 2);
		assertNotEquals(partie1.countOccurences("e", "admirables".split("")), 3);
	}
	
	//test de la methode updateEtatActuel
	@Test
	/*public void testUpdateEtatActuel() {
		partie1 = new Partie();
		try {
			partie1.init(1);//cas où le nombre de joueurs est égal à 1
			partie1.getEssai();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String tab[] = {"poposs", "arbusse", "Toulosse", "broquantt", "mystrrieux"};//vue que les mots sont tirés au hasard je m'assure que ces mots ne figurent dans le dictionnaire
		String str = "";
		for(int i = 0; i < tab.length; i++) {
			if(partie1.getTaillemot() == tab[i].length()) {
				str = tab[i];
			}
		}
		partie1.traiterMot(new Mot(str));
	}
	
	@Test
	/*public void testInitEtatActuel() throws IOException {
		Partie p = new Partie();
		p.init(1);
		p.getEssai();
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
	*/

	public void testVerifierMot() {
		partie1 = new Partie();
		try {
			partie1.init(1);
			partie1.getEssai();
			assertFalse(partie1.verifierMot(new Mot("abracadabra")));
			assertTrue(partie1.verifierMot(new Mot("abolition")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}