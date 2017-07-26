package controller.model;

import java.util.ArrayList;



public class Client extends Personnes {

	
	// Init du compteur client
	protected int numeroClient = 0;
	
	protected String telephone;
	protected String email;
	protected String enseigne;
	protected double siret;
	protected int nbCommandes;
	protected Representant numeroRepresentant;
	
	//Creation liste
	static ArrayList<Client> listeClient;

	public Client(String nom, String prenom, String rue, String ville, String pays, int numeroClient, int codePostal,
				  String telephone, String email, String enseigne, double siret, int nbCommandes,
				  Representant numeroRepresentant) 
	{
		super(nom, prenom, rue, ville, pays, codePostal);

		this.telephone = telephone;
		this.email = email;
		this.enseigne = enseigne;
		this.siret = siret;
		this.nbCommandes = nbCommandes;
		this.numeroRepresentant = numeroRepresentant;
		
		//Incrementation compteur clients
		numeroClient ++;
		this.numeroClient = numeroClient;
		
		// Instance liste Client
		listeClient = new ArrayList<Client>();
	}
	
	
	
	
	
	
}
