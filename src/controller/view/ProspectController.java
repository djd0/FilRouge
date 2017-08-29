package controller.view;

import java.time.LocalDate;

import controller.MainApp;
import controller.model.Client;
import controller.model.Prospect;
import controller.model.Representant;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utilitaires.DateUtil;

public class ProspectController {
	@FXML
	private TableView <Prospect> ProspectTable;
	@FXML
	private TableColumn <Prospect, String> nomColumn;
	@FXML
	private TableColumn <Prospect, String> prenomColumn;
	@FXML
	private TableColumn <Prospect, LocalDate> dateColumn;
	@FXML
	private Button supprimer;
	@FXML
	private Button ajouter;
	@FXML
	private Button modifier;
	@FXML
	private Label dateLabel;
	@FXML
	private Label nbCommandeLabel;
	@FXML
	private Label nomLabel;
	@FXML
	private Label prenomLabel;
	@FXML
	private Label paysLabel;
	@FXML
	private Label villeLabel;
	@FXML
	private Label codePostalLabel;
	@FXML
	private Label rueLabel;
	
	
	private MainApp mainApp;

	
	public ProspectController()
	{
		
	}

	@FXML
	private void initialize()
	{
		nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
		dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		
		//Desactive le bouton supprimer si la selection est vide
		
		supprimer.disableProperty().bind(Bindings.isEmpty(ProspectTable.getSelectionModel().getSelectedItems()));
		
		 // ajout d'un listener qui ecoute les changement et les montrent quand ils changent
        ProspectTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> definirDonneesProspect(newValue));
	}
	
	 // clic sur supprimer
    @FXML
    private void handleSupprimer() 
    {
        int selectedIndex = ProspectTable.getSelectionModel().getSelectedIndex();

        ProspectTable.getItems().remove(selectedIndex);
       
    }
	
	
	public MainApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		ProspectTable.setItems(mainApp.getDonneesProspect());
	}
	
	
	// Rempli les label avec les données ou les vide si LE Prospect est null
    public void definirDonneesProspect(Prospect prospect) 
    {
        if (prospect != null) {
            
            nomLabel.setText(prospect.getNom());
            prenomLabel.setText(prospect.getPrenom());
            rueLabel.setText(prospect.getRue());
            codePostalLabel.setText(Integer.toString(prospect.getCodePostal()));
            villeLabel.setText(prospect.getVille());
            paysLabel.setText(prospect.getPays());
            nbCommandeLabel.setText(Integer.toString(prospect.getNbCommande()));  
            dateLabel.setText(DateUtil.format(prospect.getDate())); 
            
            
            
        } 
        else 
        {
            
        	nomLabel.setText("");
            prenomLabel.setText("");           
            rueLabel.setText("");
            codePostalLabel.setText("");
            villeLabel.setText("");
            paysLabel.setText("");
            nbCommandeLabel.setText("");
            dateLabel.setText("");
           
            
        }

}
}
	
	
