/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ReminderListUICtrl {
    
    @FXML private Text actiontarget;
    private static ReminderListUICtrl theReminderListUICtrl;
    @FXML private TextField reminderDateField;
   
    
    public ReminderListUICtrl(){
        
        
        
    }
    
    @FXML protected void handleAddReminderButtonAction(ActionEvent event){
        
        actiontarget.setText("Add Reminder button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getReminderListCtrl(theStage).addNewReminder(reminderDateField.getText());
        
    }
    
    @FXML protected void handleDeleteReminderButtonAction(ActionEvent event){
        
        actiontarget.setText("Delete Reminder button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getReminderListCtrl(theStage).deleteReminder();
        
    }
}
