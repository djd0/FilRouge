package controller.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import controller.MainApp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import utilitaires.LocalDateAdapter;

public class Prospect extends Personnes {
	
		
	

		private ObjectProperty<LocalDate> date ;
		protected IntegerProperty nbCommande;
		
		
		

		
		
		//Constructeur
		public Prospect(String nom, String prenom, String rue, String ville, String pays, int codePostal, LocalDate date) 
		{
			super(nom, prenom, rue, ville, pays, codePostal);
			
			
			this.date = new SimpleObjectProperty<LocalDate>(date);
			this.nbCommande = new SimpleIntegerProperty(0);
			
			MainApp.donneesProspect.add(this);
		}
		

		public Prospect() 
		{
			this(null, null, null, null, null, 0, null);
		}

		


		
		// Get / Set
		// ajout de l'adapter pour la date
		@XmlJavaTypeAdapter(LocalDateAdapter.class)
		public LocalDate getDate() {
			return date.get();
		}


		public void setDate(LocalDate date) {
			this.date.set(date);
		}
		
		public ObjectProperty<LocalDate> dateProperty() {
			return date;
		}

		public int getNbCommande() {
			return nbCommande.get();
		}


		public void setNbCommande(int nbCommande) {
			this.nbCommande.set(nbCommande);
		}
		
		public IntegerProperty nbCommandeProperty() {
			return nbCommande;
		}

		


	}
