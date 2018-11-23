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
	
	private ArrayList<String> motsDejaUtilises;
	
	
	public Essai() throws IOException {
		initEssai();
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
	
	public void initEssai() {
		tailleMot = Partie.getTaillemot();
		lettresActuelles = new String[tailleMot];
		motsDejaJoues = new ArrayList<String>();
		motsDejaUtilises = new ArrayList<String>();
		joueurActuel = Partie.getParticipants()[0];
	}
	
	
	private boolean estTrouve(Mot m) throws IOException {
		Joueur joueur = Partie.getParticipants()[0];
		if(m.getValeur().equals("")) {
			joueur.setErreur(true);
			return false;
		}
		else if(m.getValeur().equals(motATrouver.getValeur())) {
			joueur.pointsPlus();
			etatActuel = motATrouver;
			return true;
		}
		else if(m.getValeur().charAt(0) == motATrouver.getValeur().charAt(0)) {
			if(verifierMot(m) && m.getValeur().length() == tailleMot) {
				traiterMot(m);
			}
		}
		joueur.setErreur(true);
		return false;
		
	}
	
	void traiterMot(Mot mot) {
		String s = mot.getValeur();
		String m = motATrouver.getValeur();
		String lettres[] = s.split("");
		for(int i = 0; i < s.length(); i++) {
			
			if(m.indexOf(lettres[i]) == i) {
				lettresActuelles[i] = lettres[i];
				lettres[i] = "";
			}
			
			else if(m.contains(lettres[i])) {
				if(!(lettresActuelles[i] != "+" || lettresActuelles[i] != "*")) {
					continue;
				}
				lettresActuelles[i] = "+";
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
		String s = Mot.formatMot(mot.getValeur());
		while(input.hasNextLine()) {
			String line = Mot.formatMot(input.nextLine());
			if(line.equals(s) && !motsDejaUtilises.contains(s)){
				motsDejaUtilises.add(s); 
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
