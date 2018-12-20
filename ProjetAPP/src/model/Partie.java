package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import java.util.Timer;


/**
 * Dans cette partie de l'application, on se charge d'ouvrir une partie, dans laquelle le joueur
 * (s'il est unique) ou les joueurs (2 joueurs) pourront faire une nombre fixe d'essais.
 * Dans la premiere partie(etapeUn), on aura droit à 10 essais et dans la partie deux(etapeDeux)
 * on aura 10 essais.
 * NUMERO DU GROUPE: 17
 * @author Manuelle Ndamtang & Bilongo Darryl
 * groupe: 2TL2
 */
public class Partie extends Observable{
	/**
	 * Le mot que les joueurs doivent deviner.
	 */
	private Mot motATrouver;
	
	/**
	 * Le mot qui servira de guide pour déviner les mots aux joueurs. 
	 */
	private Mot etatActuel;
	
	/**
	 * Ce tableau de string est constitué des lettres sur laquelles l'application se base pour 
	 * mettre à jour l'attribut <i>etatActuel</i>.
	 */
	private String [] lettresActuelles;
	
	/**
	 * Cet attribut contient tous les mots deja joues.
	 */
	private static ArrayList<String> motsDejaJoues;
	
	/**
	 * Cette collection est chargée de garder en memoire les mots déjà utilisés durant la partie.
	 */
	private ArrayList<String> motsDejaUtilises;
	
	/**
	 * Cet entier garde en memoire le nombre de lignes ayant le nombre defini pour jouer dans
	 * la partie.
	 */
	private static int cpt = 0;
	
	/**
	 * Le nombre de joueurs dans la partie.
	 */
	private int nbJoueurs;
	
	/**
	 * Le vainqueur de chaque partie.
	 */
	private static Joueur vainqueur;
	
	/**
	 * Un tableau contenant les joueurs de la partie
	 */
	private static Joueur participants[];
	
	private static String lettresGUI[];
	
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
	private int etape;
	
	
	private int elem;
	
	/**
	 * Le joueur actuel.
	 */
	private Joueur joueurActuel;

	private Timer timer;
	private int timeCount;
	

	
	/**
	 * Ce Constructeur prenant aucun parametre se charge d'initialiser le jeu par defaut 
	 * avec juste avec un joueur.
	 */
	public Partie() {
		nbJoueurs = 1;
		etape = 1;
		essaisRestant = 10;
		classerMot(TAILLEMOT);	
		participants = new Joueur[2];
		timeCount = 0;
		timer = new Timer();
	}
	
	/**
	 * Cette methode initialise la partie 
	 * @param init le nombre de joeurs dans la partie à initialiser
	 * @param init le nombre de joeurs dans la partie à initialiser
	 * @throws IOException issu de <b> initSockect() </b>
	 */
	public void init(int init) throws IOException{
		if(init == 1) {
			nbJoueurs = 1;
			Joueur joueur1 = new Joueur();
			joueur1.setMain(true);
			participants = new Joueur[] {joueur1};
			joueurActuel = participants[0];
		}
		else if(init == 2) {
			nbJoueurs = 2;
			Joueur joueur1 = new Joueur();
			joueur1.setMain(true);
			Joueur joueur2 = new Joueur();
			participants = new Joueur[] {joueur1, joueur2};
			joueurActuel = participants[0];
		}
	}	
	
	/**
	 * Cette methode se charge de lancer la premiere etape de la partie.
	 * @throws IOException cette exception est provoque pas la methode <b>traitementReponse</b>
	 * @throws ArithmeticException cette exception tient compte les cas ou les joueurs
	 * inscrivent un caractere a la place d'un chiffre.
	 */
	public void etapeUn() throws ArithmeticException, IOException {
		if(nbJoueurs == 2) {
			getEssai();
			initEtatActuel();
			essaisRestant--;
			elem = 0;
			for(int j = 0; j < participants.length; j++) {
				if(participants[j].getPoints() == Math.max(participants[0].getPoints(), participants[1].getPoints())) {
					vainqueur = participants[j];
				}
			}
		}
		else if(nbJoueurs == 1) {
			getEssai();
			initEtatActuel();
			essaisRestant--;
			elem = 0;
		}
		else {
			throw new ArithmeticException();
		}
	}

