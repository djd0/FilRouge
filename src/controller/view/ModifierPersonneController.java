package controller.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.MainApp;
import controller.model.Client;
import controller.model.Prospect;
import controller.model.Representant;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilitaires.DateUtil;

public class ModifierPersonneController {

	
	@FXML
	private Button ok;
	@FXML
	private Button annuler;
	@FXML
	private ComboBox<Representant> representantComboBox;
	@FXML
	private Label numeroClientLabel;
	@FXML
	private Label numeroRepresentantLabel;
	@FXML
	private TextField nbCommandesField;
	@FXML
	private TextField salaireField;
	@FXML
	private TextField dateField;
	@FXML
	private TextField tauxCommField;
	@FXML
	private TextField nomField;
	@FXML
	private TextField prenomField;
	@FXML
	private TextField mailField;
	@FXML
	private TextField telephoneField;
	@FXML
	private TextField societeField;
	@FXML
	private TextField siretField;
	@FXML
	private TextField paysField;
	@FXML
	private TextField villeField;
	@FXML
	private TextField codePostalField;
	@FXML
	private TextField rueField;
	
	private Stage fenetreStage;
	
    private Client client;
    
    private Prospect prospect;
    
    private Representant representant;
    
    private boolean okClicked = false;
    
    private MainApp mainApp;
    
    
    @FXML
    private void initialize() 
    {
    	
    }


	public Stage getFenetreStage() 
	{
		return fenetreStage;
	}


	public void setFenetreStage(Stage fenetreStage) 
	{
		this.fenetreStage = fenetreStage;
	}
    

	// modifier un client
	public void setClient(Client client) 
	{
        
		
		this.client = client;

        numeroClientLabel.setText(Integer.toString(client.getNumeroClient()));
        nomField.setText(client.getNom());
        prenomField.setText(client.getPrenom());
        telephoneField.setText(client.getTelephone());
        societeField.setText(client.getEnseigne());
        siretField.setText(client.getSiret());
        rueField.setText(client.getRue());
        codePostalField.setText(Integer.toString(client.getCodePostal()));
        villeField.setText(client.getVille());
        paysField.setText(client.getPays());
        nbCommandesField.setText(Integer.toString(client.getNbCommande()));  
        mailField.setText(client.getEmail());  
      
    }
	
	// modifier un prospect
		public void setProspect(Prospect prospect) 
		{
	        
			
			this.prospect = prospect;

			nomField.setText(prospect.getNom());
            prenomField.setText(prospect.getPrenom());
            rueField.setText(prospect.getRue());
            codePostalField.setText(Integer.toString(prospect.getCodePostal()));
            villeField.setText(prospect.getVille());
            paysField.setText(prospect.getPays());
            nbCommandesField.setText(Integer.toString(prospect.getNbCommande()));  
            dateField.setText(DateUtil.format(prospect.getDate())); 
	      
	    }
		
		// modifier un client
		public void setRepresentant(Representant representant) 
		{
	        
			
			this.representant = representant;

			nomField.setText(representant.getNom());
            prenomField.setText(representant.getPrenom());
            rueField.setText(representant.getRue());
            codePostalField.setText(Integer.toString(representant.getCodePostal()));
            villeField.setText(representant.getVille());
            paysField.setText(representant.getPays());
            tauxCommField.setText(Double.toString(representant.getTauxCom()));
            salaireField.setText(Double.toString(representant.getSalaire()));
            numeroRepresentantLabel.setText(Integer.toString(representant.getNumeroRepresentant()));
	      
	    }



	public void setMainApp(MainApp mainApp) 
	{
		this.mainApp = mainApp;
		
		representantComboBox.getItems().addAll(mainApp.getDonneesRepresentant());
	}


