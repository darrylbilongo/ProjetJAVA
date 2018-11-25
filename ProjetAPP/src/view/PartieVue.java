package view;

import java.util.Observer;

import controller.PartieController;
import model.Partie;

public abstract class PartieVue implements Observer{
	
	protected Partie model;
	protected PartieController controller;
	
	PartieVue(Partie model, PartieController controller){
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
	
	public abstract void affiche(String string) ;
}
