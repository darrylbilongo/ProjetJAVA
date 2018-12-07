package view;

import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.PartieController;
import model.Mot;
import model.Partie;

public class PartieVueConsole extends PartieVue implements Observer{
	
	PartieVue vue;
	Partie model;
	
	private String pseudoJoueur;
	
	public PartieVueConsole(Partie model, PartieController controller) throws ArithmeticException, IOException {
		super(model, controller);
		motus();
		lancerEtapeUn();
		lancerEtapeDeux(); 
	}
	
	public void motus() {
		System.out.println("Introduisez le nombre de joueurs: ");
		String nb = new Scanner(System.in).next();
		while(!(nb.equals("1") || nb.equals("2") )) {
			System.out.println("Introduisez un nombre de joueurs correct entre 1 et 2:");
			nb = new Scanner(System.in).next();
		}
		controller.setNbJoueurs(Integer.parseInt(nb));
		affiche("Bonjour, \nBienvenu(e) � Motus:");	
		affiche("Veuillez Entrez un pseudo s'il vous plait: ");
		pseudoJoueur = new Scanner(System.in).next();
		controller.setPseudoJoueur(pseudoJoueur);
	}
	
	public void lancerEtapeUn() throws ArithmeticException, IOException {
		affiche("\nLancement de l'etape 1...\n");
		controller.etapeUn();
	}
	
	public void lancerEtapeDeux() throws IOException {
		affiche("\nLancement de l'etape 2...\n");
		controller.etapeDeux();
		affiche(controller.getParticipants()[0].toString());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Partie p = (Partie) o;
		System.out.println(p);
		affiche("Entrez votre r�ponse...");
		affiche(p.getMotATrouver().getValeur());
		affiche(p.getEtatActuel().getValeur());
		Mot propo = new Mot(new Scanner(System.in).next());
		controller.setPropoJouer(propo);
	}

	@Override
	public void affiche(String s) {
		System.out.println(s);	
	}
}
