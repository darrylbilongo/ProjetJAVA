package model;
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
	 * @return la valeur en String du mot
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * 
	 * @param valeur la nouvelle valeur à attribuer au mot
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
		if(m.valeur.equals(this.valeur)) {
			return true;
		}		
		return false;
	}
	
}
