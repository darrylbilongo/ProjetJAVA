import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mot {
	
	/**
	 *  Valeur du mot
	 */
	private String valeur; // valeur en String
	
	public Mot () throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		valeur = in.readLine();
	}
	
	public Mot(String valeur) {
		this.valeur = valeur;
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
