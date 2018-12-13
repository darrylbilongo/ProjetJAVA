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
	
	public void initJoueur(int i) {
		model.init(i); 
	}
	
	public void addView(PartieVue vue) {
		this.vue = vue;
	}
	
	public void setPseudoJoueur(String pseudo) {
		model.getParticipants()[0].setPseudo(pseudo);
	}
	
	public void setPropoJouer(Mot p) {
		model.getParticipants()[0].setProposition(p);
	}
	
	public void setNbJoueurs(int n) {
		model.setNbJoueurs(n);
		model.init(n);
	}

	public int getNbLettres() {
		return model.getTaillemot();
	}
	
	public int getEssaiRest() {
		return model.getEssaisRestant();
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
		try {
			model.etapeDeux();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initPartie(int i) {
		model.init(i);
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
	
	public Joueur getJoueurActuel() {
		return model.getJoueurActuel();
	}

	public Partie getModel() {
		return model;
	}

	public void setModel(Partie model) {
		this.model = model;
	}

	public PartieVue getVue() {
		return vue;
	}

	public void setVue(PartieVue vue) {
		this.vue = vue;
	}
	
}

