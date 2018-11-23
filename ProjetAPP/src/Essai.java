import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
	
	private ArrayList<String> lettresActuelles;
	
	/**
	 * Cet attribut contient tous les mots déjà joués.
	 */
	private static ArrayList<String> motsDejaJoues;
	
	
	public Essai() {
		tailleMot = Partie.getTaillemot();
		motsDejaJoues = new ArrayList<String>();
		lettresActuelles = new ArrayList<String>();
		System.out.println("\nNombre de lettres: " + tailleMot);
		System.out.println("Essai: " + nbEssai);
		Joueur joueur [] = Partie.getParticipants();
		int numMot = (int)(Math.random() * (Partie.getCpt()) + 1);
		while((motATrouver = Partie.choixMot(numMot)) == null && motsDejaJoues.contains(motATrouver.getValeur()))
		{
			numMot = (int)(Math.random() * (Partie.getCpt()) + 1);
			motATrouver = Partie.choixMot(numMot);
		}
		nbEssai++;		
		System.out.println(motATrouver.getValeur());
		initMotATrouver();
		System.out.println(etatActuel.getValeur());
		motsDejaJoues.add(motATrouver.getValeur());
	}
	
	void traitementProposition() throws IOException {
		Joueur joueur = Partie.getParticipants()[0];
		Mot mot ;
		mot = joueur.proposerMot();
		if(mot.getValeur().equals(motATrouver.getValeur())) {
			joueur.pointsPlus();
		}
		else {
			if(verifierMot(mot) && mot.getValeur().length() == tailleMot) {
				System.out.println();
			}
			else {
				System.out.println("\tPas bon du tout!");
			}
		}
		
	}
	
	void traiterMot(Mot mot) {
		String s = mot.getValeur().toUpperCase();
		String m = motATrouver.getValeur().toUpperCase();
		String etat = "";
		String lettres[] = s.split("");
		for(int i = 0; i < s.length(); i++) {
			if(m.indexOf(lettres[i]) == i) {
				etat += lettres[i];
			}
		}
	}
	
	boolean verifierMot(Mot mot) {
		Scanner input = new Scanner("liste_francais.txt");
		while(input.hasNextLine()) {
			String line = input.nextLine();
			if(line == mot.getValeur()) {
				 return true;
			}
		}
		input.close();
		return false;
	}
	
	public void initMotATrouver() {
		String lettreMot[] = motATrouver.getValeur().toUpperCase().split("");
		String etatInit = "";
		for(int i = 0; i < tailleMot; i++) {
			if(i == 0 || i == 2) {
				etatInit += lettreMot[i];
				lettresActuelles.add(lettreMot[i]);
			}
			else {
				etatInit += "*";
			}
		}
		etatActuel = new Mot(etatInit);
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
		Partie p = new Partie();
		Essai e = new Essai();
	}

	public Mot getMotATrouver() {
		return motATrouver;
	}

	public void setMotATrouver(Mot motATrouver) {
		this.motATrouver = motATrouver;
	}

	public Mot getEtatActuel() {
		return etatActuel;
	}

	public void setEtatActuel(Mot etatActuel) {
		this.etatActuel = etatActuel;
	}

	public Joueur getJoueurActuel() {
		return joueurActuel;
	}

	public void setJoueurActuel(Joueur joueurActuel) {
		this.joueurActuel = joueurActuel;
	}

	public int getTailleMot() {
		return tailleMot;
	}

	public void setTailleMot(int tailleMot) {
		this.tailleMot = tailleMot;
	}

	public static int getNbEssai() {
		return nbEssai;
	}

	public static void setNbEssai(int nbEssai) {
		Essai.nbEssai = nbEssai;
	}
	
	
	
}
