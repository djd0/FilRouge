package controller.model;

import java.util.Date;

import application.Adresse;

public class Prospect extends Personnes {
	
		
		private Date date ;
		protected int NbCommande;

		
		public Prospect(String nom, String prenom, String rue, String ville, String pays, int codePostal) {
			
			super(nom, prenom, rue, ville, pays, codePostal);
			
			date = "";
			NbCommande = 0;
		}

		
		
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getNbCommande() {
			return NbCommande;
		}

		public void setNbCommande(int nbCommande) {
			NbCommande = nbCommande;
		}

	
		
		
		
		
	}
