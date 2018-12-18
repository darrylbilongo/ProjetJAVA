package view;

import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.Timer;

import controller.PartieController;
import model.Mot;
import model.Partie;

public class PartieVueConsole extends PartieVue implements Observer, Runnable{
	
	PartieVue vue;
	Partie model;
	Timer timer;
	
	private String pseudoJoueur;
	private Scanner sc;
	Thread th ;
	
	public PartieVueConsole(Partie model, PartieController controller) throws ArithmeticException, IOException {
		super(model, controller);
		motus();
		if(model.getEtape() == 1) {
			lancerEtapeUn();
		}
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
		affiche("Bonjour, \nBienvenu(e) à Motus:");	
		affiche("Veuillez Entrez un pseudo s'il vous plait: ");
		pseudoJoueur = new Scanner(System.in).next();
		controller.setPseudoJoueur(pseudoJoueur);
	}
	
	public void initServeur(int n) {
		if(n == 2) {
			th = new Thread(this);
		}
	}
	
	public void lancerEtapeUn() throws ArithmeticException, IOException {
		affiche("\nLancement de l'etape 1...");
		for(int i = 0; i < 10; i++) {
			controller.etapeUn();
			boolean echec = false;
			affiche(controller.getModel().toString());
			while(controller.getElem()!= 6) {
				affiche("Votre proposition: ");
				affiche(controller.getMotATrouver().getValeur());
				affiche(controller.getEtatActuel());
				String motJoueur = new Scanner(System.in).next();
				controller.traitementPropo(motJoueur);
				if(controller.getModel().estTrouve(motJoueur)){
					affiche("Bravo! Vous avez donné la bonne réponse!\n");
					affiche("Le mot à trouver était bien : \n" + controller.getMotATrouver().getValeur());
					break;	
				}
				echec = true;
			}
			if(echec) {
				affiche("Dommage...\nVous avez épuisé votre nombre de tentatives permises...\n"
						+ "Le mot à trouver était bien : " + controller.getMotATrouver().getValeur());
			}
		}
		
	}
	
	public void lancerEtapeDeux() throws IOException {
		affiche("\nLancement de l'etape 2...");
		for(int i = 0; i < 10; i++) {
			controller.etapeUn();
			boolean echec = false; 
			while(controller.getElem()!= 6) {
				affiche(controller.getModel().toString());
				affiche("Votre proposition: ");
				affiche(controller.getMotATrouver().getValeur());
				affiche(controller.getEtatActuel());
				String motJoueur = new Scanner(System.in).next();
				controller.traitementPropo(motJoueur);
				if(controller.getModel().estTrouve(motJoueur)){
					affiche("Bravo! Vous avez donné la bonne réponse!\n");
					affiche("Le mot à trouver était bien : \n" + controller.getMotATrouver().getValeur());
					break;	
				}
				echec = true;
			}
			if(echec) {
				affiche("Dommage...\nVous avez épuisé votre nombre de tentatives permises...\n"
						+ "Le mot à trouver était bien : " + controller.getMotATrouver().getValeur());
			}
		}
		controller.supprimerFichiers();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Partie p = (Partie) o;
		affiche(p.toString());
	}

	@Override
	public void affiche(String s) {
		System.out.println(s);	
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			String msg = "";
			try {
				msg = controller.getModel().waitForPropo();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(msg);
		}
	}
	
	public void readInput() throws IOException{
		while(true){
			System.out.print("Joueur2>");
			String msg = sc.nextLine();
			if(controller.getParticipants()[0].isMain()){
				controller.getModel().sendPropo(msg);
				sc.close();
				controller.getModel().closeConnection();
				System.exit(0);
			}
			controller.getModel().sendPropo(msg);
			
		}
	}
}
