package view;

import java.util.Observable;
import java.util.Scanner;

import controller.PartieController;
import model.Partie;

public class PartieVueConsole extends PartieVue{
	
	public PartieVueConsole(Partie model, PartieController controller) {
		super(model, controller);
		// TODO Auto-generated constructor stub
	}

	private Scanner sc;
	private String pseudoJoueur;
	private String nomJoueur;
	private String prenomJoueur;
	
	public void initConsole() {
		System.out.println("Bonjour, \nBienvenu(e) à Motus:");
		System.out.println("Veuillez Entrez un pseudo s'il vous plait: ");
		sc = new Scanner(System.in);
		pseudoJoueur = sc.next();
		System.out.println("Veuillez Entrez votre nom s'il vous plait: ");
		sc = new Scanner(System.in);
		nomJoueur = sc.next();
		System.out.println("Veuillez Entrez votre pseudo s'il vous plait: ");
		sc = new Scanner(System.in);
		prenomJoueur = sc.next();
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
