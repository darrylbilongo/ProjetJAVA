import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Essai {

	private Mot motATrouver;
	private Mot etatActuel;
	private Joueur joueurActuel;
	private int tailleMot;
	private int cpt;
	
	
	public Essai() {
		int cpt = 0;
		tailleMot = Partie.getTaillemot();
		Joueur joueur [] = Partie.getParticipants();
		classerMot(tailleMot);
		int numMot = (int)(Math.random() * (cpt - 1) + 1);
		choixMots(numMot);
	}
	
	public Essai(int i) {
		Joueur joueurs [] = Partie.getParticipants();
	}
	
	public void initEtatActuel() {
		
	}
	
	public Mot motDansDict(int nbDeLettres) {
		return new Mot("el");
	}
	
	public void classerMot(int x){
		try {
			Scanner input = new Scanner(new File("liste_francais.txt"));
			File ffx = new File("mots" + x +"lettres.txt");
			
			try {
				ffx.createNewFile();
				FileWriter motsXlettres = new FileWriter(ffx);
				
				while(input.hasNextLine()) {
					String line = input.nextLine();
					String motDuJeu = "";
					
					if(line.length() == x && !(line.contains("-") || line.contains("!"))) {
						
						motDuJeu += line + "\r\n";
						cpt++;
						//System.out.println(line);
					}
					
					motsXlettres.write(motDuJeu);
				}
				input.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void choixMots(int num) {
		try {
			Scanner input = new Scanner(new File("mots" + tailleMot + "lettres.txt"));
			while(input.hasNextLine()) {
				String line = input.nextLine();
				int n = 0;
				
				if(input.hasNextLine()) {
					n++;
					if(input.nextInt() == num) {
						System.out.println("Bonjour");
						motATrouver.setValeur(line);
					}
				}
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Essai e = new Essai();
		//System.out.println(e.motATrouver.getValeur());
	}
	
}
