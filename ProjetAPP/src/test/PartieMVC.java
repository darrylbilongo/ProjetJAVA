package test;

import controller.PartieController;
import model.Partie;
import view.PartieVue;
import view.PartieVueConsole;
import view.PartieVueGUI;

public class PartieMVC {
	
	public PartieMVC() {
		// Création du modèle
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
			//Schedule a job for the event-dispatching thread:
			//creating and showing this application's GUI.
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new PartieMVC();
				}
			});
		}
		
}
