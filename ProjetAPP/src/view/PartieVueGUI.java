package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PartieController;
import model.Partie;

public class PartieVueGUI extends PartieVue implements ActionListener{

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PartieVueGUI(Partie model, PartieController controller) {
		super(model, controller);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
