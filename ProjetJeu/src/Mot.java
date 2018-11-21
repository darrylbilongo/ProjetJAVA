import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Mot {
	private String valeur;
	
	public Mot(String valeur) {
		this.valeur = valeur;
		System.out.println(valeur);
	}
	
	public Mot() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		//System.out.println("tu as tapé" + line);
	}
	
	public int longueur() {
		return valeur.length();
	}
	
	public Mot testMot(Mot test) {
		return new Mot("el");
	}
	
	public boolean Comparer(Object objet){
		
		if(objet == null) {
			return false;
		} 
		if(objet == this) {
			return true;
		}
		Mot mot = (Mot)objet;
		if(mot.valeur == this.valeur) {
			return true;
		}
		return false;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	
}
