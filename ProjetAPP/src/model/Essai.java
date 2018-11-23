package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class Essai {

	/**
	 * Le mot que les joueurs doivent deviner.
	 */
	private Mot motATrouver = new Mot("");
	
	/**
	 * 
	 */
	private Mot etatActuel;
	private Joueur joueurActuel;
	private int tailleMot;
	private static int nbEssai = 0;
	
	private String [] lettresActuelles;
	
	/**
	 * Cet attribut contient tous les mots déjà joués.
	 */
	private static ArrayList<String> motsDejaJoues;
	
	
	public Essai() throws IOException {
		tailleMot = Partie.getTaillemot();
		lettresActuelles = new String[tailleMot];
		motsDejaJoues = new ArrayList<String>();
		joueurActuel = Partie.getParticipants()[0];
		int numMot = (int)(Math.random() * (Partie.getCpt()) + 1);
		while((motATrouver = Partie.choixMot(numMot)) == null && 
				motsDejaJoues.contains(motATrouver.getValeur()))
		{
			numMot = (int)(Math.random() * (Partie.getCpt()) + 1);
			motATrouver = Partie.choixMot(numMot);
		}
		nbEssai++;
		initMotATrouver();
		System.out.println(motATrouver.getValeur());
		System.out.println("Le mot à trouver est: \n" + etatActuel.getValeur());
		for(int i = 0; i < 6; i++) {
			Mot m = joueurActuel.proposerMot();
			if(estTrouve(m))
				break;			
			System.out.println(etatActuel.getValeur());
		}
		System.out.println(motATrouver.getValeur());
	}
	
	
	private boolean estTrouve(Mot m) throws IOException {
		Joueur joueur = Partie.getParticipants()[0];
		if(m.getValeur().equals(motATrouver.getValeur())) {
			joueur.pointsPlus();
			etatActuel = motATrouver;
			return true;
		}
		else {
			if(verifierMot(m) && m.getValeur().length() == tailleMot) {
				traiterMot(m);
			}
		}
		return false;
		
	}
	
	void traiterMot(Mot mot) {
		String s = mot.getValeur();
		String m = motATrouver.getValeur();
		String lettres[] = s.split("");
		for(int i = 0; i < s.length(); i++) {
			
			if(m.indexOf(lettres[i]) == i) {
				lettresActuelles[i] = lettres[i];
				System.out.println(lettres[i] + " " + lettresActuelles[i]);
			}
			
			else if(m.contains(lettres[i])) {
				lettresActuelles[i] = "+";
				System.out.println(lettresActuelles[i]);
				lettres[i] = "";
			}
		}
		updateEtatActuel();
	}
	
	private void updateEtatActuel() {
		String s = "";
		for(int i = 0; i < lettresActuelles.length; i++) {
			s += lettresActuelles[i];
		}
		etatActuel.setValeur(s);
	}

		
	boolean verifierMot(Mot mot) throws FileNotFoundException {
		Scanner input = new Scanner(new File("liste_francais.txt"));
		while(input.hasNextLine()) {
			String line = input.nextLine();
			if(Mot.formatMot(line).equals(Mot.formatMot(mot.getValeur()))){
				 return true;
			}
		}
		input.close();
		return false;
	}
	
	public Mot chronometre(Joueur j) {
		Timer chrono = new Timer();
		Temps temps;
		chrono.schedule((temps=new Temps()), 1000, 1000);
		return temps.getMot();
	}
	
	public void initMotATrouver() {
		String lettreMot[] = motATrouver.getValeur().split("");
		String etatInit = "";
		for(int i = 0; i < tailleMot; i++) {
			if(i == 0 || i == 2) {
				etatInit += lettreMot[i];
				lettresActuelles[i] = lettreMot[i];
			}
			else {
				etatInit += "*";
				lettresActuelles[i] = "*";
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
	
	public static void main(String[] args){
		Partie p = new Partie();
		try {
			Essai e = new Essai();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
