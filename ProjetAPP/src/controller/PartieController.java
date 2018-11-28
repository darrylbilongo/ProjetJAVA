package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Partie;
import view.PartieVue;

public class PartieController{
	Partie model;
	PartieVue vue;
	
	public PartieController(Partie model) {
		this.model = model;
	}
	
	public void initJoueur(int i) {
		try {
			model.init(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addView(PartieVue vue) {
		this.vue = vue;
	}
	
	public void setPseudoJoueur(String pseudo) {
		model.getParticipants()[0].setPseudo(pseudo);
	}
	

}
