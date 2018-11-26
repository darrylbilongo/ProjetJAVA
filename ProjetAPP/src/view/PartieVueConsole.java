package view;

import java.util.Observable;
import java.util.Scanner;

import controller.PartieController;
import model.Partie;

public class PartieVueConsole extends PartieVue{
	
	PartieVue vue;
	Partie model;
	
	private String pseudoJoueur;
	
	public PartieVueConsole(Partie model, PartieController controller) {
		super(model, controller);
		initConsole();
		// TODO Auto-generated constructor stub
	}
	
	public void initConsole() {
		System.out.println("Bonjour, \nBienvenu(e) à Motus:");
		System.out.println("Veuillez Entrez un pseudo s'il vous plait: ");
		pseudoJoueur = new Scanner(System.in).next();
	}
	
	public void lancerEtapeUn() {
		model.etapeUn();
		vue.affiche("Lancement de l'étape 1\n");
	}
	
	public void lancerEtapeDeux() {
		model.etapeDeux();
		vue.affiche("Lancement de l'étape 2\n");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(model);
	}

	@Override
	public void affiche(String s) {
		System.out.println(s);	
	}
}
