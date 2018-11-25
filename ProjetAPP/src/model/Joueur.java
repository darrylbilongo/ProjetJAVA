package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * 
 * @author Darryl Bilongo 2TL2
 *
 */
public class Joueur {	
	/**
	 *  Le nom du joueur
	 */
	private String nom;
	
	/**
	 * Le prenom du joueur
	 */
	private String prenom;
	
	/**
	 * Le pseudo du joueur
	 */
	private String pseudo;
	
	/**
	 * Le sexe du joueur
	 */
	private String sexe; // "M" ou "F"
	
	/**
	 * Si le joueur a la main
	 */
	private boolean main;
	
	/**
	 * points du joueur pour la partie en cours
	 */
	private int points;
	
	/**
	 * 
	 */
	private boolean erreur;
	


	/**
	 * Construit un joueur avec un nom, prenom, pseudo et sexe.
	 * @param nom le nom du joeur
	 * @param prenom le prenom du joueur
	 * @param pseudo le pseudo du joueur
	 * @param sexe le sexe du joueur
	 */
	public Joueur(String nom, String prenom, String pseudo, String sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.sexe = sexe;
		this.main = false;
		this.points = 0;
		this.erreur = false;
	}
	
	/**
	 * Constructeur principal de la classe qui defini le pseudo
	 * du joeur au debut de la partie
	 * @param pseudo
	 */
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public Joueur(){
		/*System.out.println("Vueillez ecrire votre pseudo: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			pseudo = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public boolean isErreur() {
		return erreur;
	}

	public void setErreur(boolean erreur) {
		this.erreur = erreur;
	}
	
	/**
	 * 
	 * @return le nom du joueur
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * Cette methode permet de definir le nom du joueur
	 * @param nom le nouveau nom à attribuer au joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	/**
	 * 
	 * @return le nom du joeur
	 */
	public String getPrenom() {
		return prenom;
	}

	
	/**
	 * Cette methode permet de definir le prenom du joueur
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @return le pseudo du joueur
	 */
	public String getPseudo() {
		return pseudo;
	}


	/**
	 * Cette methode prends en parametre le pseudo a attribuer au joueur
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	/**
	 * 
	 * @return le sexe du joueur
	 */
	public String getSexe() {
		return sexe;
	}


	/**
	 * 
	 * @param sexe
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	/**
	 * Cette methode verifie si le joueur a la main
	 * @return true si le joueur a la main
	 */
	public boolean isMain() {
		return main;
	}


	/**
	 * Cette methode permet de donner ou enlever la main à un joueur
	 * @param main
	 */
	public void setMain(boolean main) {
		this.main = main;
	}


	/**
	 * Cette methode 
	 * @return les points du joeur
	 */
	public int getPoints() {
		return points;
	}


	/**
	 * Cette methode permet d'attribuer un nombre de points au joueur 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	
	/**
	 * Retourne une representation textuelle du joueur contenant
	 * son nom, prenom, pseudo
	 */
	@Override
	public String toString() {
		String tmp = "";
		tmp = "Nom: " + nom + "\nPrenom: " + prenom + "\nPseudo: " + pseudo + (points == 0? "." : "\nPoints: " + points + ".");
		return tmp;
	}

	/**
	 * Passe la main au deuxième joeur de la partie
	 * @param j l'autre joueur de la partie
	 */
	public void passerMain(Joueur j) {
		this.main = false;
		j.main = true;
	}
	
	/**
	 * Cette methode demande au joueur ayant la main
	 * d'encoder une proposition pour le mot à deviner
	 * @return Le mot encode par le joueur sur la console
	 * @throws IOException 
	 */
	public Mot proposerMot() throws IOException {
		Mot proposition = new Mot();
		return proposition;
	}
	
	/**
	 * Cette methode ajoute 50 points au joueur pour chaque bonne reponse
	 */
	public void pointsPlus() {
		this.points += 50;
	}
}
