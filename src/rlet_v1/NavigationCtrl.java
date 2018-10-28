/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet_v1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
/**
 *
 * @author kviro
 */
public class NavigationCtrl {//singleton pattern
    
    
    private static NavigationCtrl navCtrl;
    Stage stage;
    
    private NavigationCtrl(Stage existingStage){
        
        stage = existingStage;
        try {
            
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NavigationUI.fxml"));
            Parent root1 = fxmlLoader.load();
            
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Main Menu");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(NavigationCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static NavigationCtrl getNavigationCtrl(Stage existingStage)
    { 
        if (navCtrl == null) {
            
            navCtrl = new NavigationCtrl(existingStage); 
            
        }
        return navCtrl; 
    } 
    
}
