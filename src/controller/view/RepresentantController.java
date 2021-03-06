package controller.view;

import controller.MainApp;
import controller.model.Representant;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RepresentantController {


	
	@FXML
	private TableView<Representant> representantTable;
	@FXML
	private TableColumn <Representant, String> nomColumn;
	@FXML
	private TableColumn <Representant, String> prenomColumn;
	@FXML
	private TableColumn <Representant, Integer> numeroRepresentantColumn;
	@FXML
	private Button supprimer;
	@FXML
	private Button ajouter;
	@FXML
	private Button modifier;
	@FXML
	private Label numeroRepresentantLabel;
	@FXML
	private Label salaireLabel;
	@FXML
	private Label tauxCommLabel;
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

	
	public RepresentantController()
	{
		
	}
	
	@FXML
	private void initialize()
	{
		nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
		numeroRepresentantColumn.setCellValueFactory(cellData -> cellData.getValue().numeroRepresentantProperty().asObject());
		
		//Desactive le bouton supprimer si la selection est vide
		supprimer.disableProperty().bind(Bindings.isEmpty(representantTable.getSelectionModel().getSelectedItems()));
		
		// ajout d'un listener qui ecoute les changement et les montrent quand ils changent
        representantTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> definirDonneesRepresentant(newValue));
	}
	
	  // clic sur supprimer
    @FXML
    private void handleSupprimer() 
    {
        int selectedIndex = representantTable.getSelectionModel().getSelectedIndex();

        representantTable.getItems().remove(selectedIndex);
       
    }
	
    
	// Rempli les label avec les donn�es ou les vide si LE REPRESENTANT est null
    public void definirDonneesRepresentant(Representant representant) 
    {
        if (representant != null) {
            
            nomLabel.setText(representant.getNom());
            prenomLabel.setText(representant.getPrenom());
            rueLabel.setText(representant.getRue());
            codePostalLabel.setText(Integer.toString(representant.getCodePostal()));
            villeLabel.setText(representant.getVille());
            paysLabel.setText(representant.getPays());
            tauxCommLabel.setText(Double.toString(representant.getTauxCom()));
            salaireLabel.setText(Double.toString(representant.getSalaire()));
            numeroRepresentantLabel.setText(Integer.toString(representant.getNumeroRepresentant()));
            
        } 
        else 
        {
            
        	nomLabel.setText("");
            prenomLabel.setText("");           
            rueLabel.setText("");
            codePostalLabel.setText("");
            villeLabel.setText("");
            paysLabel.setText("");
            tauxCommLabel.setText("");
            salaireLabel.setText("");
            numeroRepresentantLabel.setText("");
           
     
            
        }

}
	
	public MainApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		representantTable.setItems(mainApp.getDonneesRepresentant());
	}
	
	
	
}
