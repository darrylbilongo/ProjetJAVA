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
	
	public Mot () throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		valeur = formatMot(in.readLine());
	}
	
	public static String formatMot(String valeur) {
		String  mot = Normalizer.normalize(valeur, Normalizer.Form.NFD);
		return mot.replaceAll("[^\\p{ASCII}]", "").toUpperCase();
	}
	
	public Mot(String valeur) {
		this.valeur = formatMot(valeur);
	}
	
	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	public int longueur() {
		return valeur.length();
	}
	
	public boolean comparer(Mot m) {
		if(m.valeur == this.valeur) {
			return true;
		}		
		return false;
	}
	
}
