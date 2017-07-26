package controller.model;

import java.util.ArrayList;


public class Representant extends Personnes {

	
	// init du compteur de representants
	protected int numeroRepresentant = 0;
	
	protected double tauxCom;
	protected double salaire;
	
	//Creation liste Representant
	static ArrayList<Representant> listeRepresentant;
	
	//Constructeur
	public Representant(String nom, String prenom, String rue, String ville, String pays, int codePostal,
						int numeroRepresentant, double tauxCom, double salaire) 
	{
		super(nom, prenom, rue, ville, pays, codePostal);
		
		//Incrementation compteur clients
		numeroRepresentant ++;
		
		this.numeroRepresentant = numeroRepresentant;
		this.tauxCom = tauxCom;
		this.salaire = salaire;
		
		// Instance de la liste
		listeRepresentant = new ArrayList<Representant>();
	}

	
	// GET / SET
	public int getNumeroRepresentant() {
		return numeroRepresentant;
	}

	public void setNumeroRepresentant(int numeroRepresentant) {
		this.numeroRepresentant = numeroRepresentant;
	}

	public double getTauxCom() {
		return tauxCom;
	}

	public void setTauxCom(double tauxCom) {
		this.tauxCom = tauxCom;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	
	
}
