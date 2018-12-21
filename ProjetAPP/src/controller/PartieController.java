package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Joueur;
import model.Mot;
import model.Partie;
import view.PartieVue;

public class PartieController{
	Partie model;
	PartieVue vue;
	
	public PartieController(Partie model) {
		this.model = model;
	}
		
	public void addView(PartieVue vue) {
		this.vue = vue;
	}

	public void setNbJoueurs(int n) {
		model.setNbJoueurs(n);
		try {
			model.init(n);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void etapeUn() {
		try {
			model.etapeUn();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void etapeDeux() {
		model.etapeDeux();
	}
	
	public void initPartie(int i) {
		try {
			model.init(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void traitementPropo(String str) {
		setPropoJouer(new Mot(str));
		try {
			model.propoJoueur();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean traitementReponse(String s) {
		try {
			return model.traitementReponse(new Mot(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Mot getMotATrouver() {
		return model.getMotATrouver();
	}
	
	public boolean testerMot(String str) {
		try {
			return model.verifierMot(new Mot(str));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void updatePartie(){
		if(getEssaiRest() == 0 && model.getEtape() == 1) {
			model.setEtape(2);
			model.setEssaisRestant(10);
			model.getJoueurActuel().setPoints(0);
		}
	}
	
	public void supprimerFichiers() {
		if(model.getEtape() == 2 && model.getEssaisRestant() == 0) {
			model.supprFichier();
		}
	}
		
	public boolean verifierMot(String s){
		if(model.getMotATrouver().getValeur().charAt(0) == s.charAt(0)) {
			if(s.length() == model.getTaillemot()) {
				return true;
			}
		}
		return false;
	}
	
	public Joueur getJoueurActuel() {
		return model.getJoueurActuel();
	}

	public Partie getModel() {
		return model;
	}

	public void setModel(Partie model) {
		this.model = model;
	}

	
	public void setPseudoJoueur1(String pseudo) {
		model.getParticipants()[0].setPseudo(pseudo);
	}
	
	public void setPseudoJoueur2(String pseudo) {
		model.getParticipants()[1].setPseudo(pseudo);
	}
	
	public void setPropoJouer(Mot p) {
		model.getJoueurActuel().setProposition(p);
	}

	public int getNbLettres() {
		return model.getTaillemot();
	}
	
	public int getEssaiRest() {
		return model.getEssaisRestant();
	}

	public int getEtape() {
		return model.getEtape();
	}
	
	public Joueur[] getParticipants() {
		return model.getParticipants();
	}
	
	public String getEtatActuel() {
		return model.getEtatActuel().getValeur();
	}
	
	public int getElem() {
		return model.getElem();
	}
}

