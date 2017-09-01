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
    private void handleOuvrir() 
    {
        FileChooser fileChooser = new FileChooser();

        // mise en place d'un filtre pour les extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // affiche la fenetre sauvegarde fichier
        File file = fileChooser.showOpenDialog(mainApp.getStagePrincipal());

        if (file != null) {
            mainApp.loadPersonDataFromFile(file);
        }
    }


    // sauvegarde le fichier dans le fichier ouvert. Si aucun fichier n'est ouvert passe sur le Save as
    @FXML
    private void handleSave() 
    {
        File personFile = mainApp.getPersonFilePath();
        if (personFile != null) 
        {
            mainApp.savePersonDataToFile(personFile);
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
        FileChooser fileChooser = new FileChooser();

        // mise en place d'un filtre pour les extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // affiche la fenetre sauvegarde fichier
        File file = fileChooser.showSaveDialog(mainApp.getStagePrincipal());

        if (file != null) 
        {
            // verifier que l'extension est correct
            if (!file.getPath().endsWith(".xml")) 
            {
                file = new File(file.getPath() + ".xml");
            }
            
            mainApp.savePersonDataToFile(file);
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


