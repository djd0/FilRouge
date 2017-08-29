package controller;

import java.io.IOException;
import java.time.LocalDate;

import controller.model.Client;
import controller.model.Prospect;
import controller.model.Representant;
import controller.view.ClientController;
import controller.view.MenuController;
import controller.view.ProspectController;
import controller.view.RepresentantController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	
	private Stage stagePrincipal;
	private BorderPane rootLayout;
	
	
	
	
	//Listes observable
	private ObservableList<Client> donneesClient = FXCollections.observableArrayList();
	private ObservableList<Representant> donneesRepresentant = FXCollections.observableArrayList();
	private ObservableList<Prospect> donneesProspect = FXCollections.observableArrayList();
	
	
	//Constructeur
	public MainApp()
	{
		 //5 Representant
		Representant r1 = new Representant("AISAR", "Lily", "9 rue girond", "wasquehal", "FRANCE", 59290, 0.2, 1300);
		donneesRepresentant.add(r1);
        donneesRepresentant.add(new Representant("BIFET", "Henry", "36 rue du marechal ferrand", "lille", "FRANCE", 59000, 0.2, 1300));
        donneesRepresentant.add(new Representant("COUS", "Paul", "20 rue paul corteville", "roubaix", "FRANCE", 59100, 0.2, 1300));
        donneesRepresentant.add(new Representant("DALISET", "Gerard", "40/5 rue du terminal", "lille", "FRANCE", 59000, 0.2, 1300));
        donneesRepresentant.add(new Representant("ERMOT", "Michelle", "13 rue jean jura", "croix", "FRANCE", 59170, 0.2, 1300));
		
		// ajout de 5 clients
		donneesClient.add(new Client("ARIS", "Mathieu", "36 rue du fel", "Lille", "FRANCE", 59000, "03.20.12.13.14", "mathieu.aris@gmail.com", "VILASTIS", "71203480000201", 10, 1));
		donneesClient.add(new Client("BEST", "Loic", "12 impasse du plomeut", "Wasquehal", "FRANCE", 59290, "03.20.26.27.28", "loic.best@gmail.com", "ENEDIS", "71203480000201", 20, 2));
		donneesClient.add(new Client("CARRY", "Bernard", "2 bd de l'egalite", "Roubaix", "FRANCE", 59100, "03.20.30.31.32", "b.carry@gmail.com", "LDLC", "7120348000020", 30, 3));
		donneesClient.add(new Client("DENDE", "Lucy", "22 rue pierre mol", "Lille", "FRANCE", 59000, "03.20.45.46.47", "l.dende@gmail.com", "COFIDIS", "71203480000201", 40, 4));
		donneesClient.add(new Client("ERMIS", "David", "10 rue de brette", "Croix", "FRANCE", 59170, "03.20.58.59.60", "d.ermiss@gmail.com", "IBM", "71203480000201", 50, 5));
		
        
        // 5 Prospect
        donneesProspect.add(new Prospect("AISAR", "Lily", "9 rue girond", "wasquehal", "FRANCE", 59290, LocalDate.of(2014, 6, 30)));
        donneesProspect.add(new Prospect("AISAR", "Lily", "9 rue girond", "wasquehal", "FRANCE", 59290, LocalDate.of(2014, 6, 30)));
        donneesProspect.add(new Prospect("AISAR", "Lily", "9 rue girond", "wasquehal", "FRANCE", 59290, LocalDate.of(2014, 6, 30)));
        donneesProspect.add(new Prospect("AISAR", "Lily", "9 rue girond", "wasquehal", "FRANCE", 59290, LocalDate.of(2014, 6, 30)));
        donneesProspect.add(new Prospect("AISAR", "Lily", "9 rue girond", "wasquehal", "FRANCE", 59290, LocalDate.of(2014, 6, 30)));

    
        
       
    }

	
	
	//retourner les donnees en tant que liste observable
	public ObservableList<Client> getDonneesClient() {
        return donneesClient;
    }
	
	public ObservableList<Representant> getDonneesRepresentant() {
        return donneesRepresentant;
    }

	public ObservableList<Prospect> getDonneesProspect() {
        return donneesProspect;
    }

	
	
	
	@Override
	public void start(Stage stagePrincipal) 
	{
		this.stagePrincipal = stagePrincipal;
		
		// TITRE
        this.stagePrincipal.setTitle("Centre de gestion TOUTBOIS");
        
        // Chargement fichiers fxml
        initRootLayout();

        afficherMenu();
        
        
	}
	
	// Chargement fichiers fxml
	
	public void initRootLayout() 
	{
        try 
        {
            // Creation d'un chargeur fxml
            FXMLLoader loader = new FXMLLoader();
            
            //acces a l'URL par le chargeur
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
           
            //Chargement
            rootLayout = (BorderPane) loader.load();

            // Creation d'une scene qui contient le root
            Scene scene = new Scene(rootLayout);
            
            // afectation de la scene au menuStage
            stagePrincipal.setScene(scene);

            // Afficher le menuStage
            stagePrincipal.show();
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
	
	
	public void afficherMenu()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(MainApp.class.getResource("view/Menu.fxml"));
			
			BorderPane menu = (BorderPane) loader.load();
			
			rootLayout.setCenter(menu);
			
			MenuController controller = loader.getController();
	        controller.setMainApp(this);

		}
		
		catch ( IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void afficherFormulaireClient() 
	{
	    try 
	    {
	    	FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(MainApp.class.getResource("view/FormulaireClient.fxml"));
			
			AnchorPane ficheClient = (AnchorPane) loader.load();
			
			rootLayout.setCenter(ficheClient);
			
			ClientController controller = loader.getController();
	        controller.setMainApp(this);
	        
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	}
	
	public void afficherFormulaireRepresentant()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(MainApp.class.getResource("view/FormulaireRepresentant.fxml"));
			
			AnchorPane ficheRepresentant = (AnchorPane) loader.load();
			
			rootLayout.setCenter(ficheRepresentant);
			
			RepresentantController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch ( IOException e)
		{
			 e.printStackTrace();
		}
	}
	
	
	public void afficherFormulaireProspect()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(MainApp.class.getResource("view/FormulaireProspect.fxml"));
			
			AnchorPane ficheRepresentant = (AnchorPane) loader.load();
			
			rootLayout.setCenter(ficheRepresentant);
			
			ProspectController controller = loader.getController();
			controller.setMainApp(this);
		}
		catch ( IOException e)
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
