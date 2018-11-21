
public class Joueur {

	private String nom;
	private String prenom;
	private String pseudo;
	private String sexe;
	private boolean  aLamain;
	private int points;
	
	public Joueur() {
		
	}
	
	
	public Mot proposerMot() {
		return new Mot();
	}
	
	public void updateScore() {
		
	}
	
	public void passerLaMain() {
		
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public boolean isaLamain() {
		return aLamain;
	}


	public void setaLamain(boolean aLamain) {
		this.aLamain = aLamain;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
}
