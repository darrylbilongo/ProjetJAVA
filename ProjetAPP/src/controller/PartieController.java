package controller;

import java.io.IOException;

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

}

