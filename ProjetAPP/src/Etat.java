import java.awt.List;
import java.util.ArrayList;

public class Etat {
	
	private int tempsRestant;
	private String motEtat;
	private char[] lettresTrouvee;
	
	/**
	 *  Constructeur de la classe Etat
	 */
	public Etat(String motATrouver){
			char [] characteres = motATrouver.toCharArray();
			for(int i = 0; i < characteres.length; i++) {
				int rand = (int)(Math.random() * characteres.length);
				char tmp = characteres[i];
				characteres[i] = characteres[rand];
				characteres[rand] = tmp;
			}
			this.motEtat = new String(characteres);
	}
	
}
