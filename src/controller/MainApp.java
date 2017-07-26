package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	
	private Stage stagePrincipal;
	private BorderPane menu;
	
	@Override
	public void start(Stage stagePrincipal) 
	{
		this.stagePrincipal = stagePrincipal;
		
		// TITRE
        this.stagePrincipal.setTitle("Centre de gestion TOUTBOIS");
        
        // Chargement fichiers fxml
        initMenu();

        

	}
	
	// Chargement fichiers fxml
	
	public void initMenu() 
	{
        try 
        {
            // Creation d'un chargeur fxml
            FXMLLoader loader = new FXMLLoader();
            
            //acces a l'URL par le chargeur
            loader.setLocation(MainApp.class.getResource("view/Menu.fxml"));
           
            //Chargement
            menu = (BorderPane) loader.load();

            // Creation d'une scene qui contient menu
            Scene scene = new Scene(menu);
            
            // afectation de la scene au stage principal
            stagePrincipal.setScene(scene);
            
            // Afficher le stage principal
            stagePrincipal.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }


	public Stage getStagePrincipal() {
		return stagePrincipal;
	}


	public static void main(String[] args) 
	{
		launch(args);
	}
}
