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
	}
	
	  // clic sur supprimer
    @FXML
    private void handleSupprimer() 
    {
        int selectedIndex = representantTable.getSelectionModel().getSelectedIndex();

        representantTable.getItems().remove(selectedIndex);
       
    }
	
	
	public MainApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		representantTable.setItems(mainApp.getDonneesRepresentant());
	}
	
	
	
}
