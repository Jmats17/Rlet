/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet_v1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
/**
 *
 * @author kviro
 */
public class NavigationCtrl {//singleton pattern
    
    
    private static NavigationCtrl navCtrl;
    Stage stage;
    
    private NavigationCtrl(Stage existingStage){
        
       stage = existingStage;
       //load new fxml
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NavigationUI.fxml"));
       Parent root1 = fxmlLoader.load();
       stage.initModality(Modality.APPLICATION_MODAL);
       stage.setTitle("Main Menu");
       stage.setScene(new Scene(root1));
       stage.show();
    }
    
    public static NavigationCtrl getNavigationCtrl(Stage existingStage) 
    { 
        if (navCtrl == null) {
            
            navCtrl = new NavigationCtrl(existingStage); 
            
        }
        return navCtrl; 
    } 
    
}
