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
public class TaskUICtrl {
    
    @FXML private Text actiontarget;
    private static TaskUICtrl TaskUICtrl;
    
    public TaskUICtrl(){
        
      
        
    }
    
    @FXML protected void handleMarkAsDoneButtonAction(ActionEvent event){
        
        actiontarget.setText("Mark as done button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getActivityLogCtrl(theStage).addToLog();
        
        
    }
    
    @FXML protected void handleViewRemindersButtonAction(ActionEvent event){
        
        actiontarget.setText("Mark as done button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getReminderListCtrl(theStage);
        
    }
}
