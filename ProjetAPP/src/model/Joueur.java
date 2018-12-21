package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;


public class Joueur {	
	/**
	 * Le pseudo du joueur
	 */
	private String pseudo;
	
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
	 * Le mot donne comme proposition par le joueur
	 */
	private Mot proposition;
	
	/**
	 * Construit un joueur avec un nom, prenom, pseudo et sexe.
	 * @param nom le nom du joeur
	 * @param prenom le prenom du joueur
	 * @param pseudo le pseudo du joueur
	 * @param sexe le sexe du joueur
	 */
	public Joueur() {
		this.main = false;
		this.points = 0;
		this.erreur = false;
		this.proposition = new Mot("");
	}
	
	public boolean isErreur() {
		return erreur;
	}

	public void setErreur(boolean erreur) {
		this.erreur = erreur;
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
	 * Cette methode retourne le nombre de points du joueurs
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
		tmp = "Pseudo: " + pseudo + " Points: " + points;
		return tmp;
	}

	/**
	 * Passe la main au deuxieme joueur de la partie
	 * @param j l'autre joueur de la partie
	 */
	public void passerMain(Joueur j) {
		this.main = false;
		j.main = true;
	}
	
	/**
	 * Cette methode ajoute 50 points au joueur pour chaque bonne reponse
	 */
	public void pointsPlus() {
		this.points += 50;
	}

	public Mot getProposition() {
		return proposition;
	}

	public void setProposition(Mot proposition) {
		this.proposition = proposition;
	}

	
	
}
