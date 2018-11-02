/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class NavigationUICtrl {
    
    
    @FXML private Text actiontarget;
    
    public NavigationUICtrl(){
        
        
        
    }
    
    @FXML protected void handleTaskListButtonAction(ActionEvent event){
        
        actiontarget.setText("Task list button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getTaskCtrl(theStage);
        
    }
    
}