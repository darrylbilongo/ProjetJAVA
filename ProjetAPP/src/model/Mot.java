package model;
import java.text.Normalizer;

public class Mot {
	
	/**
	 *  Valeur du mot
	 */
	private String valeur;
	

	/**
	 * Constructeur prenant en parametre la valeur de la cha�ne de caract�res
	 */
	public Mot(String valeur) {
		this.valeur = formatMot(valeur);
	}
	
	/**
	 * Cette methode permet d'ignorer les accents les accents 
	 * et le caract�res sp�ciaux du mot mis en param�tre et le mette en majuscule...
	 * @param valeur le mot 
	 * @return Le String transform�
	 */
	public static String formatMot(String valeur) {
		String  mot = Normalizer.normalize(valeur, Normalizer.Form.NFD);
		return mot.replaceAll("[^\\p{ASCII}]", "").toUpperCase();
	}
	
	
	/**
	 * Getter de valeur
	 * @return la valeur en String du mot
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * Setter de valeur
	 * @param valeur la nouvelle valeur à attribuer au mot
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
}
