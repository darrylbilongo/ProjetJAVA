package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Motus;
import view.MotusVue;

public class MotusController implements ActionListener{

	Motus model;
	MotusVue vue;
	
	public MotusController(Motus model) {
		this.model = model;
	}
	
	public void initJoueur() {
		
	}
	
	public void addView(MotusVue vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
