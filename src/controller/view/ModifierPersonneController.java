package controller.view;

import controller.model.Client;
import controller.model.Representant;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifierPersonneController {

	
	@FXML
	private Button ok;
	@FXML
	private Button annuler;
	@FXML
	private ComboBox<Representant> representant;
	@FXML
	private TextField numeroClientField;
	@FXML
	private TextField nbCommandesField;
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
    
    private boolean okClicked = false;
    
    
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

        numeroClientField.setText(Integer.toString(client.getNumeroClient()));
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

    // Si le user clic sur ok alors return true
	public boolean isOkClicked() 
	{
        return okClicked;
    }

	
	// appeler quand le user clic sur ok
    @FXML
    private void handleOk()
    {
        if (isInputValid()) 
        {
        	client.setNom(nomField.getText());
        	client.setPrenom(prenomField.getText());
        	client.setRue(rueField.getText());
        	client.setCodePostal(Integer.parseInt(codePostalField.getText()));
        	client.setVille(villeField.getText());
        	client.setPays(paysField.getText());
        	client.setNumeroClient(Integer.parseInt(numeroClientField.getText()));
        	client.setTelephone(telephoneField.getText());
        	client.setEnseigne(societeField.getText());
        	client.setSiret(siretField.getText());
        	client.setEmail(mailField.getText());
        	client.setNbCommande(Integer.parseInt(nbCommandesField.getText()));
        	
        	

            okClicked = true;
            fenetreStage.close();
        }
    }

    // appeler quand le user clic sur annuler
    @FXML
    private void handleAnnuler() 
    {
        fenetreStage.close();
    }
    
    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() 
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
        
        if (numeroClientField.getText() == null || numeroClientField.getText().length() == 0) 
        {
            errorMessage += "numero client invalide!\n";
        }      
        else 
        {
            // try to parse the postal code into an int.
            try 
            {
                Integer.parseInt(numeroClientField.getText());
            } 
            catch (NumberFormatException e) 
            {
                errorMessage += "numero client invalide!\n";
            }
        }
        
        if (nbCommandesField.getText() == null || nbCommandesField.getText().length() == 0) 
        {
            errorMessage += "nombre de commandes invalide!\n";
        }      
        else 
        {
            // try to parse the postal code into an int.
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


    
    
}