	// Si le user clic sur ok alors return true
	public boolean isOkClicked() 
	{
        return okClicked;
    }

	
	// appeler quand le user clic sur ok
    @FXML
    private void handleOkClient()
    {
    	String s;
    	String t[];
    	
        if (isInputValidClient()) 
        {
        	client.setNom(nomField.getText());
        	client.setPrenom(prenomField.getText());
        	client.setRue(rueField.getText());
        	client.setCodePostal(Integer.parseInt(codePostalField.getText()));
        	client.setVille(villeField.getText());
        	client.setPays(paysField.getText());
        	client.setNumeroClient(Integer.parseInt(numeroClientLabel.getText()));
        	client.setTelephone(telephoneField.getText());
        	client.setEnseigne(societeField.getText());
        	client.setSiret(siretField.getText());
        	client.setEmail(mailField.getText());
        	client.setNbCommande(Integer.parseInt(nbCommandesField.getText()));
        	
        	s = representantComboBox.getValue().toString();
            System.out.println("s = "+s);
            t=s.split(" ");
            System.out.println("t = "+t[0]);
            client.setNumeroRepresentant(Integer.parseInt(t[0]));
        	

            okClicked = true;
            fenetreStage.close();
        }
    }
    
    @FXML
    private void handleOkProspect() throws NumberFormatException, ParseException
    {
    	
        if (isInputValidProspect()) 
        {
        	prospect.setNom(nomField.getText());
        	prospect.setPrenom(prenomField.getText());
        	prospect.setRue(rueField.getText());
        	prospect.setCodePostal(Integer.parseInt(codePostalField.getText()));
        	prospect.setVille(villeField.getText());
        	prospect.setPays(paysField.getText());
        	prospect.setDate(DateUtil.parse(dateField.getText())); 
        	prospect.setNbCommande(Integer.parseInt(nbCommandesField.getText()));
        	
        	

            okClicked = true;
            fenetreStage.close();
        }
    }
    
    @FXML
    private void handleOkRepresentant()
    {
    	
        if (isInputValidRepresentant()) 
        {
        	representant.setNom(nomField.getText());
        	representant.setPrenom(prenomField.getText());
        	representant.setRue(rueField.getText());
        	representant.setCodePostal(Integer.parseInt(codePostalField.getText()));
        	representant.setVille(villeField.getText());
        	representant.setPays(paysField.getText());
        	representant.setTauxCom(Double.parseDouble(tauxCommField.getText()));
        	representant.setSalaire(Double.parseDouble(salaireField.getText()));
        	representant.setNumeroRepresentant(Integer.parseInt(numeroRepresentantLabel.getText()));
        	
        	

            okClicked = true;
            fenetreStage.close();
        }
    }

    // appeler quand le user clic sur annuler
    @FXML
    private void handleAnnulerClient() 
    {
        Client.numClient --;
    	fenetreStage.close();
    }
    
    @FXML
    private void handleAnnulerProspect() 
    {
    	fenetreStage.close();
    }
    
    @FXML
    private void handleAnnulerRepresentant() 
    {
        Representant.numeroRep --;
    	fenetreStage.close();
    }
    
    // Verifie que les entrees clavier sont correct
    private boolean isInputValidClient() 
    {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) 
        {
            errorMessage += "nom incorrect!\n";
        }
        
        if (prenomField.getText() == null || prenomField.getText().length() == 0) 
        {
            errorMessage += "prenom non valide!\n";
        }
        
        if (rueField.getText() == null || rueField.getText().length() == 0) 
        {
            errorMessage += "rue non valide!\n";
        }

        if (codePostalField.getText() == null || codePostalField.getText().length() == 0) 
        {
            errorMessage += "code postal invalide!\n";
        }      
        else 
        {
            // try to parse the postal code into an int.
            try 
            {
                Integer.parseInt(codePostalField.getText());
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "code postal invalide!\n";
            }
        }

        if (villeField.getText() == null || villeField.getText().length() == 0) 
        {
            errorMessage += "ville non valide!\n";
        }

        if (paysField.getText() == null || paysField.getText().length() == 0) 
        {
            errorMessage += "pays invalide!\n";
        } 
        
        if (telephoneField.getText() == null || telephoneField.getText().length() == 0) 
        {
            errorMessage += "telephone invalide!\n";
        } 
        
        if (societeField.getText() == null || societeField.getText().length() == 0) 
        {
            errorMessage += "societe invalide!\n";
        } 
        
        if (siretField.getText() == null || siretField.getText().length() == 0) 
        {
            errorMessage += "siret invalide!\n";
        } 
        
        if (mailField.getText() == null || mailField.getText().length() == 0) 
        {
            errorMessage += "mail invalide!\n";
        } 
        
        if (nbCommandesField.getText() == null || nbCommandesField.getText().length() == 0) 
        {
            errorMessage += "nombre de commandes invalide!\n";
        }      
        else 
        {
            try 
            {
                Integer.parseInt(nbCommandesField.getText());
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "nombre de commandes invalide!\n";
            }
        }

