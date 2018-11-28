package view;

import java.io.IOException;
import java.util.Observable;
import java.util.Scanner;

import controller.PartieController;
import model.Mot;
import model.Partie;

public class PartieVueConsole extends PartieVue{
	
	PartieVue vue;
	Partie model;
	
	private String pseudoJoueur;
	
	public PartieVueConsole(Partie model, PartieController controller) throws ArithmeticException, IOException {
		super(model, controller);
		motus();
		lancerEtapeUn();
	}
	
	public void motus() {
		System.out.println("Bonjour, \nBienvenu(e) ра Motus:");	
		System.out.println("Veuillez Entrez un pseudo s'il vous plait: ");
		pseudoJoueur = new Scanner(System.in).next();
		controller.setPseudoJoueur(pseudoJoueur);
	}
	
	public void lancerEtapeUn() throws ArithmeticException, IOException {
		affiche("le nombre de lettres: " + Partie.getTaillemot());
		affiche("Lancement de l'etape 1\n");
		model.etapeUn();
	}
	
	public void lancerEtapeDeux() {
		affiche("Lancement de l'etape 2\n");
		model.etapeDeux();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(model.getEssaisRestant() == 0) {
			affiche(model.getParticipants()[0].toString());
		}
		else {
			Mot propo = new Mot(new Scanner(System.in).next());
			controller.setPropoJouer(propo);
			System.out.println();
		}
	}

	@Override
	public void affiche(String s) {
		System.out.println(s);	
	}
}
