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
        /*
        - When the user clicks a task in taskListUI, they are taken to the task view for that one task (this UI)
        - this UI has a mark as done button
        - mark as done removes the task from the users tasklist and adds it to the activity log
        
        questions:: 
        - when displaying task list, how to make tasks (displayed as their name) clickable?
        - how to differentiate one task from another when one is clicked?
        
       
        
        */
        
    }
    
    @FXML protected void handleViewRemindersButtonAction(ActionEvent event){
        
        actiontarget.setText("Mark as done button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getReminderListCtrl(theStage);
       
        
    }
}
