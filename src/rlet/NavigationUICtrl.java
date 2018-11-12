/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class NavigationUICtrl {
    
    
    @FXML private Text actiontarget;
    private static NavigationCtrl theNavigationUICtrl;
    @FXML private Label username;
    @FXML private Button activityLogButton;
    public NavigationUICtrl(){
        
        
        
    }
    
    @FXML protected void handleManageTasksButtonAction(ActionEvent event){
        
        //actiontarget.setText("Task list button pressed");
        Stage theStage = (Stage)username.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getTaskListCtrl(theStage);
        
    }
    
    @FXML protected void handleActivityLogButtonAction(ActionEvent event){
        
        //actiontarget.setText("Activity Log button pressed");
        Stage theStage = (Stage) activityLogButton.getScene().getWindow();
        theStage.hide();
        ActivityLogCtrl.getActivityLogCtrl(theStage);
        
    }
    
}
