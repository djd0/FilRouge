package controller.model;

public abstract class Personnes {

	
	protected String nom;
	protected String prenom;
	protected String rue;
	protected String ville;
	protected String pays;
	
	protected int codePostal;

	//Constructeur
	public Personnes(String nom, String prenom, String rue, String ville, String pays, int codePostal) 
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.ville = ville;
		this.pays = pays;
		this.codePostal = codePostal;
	}
	
	
	// GET / SET
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	
}
