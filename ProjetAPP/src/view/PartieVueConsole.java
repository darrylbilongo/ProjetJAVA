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
		lancerEtapeUn(model);
		lancerEtapeDeux(model); 
	}
	
	public void motus() {
		System.out.println("Bonjour, \nBienvenu(e) � Motus:");	
		System.out.println("Veuillez Entrez un pseudo s'il vous plait: ");
		pseudoJoueur = new Scanner(System.in).next();
		controller.setPseudoJoueur(pseudoJoueur);
	}
	
	public void lancerEtapeUn(Observable o) throws ArithmeticException, IOException {
		Partie p = (Partie) o;
		affiche("\nLancement de l'etape 1...\n");
		p.etapeUn();
	}
	
	public void lancerEtapeDeux(Observable o) throws IOException {
		Partie p = (Partie) o;
		affiche("\nLancement de l'etape 2...\n");
		p.etapeDeux();
		affiche(p.getParticipants()[0].toString());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Partie p = (Partie) o;
		System.out.println(p);
		System.out.println("Entrez votre r�ponse...");
		affiche(p.getMotATrouver().getValeur());
		System.out.println(p.getEtatActuel().getValeur());
		Mot propo = new Mot(new Scanner(System.in).next());
		controller.setPropoJouer(propo);
	}

	@Override
	public void affiche(String s) {
		System.out.println(s);	
	}
}
