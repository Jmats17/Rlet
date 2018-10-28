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
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author kviro
 */
public class NavigationCtrl {//singleton class template?
    
    
    private static NavigationCtrl navCtrl;
    
    private NavigationCtrl(Stage existingStage){
        
       //load new fxml
        
    }
    
    public static NavigationCtrl getNavigationCtrl(Stage existingStage) 
    { 
        if (navCtrl==null) 
            
            navCtrl = new NavigationCtrl(existingStage); 
        
        return navCtrl; 
    } 
    
}
