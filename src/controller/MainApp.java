package controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import controller.model.Client;
import controller.model.ClientListWrapper;
import controller.model.Prospect;
import controller.model.ProspectListWrapper;
import controller.model.Representant;
import controller.model.RepresentantListWrapper;
import controller.view.ClientController;
import controller.view.MenuController;
import controller.view.ModifierPersonneController;
import controller.view.ProspectController;
import controller.view.RepresentantController;
import controller.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
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
		donneesClient.add(new Client("ARIS", "Mathieu", "36 rue du fel", "Lille", "FRANCE", 59000, "03.20.12.13.14", "mathieu.aris@gmail.com", "VILASTIS", "71203480000201", 10, 8));
		donneesClient.add(new Client("BEST", "Loic", "12 impasse du plomeut", "Wasquehal", "FRANCE", 59290, "03.20.26.27.28", "loic.best@gmail.com", "ENEDIS", "71203480000201", 20, 2));
		donneesClient.add(new Client("CARRY", "Bernard", "2 bd de l'egalite", "Roubaix", "FRANCE", 59100, "03.20.30.31.32", "b.carry@gmail.com", "LDLC", "7120348000020", 30, 6));
		donneesClient.add(new Client("DENDE", "Lucy", "22 rue pierre mol", "Lille", "FRANCE", 59000, "03.20.45.46.47", "l.dende@gmail.com", "COFIDIS", "71203480000201", 40, 4));
		donneesClient.add(new Client("ERMIS", "David", "10 rue de brette", "Croix", "FRANCE", 59170, "03.20.58.59.60", "d.ermiss@gmail.com", "IBM", "71203480000201", 50, 12));
		
        
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
            
            // Donne la main au controlleur
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);


            // Afficher le menuStage
            stagePrincipal.show();
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        // Charge le dernier fichier ouvert 
        File file = getPersonFilePath();
        if (file != null)
        {
            loadPersonDataFromFile(file);
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
	
	// Ouvre une fenetre pour modifier un client
	// Si le user clic sur ok, les changement sont enregistre dans l'objet client et true est retourné
	public boolean afficherFenetreModifierClient(Client client)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(MainApp.class.getResource("view/ModifierClient.fxml"));
			
			AnchorPane fenetreModifierClient = (AnchorPane) loader.load();
			
			// creation du stage de la fenetre
	        Stage fenetreStage = new Stage();
	        
	        fenetreStage.setTitle("Modifier client");
	        fenetreStage.initModality(Modality.WINDOW_MODAL);
	        fenetreStage.initOwner(stagePrincipal);
	        
	        Scene scene = new Scene(fenetreModifierClient);
	        fenetreStage.setScene(scene);

			
			ModifierPersonneController controller = loader.getController();
			controller.setFenetreStage(fenetreStage);
			controller.setClient(client);
			controller.setMainApp(this);
			// Montre la fenetre et attend que le user la ferme
	        fenetreStage.showAndWait();

	        return controller.isOkClicked();

		}
		catch ( IOException e)
		{
			 e.printStackTrace();
			 return false;
		}
	}
	
	public boolean afficherFenetreModifierProspect(Prospect prospect)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(MainApp.class.getResource("view/ModifierProspect.fxml"));
			
			AnchorPane fenetreModifierProspect = (AnchorPane) loader.load();
			
			// creation du stage de la fenetre
	        Stage fenetreStage = new Stage();
	        
	        fenetreStage.setTitle("Modifier prospect");
	        fenetreStage.initModality(Modality.WINDOW_MODAL);
	        fenetreStage.initOwner(stagePrincipal);
	        
	        Scene scene = new Scene(fenetreModifierProspect);
	        fenetreStage.setScene(scene);

			
			ModifierPersonneController controller = loader.getController();
			controller.setFenetreStage(fenetreStage);
			controller.setProspect(prospect);
			
			// Montre la fenetre et attend que le user la ferme
	        fenetreStage.showAndWait();

	        return controller.isOkClicked();

		}
		catch ( IOException e)
		{
			 e.printStackTrace();
			 return false;
		}
	}
	
	public boolean afficherFenetreModifierRepresentant(Representant representant)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(MainApp.class.getResource("view/ModifierRepresentant.fxml"));
			
			AnchorPane fenetreModifierRepresentant = (AnchorPane) loader.load();
			
			// creation du stage de la fenetre
	        Stage fenetreStage = new Stage();
	        
	        fenetreStage.setTitle("Modifier representant");
	        fenetreStage.initModality(Modality.WINDOW_MODAL);
	        fenetreStage.initOwner(stagePrincipal);
	        
	        Scene scene = new Scene(fenetreModifierRepresentant);
	        fenetreStage.setScene(scene);

			
			ModifierPersonneController controller = loader.getController();
			controller.setFenetreStage(fenetreStage);
			controller.setRepresentant(representant);
			
			// Montre la fenetre et attend que le user la ferme
	        fenetreStage.showAndWait();

	        return controller.isOkClicked();

		}
		catch ( IOException e)
		{
			 e.printStackTrace();
			 return false;
		}
	}
	
	// return le fichier preference comme il était a la precedente ouverture, si non trouver retourne null
	public File getPersonFilePath() 
	{
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    String filePath = prefs.get("filePath", null);
	    
	    if (filePath != null) 
	    {
	        return new File(filePath);
	    } 
	    else 
	    {
	        return null;
	    }
	}
	
	// met en place le chemin du fichier ou l'enleve si fichier = null
	public void setPersonFilePath(File file) 
	{
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    
	    if (file != null) 
	    {
	        prefs.put("filePath", file.getPath());

	        // Mise a jour du titre
	        stagePrincipal.setTitle("Centre de gestion ToutBois " + file.getName());
	    } 
	    else 
	    {
	        prefs.remove("filePath");

	        // Mise a jour du titre
	        stagePrincipal.setTitle("Centre de gestion ToutBois ");
	    }
	}


	// charge les données d'une personne a partir d'un fichier
	public void loadPersonDataFromFile(File file) 
	{
	    try 
	    {
	        JAXBContext context = JAXBContext.newInstance(ProspectListWrapper.class);
	        Unmarshaller um = context.createUnmarshaller();
	        
	        JAXBContext context2 = JAXBContext.newInstance(ClientListWrapper.class);
	        Unmarshaller um2 = context2.createUnmarshaller();
	        
	        JAXBContext context3 = JAXBContext.newInstance(RepresentantListWrapper.class);
	        Unmarshaller um3 = context3.createUnmarshaller();

	        // Reading XML from the file and unmarshalling.
	        ProspectListWrapper wrapper1 = (ProspectListWrapper) um.unmarshal(file);
	        RepresentantListWrapper wrapper2 = (RepresentantListWrapper) um3.unmarshal(file);
	        ClientListWrapper wrapper3 = (ClientListWrapper) um2.unmarshal(file);

	        donneesClient.clear();
	        donneesProspect.clear();
	        donneesRepresentant.clear();
	        
	        donneesProspect.addAll(wrapper1.getProspect());
	        donneesRepresentant.addAll(wrapper2.getRepresentant());
	        donneesClient.addAll(wrapper3.getClient());
	        

	        // Save the file path to the registry.
	        setPersonFilePath(file);

	    } 
	    catch (Exception e) 
	    { 
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Erreur");
	        alert.setHeaderText("chargement impossible");
	        alert.setContentText("impossible de charger les donnees du fichier :\n" + file.getPath());

	        alert.showAndWait();
	    }
	}

	// sauvegarde les données d'une personne a partir d'un fichier
	public void savePersonDataToFile(File file) 
	{
	    try
	    {
	        JAXBContext context = JAXBContext.newInstance(ProspectListWrapper.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        
	        JAXBContext context2 = JAXBContext.newInstance(ClientListWrapper.class);
	        Marshaller m2 = context2.createMarshaller();
	        m2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        
	        JAXBContext context3 = JAXBContext.newInstance(RepresentantListWrapper.class);
	        Marshaller m3 = context3.createMarshaller();
	        m3.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        ProspectListWrapper wrapper1 = new ProspectListWrapper();
	        RepresentantListWrapper wrapper2 = new RepresentantListWrapper();
	        ClientListWrapper wrapper3 = new ClientListWrapper();	            

	        wrapper1.setProspect(donneesProspect);  
	        wrapper2.setRepresentant(donneesRepresentant); 
	        wrapper3.setClient(donneesClient);  

	        // Marshalling and saving XML to the file.
	        m.marshal(wrapper1, file);
	        m2.marshal(wrapper3, file);
	        m3.marshal(wrapper2, file);

	        // Save the file path to the registry.
	        setPersonFilePath(file);
	    } 
	    catch (Exception e) 
	    { 
	        e.printStackTrace();
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Erreur");
	        alert.setHeaderText("Sauvegarde impossible");
	        alert.setContentText("Impossible de sauvegarder les donnees dans le fichier :\n" + file.getPath());

	        alert.showAndWait();
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
