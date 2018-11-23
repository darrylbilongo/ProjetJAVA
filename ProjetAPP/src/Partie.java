
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


/**
 * e partir de cette classe on se charge d'ouvrir une partie, dans laquelle le joueur
 * (s'il est unique) ou les joueurs (2 joueurs) pourront faire une nombre fixe d'essais.
 * Dans la premiere partie(etapeUn), on aura droit e 5 essais et dans la partie deux(etapeDeux)
 * on aura 10 essais.
 * @author Manuelle Ndamtang
 * NUMERO DU GROUPE: 17
 * @date 16/11/2018
 */
public class Partie {
	private static int cpt = 0;
	
	/**
	 * Le nombre de joueurs dans la partie.
	 */
	private int nbJoueurs;
	
	/**
	 * Le gagnant du jeu dans chaque partie.
	 */
	private static Joueur vainqueur;
	
	/**
	 * Un tableau donnant les joueurs de la partie.
	 */
	private static Joueur participants[];
	
	/**
	 * Cet entier se decremente e chaque essai. Il est devra etre 
	 * initialise comme nombre maximum d'essais au cours de la partie.
	 */
	private int essaisRestant;
	
	/**
	 * Cet entier est un constante qui sera utilise durant toute la periode du jeu
	 * comme nombre aleatoire entre 6 et 10. Cette nombre correspond au nombre de lettre ds mots
	 * surlequel  les joueurs vont se baser pour jouer. 
	 * Ce nombre est lier e l'objet Partie, pas e une instance de Partie.
	 */
	private final static int TAILLEMOT = (int)(Math.random() * (11 - 6) + 6);
	
	/**
	 * Cet entier designe l'etape dans laquelle le ou les joueur(s) se situent.
	 * Il peut prendre la valeur : 1 ou 2.
	 */
	private static int etape;
	
	/**
	 * Ce Constructeur prenant aucun parametre se charge d'initialiser le jeu par defaut 
	 * avec juste avec un joueur.
	 */
	public Partie() {
		nbJoueurs = 1;
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ce Constructeur se charge d'initialiser la partie en tenant du nombre de joueurs
	 * @param <i>nbJoueurs</i> entier charge de donner le nombre de joueur de la partie.
	 * @throws IOException 
	 */
	public Partie(int nbJoueurs) throws IOException {
		this.nbJoueurs = nbJoueurs;
		if(nbJoueurs == 2) {
			etape = 1;
			Joueur joueur1 = new Joueur();
			Joueur joueur2 = new Joueur();
			participants = new Joueur[] {joueur1, joueur2};
			essaisRestant = 10;
			classerMot(TAILLEMOT);
		}
		else if(nbJoueurs == 1) {
			init();
		}
	}
	
	/***
	 * Cette methode se chargera d'initialiser la partie par defaut avec juste un seul joueur.
	 * @throws IOException 
	 */
	private void init() throws IOException {
		etape = 1;
		Joueur joueur1 = new Joueur();
		participants = new Joueur[] {joueur1};
		essaisRestant = 10;
		classerMot(TAILLEMOT);
		
	}
	
	/**
	 * Cette methode se charge de realiser la premiere methode.
	 */
	public void etapeUn() throws ArithmeticException {
		if(nbJoueurs == 2) {
			for(int i = 0; i <= 10; i++) {
				Essai essai = new Essai(2);
				for(int j = 0; j <= participants.length; j++) {
					if(participants[j].getPoints() == Math.max(participants[0].getPoints(), participants[1].getPoints()))
						vainqueur = participants[j];
				}
				essaisRestant--;
			}
		}
		else if(nbJoueurs == 1) {
			for(int i = 0; i <= 10; i++) {
				Essai essai = new Essai();
				String s = essai.getMotATrouver().getValeur();
				while(motsDejaJoues.contains(s)) {
					essai = new Essai();
				}
				essaisRestant--;
				motsDejaJoues.add(s);
			}
		}
		else {
			throw new ArithmeticException();
		}

		essaisRestant = 10;
		
	}
	
	/**
	 * Cette methode ce charge de realiser la deuxieme etape qui correspond
	 * e la finale oe le vainqueur joue seul pendant une periode de temps bien chronometrer.
	 */
	public void etapeDeux(){
		
		for(int i = 0; i <= 9; i++) {
			Essai essai = new Essai();
			essaisRestant--;
		}
	}
	

	public static void classerMot(int x){
		try {
			Scanner input = new Scanner(new File("liste_francais.txt"));
			File ffx = new File("mots" + x +"lettres.txt");
			
			try {
				ffx.createNewFile();
				FileWriter motsXlettres = new FileWriter(ffx);
				
				while(input.hasNextLine()) {
					String line = input.nextLine();
					String motDuJeu = "";
					
					if(line.length() == x && !(line.contains(" ") || line.contains("-") || line.contains("!"))) {
						
						motDuJeu += line + "\r\n";
						cpt++;
					}
					
					motsXlettres.write(motDuJeu);
				}
				input.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public static Mot choixMot(int num) {
		try {
			Scanner input = new Scanner(new File("mots" + TAILLEMOT + "lettres.txt"));
			int n = 0;
			while(input.hasNextLine()) {
				n++;
				String line = input.nextLine();
				
				if(n == num) {
					 return new Mot(line);
				}
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * Getters et Setters des differents attributs de Partie.
	 */
	
	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public Joueur getVainqueur() {
		return vainqueur;
	}

	public void setVainqueur(Joueur vainqueur) {
		this.vainqueur = vainqueur;
	}

	public int getEssaisRestant() {
		return essaisRestant;
	}

	public void setEssaisRestant(int essaisRestant) {
		this.essaisRestant = essaisRestant;
	}
	
	public static int getEtape() {
		return etape;
	}

	public static void setEtape(int etape) {
		Partie.etape = etape;
	}


	public static Joueur[] getParticipants() {
		return participants;
	}

	public static void setParticipants(Joueur[] participants) {
		Partie.participants = participants;
	}

	public static int getTaillemot() {
		return TAILLEMOT;
	}

	public static int getCpt() {
		return cpt;
	}

	public static void setCpt(int cpt) {
		Partie.cpt = cpt;
	}
	
	
}
