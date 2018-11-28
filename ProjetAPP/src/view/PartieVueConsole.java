package view;

import java.util.Observable;
import java.util.Scanner;

import controller.PartieController;
import model.Essai;
import model.Partie;

public class PartieVueConsole extends PartieVue{
	
	PartieVue vue;
	Partie model;
	
	private String pseudoJoueur;
	
	public PartieVueConsole(Partie model, PartieController controller) {
		super(model, controller);
		initConsole();
		affiche("le nombre de lettres: " + Partie.getTaillemot());
		model.etapeDeux();
	}
	
	public void initConsole() {
		System.out.println("Bonjour, \nBienvenu(e) ра Motus:");
		
		System.out.println("Veuillez Entrez un pseudo s'il vous plait: ");
		pseudoJoueur = new Scanner(System.in).next();
		controller.setPseudoJoueur(pseudoJoueur);
	}
	
	public void lancerEtapeUn() {
		affiche("le nombre de lettres: " + Partie.getTaillemot());
		affiche("Lancement de l'etape 1\n");
	}
	
	public void lancerEtapeDeux() {
		affiche("Lancement de l'etape 2\n");
		model.etapeDeux();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//System.out.println(model);
	}

	@Override
	public void affiche(String s) {
		System.out.println(s);	
	}
}
