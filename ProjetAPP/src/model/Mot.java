package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

public class Mot {
	
	/**
	 *  Valeur du mot
	 */
	private String valeur; // valeur en String
	

	/**
	 * 
	 * @param valeur
	 */
	public Mot(String valeur) {
		this.valeur = formatMot(valeur);
	}
	
	public static String formatMot(String valeur) {
		String  mot = Normalizer.normalize(valeur, Normalizer.Form.NFD);
		return mot.replaceAll("[^\\p{ASCII}]", "").toUpperCase();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * 
	 * @param valeur
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	/**
	 * 
	 * @return
	 */
	public int longueur() {
		return valeur.length();
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	public boolean comparer(Mot m) {
		if(m.valeur == this.valeur) {
			return true;
		}		
		return false;
	}
	
}
