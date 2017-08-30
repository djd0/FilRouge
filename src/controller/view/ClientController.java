package controller.view;

import controller.MainApp;
import controller.model.Client;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ClientController {

	
	//Attribues pour javafx
	@FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> nomColumn;
    @FXML
    private TableColumn<Client, String> prenomColumn;
    @FXML
    private TableColumn<Client, Integer> numeroClientColumn;
    @FXML
    private TableColumn<Client, Integer> numeroRepresentantColumn;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label societeLabel;
    @FXML
    private Label siretLabel;
    @FXML
    private Label rueLabel;
    @FXML
    private Label codePostalLabel;
    @FXML
    private Label villeLabel;
    @FXML
    private Label paysLabel;
    @FXML
    private Label nbCommandeLabel;
    @FXML
    private Label numeroClientLabel;
    @FXML
    private Label numeroRepresentantLabel;
    @FXML
    private Button supprimer;

    
    private Client client;

    private Stage clientStage;
   
    // reference a mainApp
    private MainApp mainApp;

    //Constructeur ( appeler avant la fonction initialiser )
    public ClientController() {
    }

    // Rempli les label avec les données ou les vide si client est null
    public void definirDonneesClient(Client client) 
    {
        if (client != null) {
            
            nomLabel.setText(client.getNom());
            prenomLabel.setText(client.getPrenom());
            emailLabel.setText(client.getEmail());
            telephoneLabel.setText(client.getTelephone());
            societeLabel.setText(client.getEnseigne());
            siretLabel.setText(client.getSiret());
            rueLabel.setText(client.getRue());
            codePostalLabel.setText(Integer.toString(client.getCodePostal()));
            villeLabel.setText(client.getVille());
            paysLabel.setText(client.getPays());
            nbCommandeLabel.setText(Integer.toString(client.getNbCommande()));  
            numeroClientLabel.setText(Integer.toString(client.getNumeroClient()));             
            numeroRepresentantLabel.setText(Integer.toString(client.getNumeroRepresentant()));
        } 
        else 
        {
            
        	nomLabel.setText("");
            prenomLabel.setText("");
            emailLabel.setText("");
            telephoneLabel.setText("");
            societeLabel.setText("");
            siretLabel.setText("");
            rueLabel.setText("");
            codePostalLabel.setText("");
            villeLabel.setText("");
            paysLabel.setText("");
            nbCommandeLabel.setText("");
            numeroClientLabel.setText("");
            numeroRepresentantLabel.setText("");
            
        }
    }

    
    // Initialiser la class controller. methode appellée automatiquement quand un fxml se charge
    @FXML
    private void initialize() 
    {
        // Initialise la table Client avec 4 colonnes
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        numeroClientColumn.setCellValueFactory(cellData -> cellData.getValue().numeroClientProperty().asObject());
        //associer le numero au lieu de le mettre dans
        numeroRepresentantColumn.setCellValueFactory(cellData -> cellData.getValue().numeroRepresentantProperty().asObject());
     
        // mettre tout a zero
        definirDonneesClient(null);

        // ajout d'un listener qui ecoute les changement et les montrent quand ils changent
        clientTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> definirDonneesClient(newValue));
    
        //Desactive le bouton supprimer si la selection est vide
        supprimer.disableProperty().bind(Bindings.isEmpty(clientTable.getSelectionModel().getSelectedItems()));
    
    }
    
    
    // clic sur supprimer
    @FXML
    private void handleSupprimer() 
    {
        int selectedIndex = clientTable.getSelectionModel().getSelectedIndex();
        
        clientTable.getItems().remove(selectedIndex);
      
    }

  
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // ajout a la table d'une liste de donnees observable
        clientTable.setItems(mainApp.getDonneesClient());
    }
    
    public void setClientStage(Stage clientStage) {
        this.clientStage = clientStage;
    }

	public Stage getClientStage() {
		return clientStage;
	}
	


	
}
