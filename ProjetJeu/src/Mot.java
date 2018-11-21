
public class Mot {
	String valeur;
	
	public Mot(String valeur) {
		this.valeur = valeur;
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
