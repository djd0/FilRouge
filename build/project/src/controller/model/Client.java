package controller.model;



import controller.MainApp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Client extends Personnes {

	
	// Init du compteur client
	protected IntegerProperty numeroClient;
	public static int numClient = 0;
	
	protected StringProperty telephone;
	protected StringProperty email;
	protected StringProperty enseigne;
	protected StringProperty siret;
	protected IntegerProperty nbCommande;
	protected IntegerProperty numeroRepresentant;
	protected Representant rep;

	
	//Constructeur
	public Client(String nom, String prenom, String rue, String ville,
			String pays, int codePostal, String telephone,
			String email, String enseigne, String siret, int nbCommande, int numeroRepresentant) 
	{
		super(nom, prenom, rue, ville, pays, codePostal);

		this.telephone = new SimpleStringProperty(telephone);
		this.email = new SimpleStringProperty(email);
		this.enseigne = new SimpleStringProperty(enseigne);
		this.siret = new SimpleStringProperty(siret);
		this.nbCommande = new SimpleIntegerProperty(nbCommande);
		this.numeroRepresentant =  new SimpleIntegerProperty(numeroRepresentant);
		
		//Incrementation compteur clients
		numClient ++;
		this.numeroClient = new SimpleIntegerProperty(numClient);
		
		MainApp.donneesClient.add(this);

	}
	
	public Client()
	{
		this(null, null, null, null, null, 0, null, null, null, null, 0, 0);
	}
	
	public Client(Prospect prospect) 
	{
		
		this.telephone = new SimpleStringProperty();
		this.email = new SimpleStringProperty();
		this.enseigne = new SimpleStringProperty();
		this.siret = new SimpleStringProperty();
		this.nbCommande = prospect.nbCommandeProperty();
		this.nom = prospect.nomProperty();
		this.prenom = prospect.prenomProperty();
		this.ville = prospect.villeProperty();
		this.pays = prospect.paysProperty();
		this.rue = prospect.rueProperty();
		this.codePostal = prospect.codePostalProperty();
		numClient++;
		this.numeroClient = new SimpleIntegerProperty(numClient);
		this.numeroRepresentant =  new SimpleIntegerProperty();
		
		
		
		
		
		
		
	}


	//GET / SET
	public int getNumeroClient() {
		return numeroClient.get();
	}


	public void setNumeroClient(int numeroClient) {
		this.numeroClient.set(numeroClient);
	}
	
	public IntegerProperty numeroClientProperty() {
		return numeroClient;
	}


	public String getTelephone() {
		return telephone.get();
	}


	public void setTelephone(String telephone) {
		this.telephone.set(telephone);
	}
	
	public StringProperty telephoneProperty() {
		return telephone;
	}


	public String getEmail() {
		return email.get();
	}


	public void setEmail(String email) {
		this.email.set(email);
	}
	
	public StringProperty emailProperty() {
		return email;
	}


	public String getEnseigne() {
		return enseigne.get();
	}


	public void setEnseigne(String enseigne) {
		this.enseigne.set(enseigne);
	}
	
	public StringProperty enseigneProperty() {
		return enseigne;
	}


	public String getSiret() {
		return siret.get();
	}


	public void setSiret(String siret) {
		this.siret.set(siret);
	}

	public StringProperty siretProperty() {
		return siret;
	}

	public int getNbCommande() {
		return nbCommande.get();
	}


	public void setNbCommande(int nbCommandes) {
		this.nbCommande.set(nbCommandes);
	}
	
	public IntegerProperty nbCommandeProperty() {
		return nbCommande;
	}

	public int getNumeroRepresentant() {
		return numeroRepresentant.get();
	}


	public void setNumeroRepresentant(int numeroRepresentant) {
		this.numeroRepresentant.set(numeroRepresentant);
	}
	
	public IntegerProperty numeroRepresentantProperty() {
		return numeroRepresentant;
	}


	
	
	
	
}
