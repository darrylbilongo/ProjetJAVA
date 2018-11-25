package view;

import java.util.Observable;
import java.util.Observer;

import controller.MotusController;
import model.Motus;

public abstract class MotusVue implements Observer{

	protected Motus model;
	protected MotusController controller;

	public abstract void affiche(String s);

}
