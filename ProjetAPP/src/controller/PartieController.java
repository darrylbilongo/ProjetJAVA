package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Partie;
import view.PartieVue;

public class PartieController implements ActionListener{
	Partie model;
	PartieVue vue;
	
	public PartieController(Partie model) {
		this.model = model;
	}
	
	public void initJoueur() {
		
	}
	
	public void addView(PartieVue vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
