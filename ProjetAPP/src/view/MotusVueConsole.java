package view;

import java.util.Observable;
import java.util.Scanner;

import controller.MotusController;
import model.Motus;

public class MotusVueConsole extends MotusVue {

	private Scanner sc;
	private String pseudoJoueur;
	private String nomJoueur;
	private String prenomJoueur;
	
	public void initConsole() {
		System.out.println("Bonjour, \nBienvenu(e) à Motus:");
		System.out.println("Vueillez Entrez un pseudo s'il vous plaît: ");
		sc = new Scanner(System.in);
		pseudoJoueur = sc.next();
		System.out.println("Vueillez Entrez votre nom s'il vous plaît: ");
		sc = new Scanner(System.in);
		nomJoueur = sc.next();
		System.out.println("Vueillez Entrez votre pseudo s'il vous plaît: ");
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



	public String getPseudoJoueur() {
		return pseudoJoueur;
	}



	public String getNomJoueur() {
		return nomJoueur;
	}



	public String getPrenomJoueur() {
		return prenomJoueur;
	}
	
	
	
}
