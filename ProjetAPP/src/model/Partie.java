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
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

/**
 * Dans cette partie de l'application, on se charge d'ouvrir une partie, dans laquelle le joueur
 * (s'il est unique) ou les joueurs (2 joueurs) pourront faire une nombre fixe d'essais.
 * Dans la premiere partie(etapeUn), on aura droit � 10 essais et dans la partie deux(etapeDeux)
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
	 * Le mot qui servira de guide pour d�viner les mots aux joueurs. 
	 */
	private Mot etatActuel;
	
	/**
	 * Ce tableau de string est constitu� des lettres sur laquelles l'application se base pour 
	 * mettre � jour l'attribut <i>etatActuel</i>.
	 */
	private String [] lettresActuelles;
	
	/**
	 * Cet attribut contient tous les mots deja joues.
	 */
	private static ArrayList<String> motsDejaJoues;
	
	/**
	 * Cette collection est charg�e de garder en memoire les mots d�j� utilis� durant la partie.
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
	
	private Joueur joueurActuel;
	
	/**
	 * 
	 */
	boolean serveur = true;
	
	
	private BufferedReader in ;
	private PrintWriter out;
	private Socket socket;
	
	/**
	 * Ce Constructeur prenant aucun parametre se charge d'initialiser le jeu par defaut 
	 * avec juste avec un joueur.
	 */
	/*public Partie() {
		nbJoueurs = 1;
		init(nbJoueurs);
	}*/
	
	/**
	 * Ce Constructeur se charge d'initialiser la partie en tenant compte du nombre de joueurs
	 * @param <i>nbJoueurs</i> entier charge de donner le nombre de joueur de la partie.
	 */
	/*public Partie(int nbJoueurs){
		this.nbJoueurs = nbJoueurs;
		if(nbJoueurs == 2) {
			init(2);
		}
		else if(nbJoueurs == 1) {
			init(1);
		}
	}*/
	
	
	
	/**
	 * Cette methode initialise la partie .
	 * @param init le nombre de joeurs dans la partie à initialiser
	 */
	public void init(int init){
		if(init == 1) {
			nbJoueurs = 1;
			etape = 1;
			Joueur joueur1 = new Joueur();
			joueur1.setMain(true);
			participants = new Joueur[] {joueur1};
			joueurActuel = participants[0];
			essaisRestant = 10;
			classerMot(TAILLEMOT);	
		}
		else if(init == 2) {
			nbJoueurs = 2;
			etape = 1;
			Joueur joueur1 = new Joueur();
			joueur1.setMain(true);
			Joueur joueur2 = new Joueur();
			joueur2.setMain(false);
			participants = new Joueur[] {joueur1, joueur2};
			joueurActuel = participants[0];
			essaisRestant = 10;
			classerMot(TAILLEMOT);	
		}
	}
	
	
	
	
	public void initSocket(int port, String addr) throws UnknownHostException, IOException {
		if(serveur == true) {
			ServerSocket s = new ServerSocket(port);
			socket = s.accept();
		}
		else {
			socket = new Socket(addr, port);
		}
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
	}
	
	public void closeConnection() throws IOException {
		in.close();
		out.close();
		socket.close();
	}
	
	/**
	 * Cette methode se charge de lancer la première etape de la partie.
	 * @throws IOException cette exception est provoqu� pas la m�thode <b>traitementReponse</b>
	 * @throws ArithmeticException cette exception tient compte les cas o� les joueurs
	 * inscrivent un caract�re � la place d'un chiffre.
	 */
	public void etapeUn() throws ArithmeticException, IOException {
		if(nbJoueurs == 2) {
			for(int i = 0; i <= 10; i++) {
				getEssai();
				initEtatActuel();
				essaisRestant--;
				int a = 5;
				
				while (!traitementReponse(joueurActuel.getProposition()) && a != 0){
				 	updateEtatActuel();
					setChanged();
					notifyObservers();
					a--;
				 }
				for(int j = 0; j <= participants.length; j++) {
					if(participants[j].getPoints() == Math.max(participants[0].getPoints(), participants[1].getPoints())) {
						vainqueur = participants[j];
					}
				}
			}
		}
		else if(nbJoueurs == 1) {
			for(int i = 0; i < 10; i++) {
				getEssai();
				initEtatActuel();
				essaisRestant--;
				int j = 5;
				while (!traitementReponse(joueurActuel.getProposition()) && j != 0){
				 	updateEtatActuel();
					setChanged();
					notifyObservers();
					j--;
				 }
			}
		}
		else {
			throw new ArithmeticException();
		}
		essaisRestant = 10;
	}

	/**
	 * Cette methode ce charge de realiser la deuxieme etape qui correspond
	 * à la finale où le vainqueur joue seul pour determiner l'issue de la partie.
	 * @throws IOException 
	 */
	public void etapeDeux() throws IOException{
		for(int i = 0; i < 10; i++) {
			getEssai();
			initEtatActuel();
			essaisRestant--;
			int j = 5;
			while (!traitementReponse(joueurActuel.getProposition()) && j != 0){
			 	updateEtatActuel();
				setChanged();
				notifyObservers();
				j--;
			 }
		}
	}
	
	public void getEssai() {
		motATrouver = new Mot("");
		lettresActuelles = new String[TAILLEMOT];
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
	}
	
	
	public boolean traitementReponse(Mot m) throws IOException {
		Joueur joueur = Partie.getParticipants()[0];
		if(m.getValeur().equals("")) {
			joueur.setErreur(true);
			return false;
		}
		else if(m.getValeur().equals(motATrouver.getValeur())) {
			joueur.pointsPlus();
			lettresActuelles = motATrouver.getValeur().split("");
			return true;
		}
		else if(m.getValeur().charAt(0) == motATrouver.getValeur().charAt(0)) {
			if(/*verifierMot(m) && */m.getValeur().length() == TAILLEMOT) {
				traiterMot(m);
			}
		}
		joueur.setErreur(true);
		return false;
		
	}
	
	/**
	 * 
	 * @param mot
	 */
	public void traiterMot(Mot mot) {
		String s = mot.getValeur(); 
		String m = motATrouver.getValeur();
		String lettres[] = s.split("");
		String lettresATrouver [] = m.split("");
		for(int i = 0; i < lettres.length ; i++) {
			
			if(m.contains(lettres[i])) {
				
				if(lettres[i].equals(lettresATrouver[i])){
					lettresActuelles[i] = lettres[i];
					lettres[i] = "";
				}
				else {
					if((lettresActuelles[i] != "+" && lettresActuelles[i] != "*")) {
						continue;
					}
					lettresActuelles[i] = "+";
					lettres[i] = "";
				}
			}
		}
	}
	
	/**
	 * 
	 */
	public  void updateEtatActuel() {
		String s = "";
		for(int i = 0; i < lettresActuelles.length; i++) {
			s += lettresActuelles[i];
		}
		etatActuel.setValeur(s);
	}

	/**
	 * 	
	 * @param mot
	 * @return
	 * @throws FileNotFoundException
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
	 * 
	 */
	public void initEtatActuel() {
		String lettreMot[] = motATrouver.getValeur().split("");
		String etatInit = "";
		for(int i = 0; i < TAILLEMOT; i++) {
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
	
	
	
	/**
	 * 
	 * @param x
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
	 * 
	 * @param num
	 * @return
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
	 * 
	 */
	@Override
	public String toString() {
		String s = "";
		s += "---------------------------------------------------------\n";
		s += "Nombre de Joueurs: " + this.nbJoueurs;
		s += "\tEssais restants: " + essaisRestant;
		s += "\nJoeur 1 : " + participants[0].toString();
		if(nbJoueurs == 2) {
			s += "Joueur 2: " + participants[1].toString(); 
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

	public Mot getEtatActuel() {
		return etatActuel;
	}

	public Mot getMotATrouver() {
		return motATrouver;
	}

	public void setMotATrouver(Mot motATrouver) {
		this.motATrouver = motATrouver;
	}
	
}