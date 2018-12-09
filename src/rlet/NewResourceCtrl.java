/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class NewResourceCtrl {
    private Stage stage;
    private static NewResourceCtrl newResourceCtrl;
    
    private NewResourceCtrl(Stage existingStage){
        stage = existingStage;
        
        try {
           
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewResourceUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("New Resource");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static NewResourceCtrl getNewResourceCtrl(Stage existingStage){
        
        if (newResourceCtrl == null) {
            
            newResourceCtrl = new NewResourceCtrl(existingStage); 
            
        }
        return newResourceCtrl; 
        
    }  
}
