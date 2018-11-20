
public class Mot {
	
	private String valeur; // valeur en String

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
