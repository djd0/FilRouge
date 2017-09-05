package controller.view;

import java.io.File;

import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class RootLayoutController {

	
	private MainApp mainApp;
	
	
	
	public void setMainApp(MainApp mainApp) 
	{
        this.mainApp = mainApp;
    }


    // ouvre un repertoire pour choisir un fichier a charger
    @FXML
    private void handleImportRepresentant() 
    {
        FileChooser fileChooser = new FileChooser();

        // mise en place d'un filtre pour les extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // affiche la fenetre sauvegarde fichier
        File file = fileChooser.showOpenDialog(mainApp.getStagePrincipal());

        if (file != null) {
           
            mainApp.loadRepresentantDataFromFile(file);
        }
    }
    
    // ouvre un repertoire pour choisir un fichier a charger
    @FXML
    private void handleImportProspect() 
    {
        FileChooser fileChooser = new FileChooser();

        // mise en place d'un filtre pour les extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // affiche la fenetre sauvegarde fichier
        File file = fileChooser.showOpenDialog(mainApp.getStagePrincipal());

        if (file != null) {
           
            mainApp.loadProspectDataFromFile(file);
        }
    }
    
    // ouvre un repertoire pour choisir un fichier a charger
    @FXML
    private void handleImportClient() 
    {
        FileChooser fileChooser = new FileChooser();

        // mise en place d'un filtre pour les extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // affiche la fenetre sauvegarde fichier
        File file = fileChooser.showOpenDialog(mainApp.getStagePrincipal());

        if (file != null) {
           
            mainApp.loadClientDataFromFile(file);
        }
    }


    // sauvegarde le fichier dans le fichier ouvert. Si aucun fichier n'est ouvert passe sur le Save as
    @FXML
    private void handleSave() 
    {
        File prospectFile = mainApp.getProspectFilePath();
        File clientFile = mainApp.getRepresentantFilePath();
        File representantFile = mainApp.getClientFilePath();
        
        if (prospectFile != null && clientFile != null && representantFile != null) 
        {
            mainApp.savePersonDataToFile(prospectFile, clientFile, representantFile);
        }         
        else 
        {
            handleSaveAs();
        }
    }

    // Ouvre une fenetre ou le user choisit l'endroit ou sauvegarder
    @FXML
    private void handleSaveAs() 
    {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Centre de gestion ToutBois");
        alert.setHeaderText("Information");
        alert.setContentText("La sauvegarde ce fait en 3 temps, 1 fichier a enregistrer par catégorie ( prospect, client, representant)");

        alert.showAndWait();
    	
    	
    	FileChooser fileChooser = new FileChooser();

        // mise en place d'un filtre pour les extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // affiche la fenetre sauvegarde fichier
        File file = fileChooser.showSaveDialog(mainApp.getStagePrincipal());
        File file2 = fileChooser.showSaveDialog(mainApp.getStagePrincipal());
        File file3 = fileChooser.showSaveDialog(mainApp.getStagePrincipal());

        if (file != null && file2 != null && file3 != null) 
        {
            // verifier que l'extension est correct
            if (!file.getPath().endsWith(".xml") && !file2.getPath().endsWith(".xml") && !file3.getPath().endsWith(".xml")) 
            {
                file = new File(file.getPath() + ".xml");
                file2 = new File(file2.getPath() + ".xml");
                file3 = new File(file3.getPath() + ".xml");
            }
            
            mainApp.savePersonDataToFile(file, file2, file3);
        }
    }

    // ouvre une fenetre a propos
    @FXML
    private void handleAPropos()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Centre de gestion ToutBois");
        alert.setHeaderText("A propos");
        alert.setContentText("Auteurs : D'HAESE Quentin et IMOHAMMADIAN Bilal");

        alert.showAndWait();
    }

    // ferme l'application
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}


