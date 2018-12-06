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
		
		//Création des contrôleurs : Un pour chaque vue
		//Chaque contrôleur doit avoir une référence vers le modèle pour pouvoir le commander
		PartieController ctrlGUI = new PartieController(model);
		PartieController ctrlConsole = new PartieController(model);
		 
		//Création des vues.
		//Chaque vue doit connaître son contrôleur et avoir une référence vers le modèle pour pouvoir l'observer
		PartieVue gui = new PartieVueGUI(model, ctrlGUI);
		PartieVue console = new PartieVueConsole(model, ctrlConsole);
		 		
		//On donne la référence à la vue pour chaque contrôleur
		ctrlConsole.addView(console);
		ctrlGUI.addView(gui);
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