        if (errorMessage.length() == 0) 
        {
            return true;
        } 
        else 
        {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(fenetreStage);
            alert.setTitle("champs invalide");
            alert.setHeaderText("Veuillez corriger les champs invalides");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    private boolean isInputValidProspect() throws ParseException
    {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) 
        {
            errorMessage += "nom incorrect!\n";
        }
        
        if (prenomField.getText() == null || prenomField.getText().length() == 0) 
        {
            errorMessage += "prenom non valide!\n";
        }
        
        if (rueField.getText() == null || rueField.getText().length() == 0) 
        {
            errorMessage += "rue non valide!\n";
        }

        if (codePostalField.getText() == null || codePostalField.getText().length() == 0) 
        {
            errorMessage += "code postal invalide!\n";
        }      
        else 
        {
            // try to parse the postal code into an int.
            try 
            {
                Integer.parseInt(codePostalField.getText());
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "code postal invalide!\n";
            }
        }

        if (villeField.getText() == null || villeField.getText().length() == 0) 
        {
            errorMessage += "ville non valide!\n";
        }

        if (paysField.getText() == null || paysField.getText().length() == 0) 
        {
            errorMessage += "pays invalide!\n";
        } 
        
        if (nbCommandesField.getText() == null || nbCommandesField.getText().length() == 0) 
        {
            errorMessage += "nombre de commandes invalide!\n";
        }      
        else 
        {
            try 
            {
                Integer.parseInt(nbCommandesField.getText());
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "nombre de commandes invalide!\n";
            }
        }
        
        // gestion format date
        if ( dateField.getText() == null || dateField.getText().length() == 0 )
        {
    	   errorMessage += "date invalide! (format : yyyy-MM-dd ) \n";
        }
        else
        {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		sdf.setLenient(true);
    	  	Date d = new Date();
    	  	
        	try 
            { 	
        	  	d = sdf.parse(dateField.getText());
        		String t = sdf.format(d);
        		
        		if (t.compareTo(dateField.getText()) !=  0)
        		{
        			errorMessage += "date invalide! (format : yyyy-MM-dd ) \n";
        		}
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "date invalide! (format : yyyy-MM-dd ) \n";
            }
        }
        
        if (errorMessage.length() == 0) 
        {
            return true;
        } 
        else 
        {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(fenetreStage);
            alert.setTitle("champs invalide");
            alert.setHeaderText("Veuillez corriger les champs invalides");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
    private boolean isInputValidRepresentant() 
    {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) 
        {
            errorMessage += "nom incorrect!\n";
        }
        
        if (prenomField.getText() == null || prenomField.getText().length() == 0) 
        {
            errorMessage += "prenom non valide!\n";
        }
        
        if (rueField.getText() == null || rueField.getText().length() == 0) 
        {
            errorMessage += "rue non valide!\n";
        }

        if (codePostalField.getText() == null || codePostalField.getText().length() == 0) 
        {
            errorMessage += "code postal invalide!\n";
        }      
        else 
        {
            // try to parse the postal code into an int.
            try 
            {
                Integer.parseInt(codePostalField.getText());
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "code postal invalide!\n";
            }
        }

        if (villeField.getText() == null || villeField.getText().length() == 0) 
        {
            errorMessage += "ville non valide!\n";
        }

        if (paysField.getText() == null || paysField.getText().length() == 0) 
        {
            errorMessage += "pays invalide!\n";
        } 
        
        if (tauxCommField.getText() == null || tauxCommField.getText().length() == 0) 
        {
            errorMessage += "taux de commission invalide!\n";
        }      
        else 
        {
            try 
            {
                Double.parseDouble(tauxCommField.getText());
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "taux de commission invalide!\n";
            }
        }
        
        if (salaireField.getText() == null || salaireField.getText().length() == 0) 
        {
            errorMessage += "salaire invalide!\n";
        }      
        else 
        {
            try 
            {
            	Double.parseDouble(salaireField.getText());
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "salaire invalide!\n";
            }
        }
        

        if (errorMessage.length() == 0) 
        {
            return true;
        } 
        else 
        {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(fenetreStage);
            alert.setTitle("champs invalide");
            alert.setHeaderText("Veuillez corriger les champs invalides");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    
    
}
