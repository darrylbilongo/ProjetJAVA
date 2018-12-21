package test;

import java.io.IOException;

import controller.PartieController;
import model.Partie;
import view.PartieVue;
import view.PartieVueConsole;
import view.PartieVueGUI;

public class PartieMVC {
	
	public PartieMVC(String s) throws ArithmeticException, IOException {
		// Creation du modele
		Partie model = new Partie();
		if(s.equals("gui")) {
			PartieController ctrlGUI = new PartieController(model);
			PartieVue gui = new PartieVueGUI(model, ctrlGUI);
			ctrlGUI.addView(gui);
		}
		else if(s.equals("console")){
			PartieController ctrlConsole = new PartieController(model);
			PartieVue console = new PartieVueConsole(model, ctrlConsole);
			ctrlConsole.addView(console);
		}
		
	}
				
		public static void main(String args[]) {
			//Creation et affichage du GUI de l'application
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						new PartieMVC(args[0]);
					} catch (ArithmeticException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}	
		
}
