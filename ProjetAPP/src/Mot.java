import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Mot {
	
	private String valeur; // valeur en String
	
	public Mot (String valeur) throws IOException {
		this.valeur = valeur;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
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
