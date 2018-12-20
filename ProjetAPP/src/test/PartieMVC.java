package test;

import java.io.IOException;

import controller.PartieController;
import model.Partie;
import view.PartieVue;
import view.PartieVueConsole;
import view.PartieVueGUI;

public class PartieMVC {
	
	public PartieMVC() throws ArithmeticException, IOException {
		// Creation du modele
		Partie model = new Partie();
		
		//Creation des controleurs : Un pour chaque vue
		//Chaque controleur doit avoir une reference vers le modele pour pouvoir le commander
		//PartieController ctrlGUI = new PartieController(model);
		PartieController ctrlConsole = new PartieController(model);
		 
		//Creation des vues.
		//Chaque vue doit connaitre son controleur et avoir une reference vers le modele pour pouvoir l'observer
		//PartieVue gui = new PartieVueGUI(model, ctrlGUI);
		PartieVue console = new PartieVueConsole(model, ctrlConsole);
		 		
		//On donne la reference à la vue pour chaque controleur
		ctrlConsole.addView(console);
		//ctrlGUI.addView(gui);
	}
				
		public static void main(String args[]) {
			//Creation et affichage du GUI de l'application
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						new PartieMVC();
					} catch (ArithmeticException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}	
		
}
