package view;

import java.util.Observable;
import java.util.Observer;

import controller.MotusController;
import controller.PartieController;
import model.Motus;
import model.Partie;

public abstract class MotusVue implements Observer{

	protected Motus model;
	protected MotusController controller;
	
	MotusVue(Partie model, PartieController controller){
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}

	public abstract void affiche(String s);

}
