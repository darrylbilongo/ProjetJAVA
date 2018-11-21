import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Essai {

	/**
	 * Mot que les joueurs doivent deviner.
	 */
	private Mot motATrouver;
	
	/**
	 * 
	 */
	private Mot etatActuel;
	private Joueur joueurActuel;
	private int tailleMot;
	private static int nbEssai = 0;
	
	
	public Essai() {
		nbEssai++;
		tailleMot = Partie.getTaillemot();
		System.out.println("Nombre de lettres: " + tailleMot);
		System.out.println("Essai: " + nbEssai);
		
		Joueur joueur [] = Partie.getParticipants();
		
		
		//classerMot(tailleMot);
		int numMot = (int)(Math.random() * (cpt) + 1);
		//choixMot(numMot);
		
	}
	
	public Essai(int i) {
		Joueur joueurs [] = Partie.getParticipants();
	}
	
	public void initEtatActuel() {
		
	}
	
	public Mot motDansDict(int nbDeLettres) {
		return new Mot("el");
	}
	
	
	public static void main(String[] args) {
		Essai e = new Essai();
		System.out.println(e.motATrouver.getValeur());
		try {
			Mot mot = new Mot();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
