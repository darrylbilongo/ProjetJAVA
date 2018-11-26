package view;

import java.util.Observable;
import java.util.Scanner;

import controller.PartieController;
import model.Partie;

public class PartieVueConsole extends PartieVue{
	
	public PartieVueConsole(Partie model, PartieController controller) {
		super(model, controller);
		initConsole();
		// TODO Auto-generated constructor stub
	}
	private String pseudoJoueur;
	
	public void initConsole() {
		System.out.println("Bonjour, \nBienvenu(e) à Motus:");
		System.out.println("Veuillez Entrez un pseudo s'il vous plait: ");
		pseudoJoueur = new Scanner(System.in).next();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche(String s) {
		// TODO Auto-generated method stub
		
	}
}
