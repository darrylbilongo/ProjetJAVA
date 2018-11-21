import java.io.IOException;

/**
 * � partir de cette classe on se charge d'ouvrir une partie, dans laquelle le joueur
 * (s'il est unique) ou les joueurs (2 joueurs) pourront faire une nombre fixe d'�ssais.
 * Dans la premiere partie(etapeUn), on aura droit � 5 essais et dans la partie deux(etapeDeux)
 * on aura 10 essais.
 * @author Manuelle Ndamtang
 * NUMERO DU GROUPE: 17
 * @date 16/11/2018
 */
public class Partie {
	
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
	 * Cet entier se d�cr�mente � chaque �ssai. Il est devra �tre 
	 * initialis� comme nombre maximum d'�ssais au cours de la partie.
	 */
	private int essaisRestant;
	
	/**
	 * Cet entier est un constante qui sera utilis� durant toute la periode du jeu
	 * comme nombre al�atoire entre 6 et 10. Cette nombre correspond au nombre de lettre ds mots
	 * surlequel  les joueurs vont se baser pour jouer. 
	 * Ce nombre est lier � l'objet Partie, pas � une instance de Partie.
	 */
	private final static int TAILLEMOT = (int)(Math.random() * (11 - 6) + 6);
	
	/**
	 * Cet entier designe l'�tape dans laquelle le ou les joueur(s) se situent.
	 * Il peut prendre la valeur : 1 ou 2.
	 */
	private static int etape;
	
	/**
	 * Ce Constructeur prenant aucun param�tre se charge d'initialiser le jeu par d�faut 
	 * avec juste avec un joueur.
	 */
	public Partie() {
		nbJoueurs = 1;
		init();
	}
	
	/**
	 * Ce Constructeur se charge d'initialiser la partie en tenant du nombre de joueurs
	 * @param <i>nbJoueurs</i> entier charg� de donner le nombre de joueur de la partie.
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
	}
	
	/**
	 * Cette methode se charge de r�aliser la premiere m�thode.
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
				vainqueur = participants[0];
			
				essaisRestant--;
			}
		}
		else {
			throw new ArithmeticException();
		}

		essaisRestant = 10;
		
	}
	
	/**
	 * Cette m�thode ce charge de r�aliser la deuxieme �tape qui correspond
	 * � la finale o� le vainqueur joue seul pendant une periode de temps bien chronom�trer.
	 */
	public void etapeDeux(){
		
		for(int i = 0; i <= 9; i++) {
			Essai essai = new Essai();
			essaisRestant--;
		}
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
	
}
