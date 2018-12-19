package view;

import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
	private Thread th ;
	private int nbjoueurs;
	private String client;
	
	/**
	 * Les inputs et les outputs du socket
	 */
	private BufferedReader in ;
	private PrintWriter out;
	
	/**
	 * Le socket
	 */
	private Socket socket;
	
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
		nbjoueurs = Integer.parseInt(nb);
		controller.setNbJoueurs(nbjoueurs);

		affiche("Bonjour, \nBienvenu(e) � Motus:");	
		affiche("Veuillez Entrez un pseudo s'il vous plait: ");
		pseudoJoueur = new Scanner(System.in).next();
		controller.setPseudoJoueur1(pseudoJoueur);
		
		if(nbjoueurs == 2) {
			try {
				initSocket(12345);
			} catch (IOException e) {
				e.printStackTrace();
			}
			th = new Thread(this);
			th.start();
			try {
				readInput();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Cette methode se change d'initialiser les sockets. 
	 * @param port: port du serveur
	 * @param addr: adresse ip du serveur au cas o� le clients desire se connecter.
	 * @throws IOException cas o� le port du serveur n'est pas ouvert ou le serveur correspondant � l'adresse ip n'existe pas.
	 */
	public void initSocket(int port) throws IOException {
		ServerSocket s = new ServerSocket(port);
		socket = s.accept();		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
	}
	
	/**
	 * Cette methode se charge de fermer les sockets.
	 * @throws IOException cas o� les iputs et output sont inexistantes
	 */
	public void closeConnection() throws IOException {
		in.close();
		out.close();
		socket.close();
	}
	
	/**
	 * Cette methode recoit les chaines de caracteres � travers le socket.
	 * @return le String re�u.
	 * @throws IOException s'il n'y rien envoy�.
	 */
	public String waitForPropo() throws IOException {
     if(nbjoueurs == 2) {
    	   String str = in.readLine();
           if(str.contains("Pseudo")) {
           	String s [] = str.split("");
           	controller.setPseudoJoueur2(s[1]);
           	client = s[1];
           	return "";
           }
           return client + "> " + str;
     }
     return null;
	}
	
	public void lancerEtapeUn() throws ArithmeticException, IOException {
		affiche("\nLancement de lm'etape 1...");
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
					affiche("Bravo! Vous avez donn� la bonne r�ponse!\n");
					affiche("Le mot � trouver �tait bien : \n" + controller.getMotATrouver().getValeur());
					echec = false;
					break;	
				}
				echec = true;
			}
			if(echec) {
				affiche("Dommage...\nVous avez �puis� votre nombre de tentatives permises...\n"
						+ "Le mot � trouver �tait bien : " + controller.getMotATrouver().getValeur());
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
					affiche("Bravo! Vous avez donn� la bonne r�ponse!\n");
					affiche("Le mot � trouver �tait bien : \n" + controller.getMotATrouver().getValeur());
					break;	
				}
				echec = true;
			}
			if(echec) {
				affiche("Dommage...\nVous avez �puis� votre nombre de tentatives permises...\n"
						+ "Le mot � trouver �tait bien : " + controller.getMotATrouver().getValeur());
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


	public void sendPropo(String mot) {
		out.println(mot);
		out.flush();
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			String msg = "";
			try {
				msg = waitForPropo();
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
			String propo = sc.nextLine();
			sendPropo(propo);
		}
	}
}
