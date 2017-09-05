package controller.view;



import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

	
	@FXML
	private Button Clients;
	@FXML
	private Button Repr�sentant;
	@FXML
	private Button Prospects;
	
	private MainApp mainApp;
	
    @SuppressWarnings("unused")
	private Stage clientStage;

    
    
	
	//Constructeur
	public MenuController() {
		
	}
	
    @FXML
    private void initialize() {
    }

    
    // clic sur client
    @FXML
    private void handleClients() 
    {       	   	
    	
    	mainApp.afficherFormulaireClient();
    	
    }
    
    //clic represesntant
    @FXML
    private void handleRepresentant()
    {
    	mainApp.afficherFormulaireRepresentant();
    }

    
    @FXML
    private void handleProspect()
    {
    	mainApp.afficherFormulaireProspect();    	
    }
 

    
	public void setClientStage(Stage clientStage) {
		this.clientStage = clientStage;
	}

	public void setMainApp(MainApp mainApp) 
	{
        this.mainApp = mainApp;
	}

    
    

}
