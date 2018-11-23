import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Essai {

	/**
	 * Le mot que les joueurs doivent deviner.
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
		tailleMot = Partie.getTaillemot();
		System.out.println("Nombre de lettres: " + tailleMot);
		System.out.println("Essai: " + nbEssai);
		
		Joueur joueur [] = Partie.getParticipants();
		int numMot = (int)(Math.random() * (Partie.getCpt()) + 1);
		while ((motATrouver = Partie.choixMot(numMot))==null) {
			numMot = (int)(Math.random() * (Partie.getCpt()) + 1);
			motATrouver = Partie.choixMot(numMot);
		}
		nbEssai++;		
	}
	
	void proposition() {
		
	}
	
	
	
	public Essai(int i) {
		Joueur joueurs [] = Partie.getParticipants();
	}
	
	public void initEtatActuel() {
		
	}
	
	public Mot motDansDict(int nbDeLettres) {
		return new Mot("el");
	}
	
	/*
	 * 	public Etat(String motATrouver){
			char [] characteres = motATrouver.toCharArray();
			for(int i = 0; i < characteres.length; i++) {
				int rand = (int)(Math.random() * characteres.length);
				char tmp = characteres[i];
				characteres[i] = characteres[rand];
				characteres[rand] = tmp;
			}
			this.motEtat = new String(characteres);
		}
	 */
	
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