	/**
	 * Methode chargee de traiter la proposition Du joueur.
	 * @throws IOException liee a <b> traitementReponse</b>
	 */
	public void propoJoueur() throws IOException {
		if(!traitementReponse(joueurActuel.getProposition()) && elem != 6){
		 	updateEtatActuel();
			elem++;
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * Cette methode se charge de realiser la deuxieme etape qui correspond
	 * a la finale . Le vainqueur joue seul pour determiner l'issue de la partie.
	 */
	public void etapeDeux(){
		getEssai();
		initEtatActuel();
		essaisRestant--;
		elem = 0;
	}

	
	/**
	 * Cette méthode genere un essai pour un mot a deviner
	 */
	public void getEssai() {
		motATrouver = new Mot("");
		lettresActuelles = new String[TAILLEMOT];
		lettresGUI = new String[TAILLEMOT];
		motsDejaJoues = new ArrayList<String>();
		motsDejaUtilises = new ArrayList<String>();
		etatActuel = new Mot(""); 
		
		int numMot = (int)(Math.random() * cpt + 1);
		while((motATrouver = Partie.choixMot(numMot)) == null && 
				motsDejaJoues.contains(motATrouver.getValeur()))
		{
			numMot = (int)(Math.random() * cpt + 1);
			motATrouver = Partie.choixMot(numMot);
		}
		
		if(nbJoueurs == 1)
			participants[0].setErreur(false);
		else{
			participants[0].setErreur(false);
			transfererMain();
		}
	}
	
	
	/**
	 * Cette methode envoie la proposition d'un joueur vers le poste de l'autre joueur à travers le socket.
	 * @param propo La proposition du deuxieme joueur.
	 */
	/*public void sendPropo(String propo) {
		out.println(propo);
		out.flush();
	}
*/
	
	/**
	 * Cette methode determine si le mot proposé est équivalent au mot Ã  trouver
	 * @param m le mot proposé par le joueur
	 * @return true si il a trouve la bonne reponse et false sinon
	 * @throws IOException issu de la methode verifierMot()
	 */
	public boolean traitementReponse(Mot m) throws IOException {
		if(m.getValeur().equals("")) {
			joueurActuel.setErreur(true);
			transfererMain();
			return false;
		}
		else if(m.getValeur().equals(motATrouver.getValeur())) {
			joueurActuel.pointsPlus();
			bonneReponse();
			return true;
		}
		else if(m.getValeur().charAt(0) == motATrouver.getValeur().charAt(0)) {
			if(/*verifierMot(m) && */m.getValeur().length() == TAILLEMOT) {
				traiterMot(m);
			}
		}
		else {
			joueurActuel.setErreur(true);
			transfererMain();
		}
		return false;
		
	}
	
	/**
	 * Cette methode permet d'informer si le string introduit en parametre est vraiment le mot à trouver.
	 * @param m String à tester
	 * @return true si le joueur à trouver le mot
	 */
	public boolean estTrouve(String m){
		if(Mot.formatMot(m).equals(motATrouver.getValeur())) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Cette methode traite la proposition du joueur et met a jour le string <b>etatAtuel</b>, important 
	 * pour que le joueur voit l'evolution du mot en fonction de ces proposition.
	 * @param mot le mot du joueur 
	 */
	public void traiterMot(Mot mot) {
		String s = mot.getValeur(); 
		String m = motATrouver.getValeur();
		String lettres[] = s.split("");
		String lettresATrouver [] = m.split("");
		for(int i = 0; i < lettres.length ; i++) {
			if(m.contains(lettres[i])) {
				int occ1 = countOccurences(lettres[i], lettresActuelles);
				int occ2 = countOccurences(lettres[i], lettresATrouver);
				if(lettres[i].equals(lettresATrouver[i])){
					lettresActuelles[i] = lettres[i];
					lettresGUI[i]=lettres[i];
					lettres[i] = "";
				}
				else if(occ2 != occ1) {
					if(lettresActuelles[i].equals("*")) {
						lettresActuelles[i]= "+";
					}
					lettresGUI[i] = "+";
					lettres[i] = "";
				}
			}
			else {
				if((lettresActuelles[i].equals("+") || lettresActuelles[i].equals("*"))) {
					lettresActuelles[i] = "*";
					lettresGUI[i] = "*";
					lettres[i] = "";
				}
			}
		}
	}
	
	/**
	 * Cette méthode compte le nombre d'occurences d'une lettre dans un tableau de chaînes de caractères.
	 * @param s la lettre
	 * @param a le tableau de chaînes caractères.
	 * @return le nombre d'occurences du string s dans le tableau a.
	 **/
	public int countOccurences(String s, String[] a) {
		int count = 0;
		for(int i =0; i < a.length; i ++) {
			if(s.equals(a[i])) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 *  Cette méthode permet de mettre à jour l'etat actuel du mot à deviner dans la partie.
	 */
	public void updateEtatActuel() {
		String s = "";
		for(int i = 0; i < lettresActuelles.length; i++) {
			s += lettresActuelles[i];
		}
		etatActuel.setValeur(s);
	}



	/**
	 * Cette méthode supprime les fichiers initialement créer.
	 */
	public void supprFichier() {
		File fichier = new File("mot"+TAILLEMOT+"lettres.txt");
		fichier.delete();
	}
	
	/**
	 *  Cette méthode initialise l'attribut <b>etatActuel</b> qui met à jour l'évolution des différentes propositions du joueur
	 */
	public void initEtatActuel() {
		String lettreMot[] = motATrouver.getValeur().split("");
		String etatInit = "";
		for(int i = 0; i < TAILLEMOT; i++) {
			if(i == 0 || i == 2) {
				etatInit += lettreMot[i];
				lettresActuelles[i] = lettreMot[i];
				lettresGUI[i] = lettreMot[i];
			}
			else {
				etatInit += "*";
				lettresActuelles[i] = "*";
				lettresGUI[i] = lettreMot[i];
			}
		}
		etatActuel = new Mot(etatInit);
	}
	
	/**
	 * cette Methode
	 */
	public void transfererMain() {
		if(nbJoueurs == 2) {
			for(Joueur j : participants) {
				if(j.isErreur() == true) {
					j.setMain(false);
					j.setErreur(false);
				}
			}
		}
	}
	
	/**
	 * Méthode à executer lorsque la reponse trouvée est bonne
	 */
	public void bonneReponse() {
		this.etatActuel = new Mot(motATrouver.getValeur());
		lettresActuelles = motATrouver.getValeur().split("");
	}
	
	/**
	 * Cette methode verifie si le mot Ã  trouver existe dans le dictionnaire. Pour l'instant on ne l'utilise 
	 * pas dans le projet
	 * @param mot: mot à vérifier 
	 * @return true si le mot existe dans le dictionnaire et false dans le cas contraire.
	 * @throws FileNotFoundException cas oÃ¹ le fichier dans lequel on se base pour verifier l'existence du fichier est inexistante.t
	 */
	public boolean verifierMot(Mot mot) throws FileNotFoundException {
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
	
	/**
	 * Cette methode s'occupe de créer les fichiers txt sur lequels on va se baser pour fouiller les mots d'une taille fixe.
	 * @param x le nombre de lettres choisi pour le jeu.
	 */
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
				motsXlettres.close();
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
	
	/**
	 * Cette methode se charge de choisir un mot dans le fichier txt <b>mots<i>+</i>tailleMot<i>+</i>lettres.txt</b>.
	 * @param numero de la ligne choisi au harsard
	 * @return retourne le mot choisi.
	 */
	public static Mot choixMot(int num) {
		try {
			Scanner input = new Scanner(new File("mots" + TAILLEMOT + "lettres.txt"));
			int n = 0;
			while(input.hasNextLine()) {
				n++;
				String line = input.nextLine();
				if(n == num) {
					input.close();
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
	 * Cette méthode fourni une representation de toutes les informations importantes du modele 
	 * de la classe Partie
	 */
	@Override
	public String toString() {
		String s = "";
		s += "\n\n---------------------------------------------------------\n";
		s += "Nombre de Joueurs: " + this.nbJoueurs;
		s += "\tEssais restants: " + essaisRestant;
		s += " Etape en cours : " + etape;
		s += "\nJoueur 1 : " + participants[0].toString();
		if(nbJoueurs == 2) {
			s += " Joueur 2: " + participants[1].toString(); 
		}
		s += "\nNombre de lettres : " + TAILLEMOT;
		s += "\n---------------------------------------------------------\n";
		s += "\n";
		return s;
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
	
	public int getEtape() {
		return etape;
	}

	public void setEtape(int etape) {
		this.etape = etape;
	}


	public String[] getLettresActuelles() {
		return lettresActuelles;
	}


	public void setLettresActuelles(String[] lettresActuelles) {
		this.lettresActuelles = lettresActuelles;
	}

	public Joueur getJoueurActuel() {
		return joueurActuel;
	}

	public void setJoueurActuel(Joueur joueurActuel) {
		this.joueurActuel = joueurActuel;
	}


	public void setEtatActuel(Mot etatActuel) {
		this.etatActuel = etatActuel;
	}


	public static String[] getLettresGUI() {
		return lettresGUI;
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

	public Mot getEtatActuel() {
		return etatActuel;
	}

	public Mot getMotATrouver() {
		return motATrouver;
	}

	public void setMotATrouver(Mot motATrouver) {
		this.motATrouver = motATrouver;
	}

	public int getElem() {
		return elem;
	}

	public void setElem(int elem) {
		this.elem = elem;
	}
	
}