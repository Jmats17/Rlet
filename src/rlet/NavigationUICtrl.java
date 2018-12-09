/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class NavigationUICtrl implements Initializable{
    
    
    @FXML private Text actiontarget;
    private static NavigationUICtrl theNavigationUICtrl;
    @FXML private Label username;
    @FXML private Button activityLogButton;
    @FXML private Button taskListButton;
    @FXML private Label usernameLabel;
    private boolean taskButtonPressed;
    private boolean resourceButtonPressed;
    private boolean activityLogButtonPressed;
    private User user;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        taskButtonPressed = false;
        resourceButtonPressed = false;
        activityLogButtonPressed = false;
        
    }
    
    @FXML protected void handleManageTasksButtonAction(ActionEvent event){
        
        Stage theStage = (Stage)username.getScene().getWindow();
        theStage.hide();
        if(taskButtonPressed == false){
            taskButtonPressed = true;
            NavigationCtrl.getNavigationCtrl(theStage).getTaskListCtrl(theStage);
        } else {
            NavigationCtrl.getNavigationCtrl(theStage).getTaskListCtrl(theStage).showUI();
        }
        
    }
    
    @FXML protected void handleActivityLogButtonAction(ActionEvent event){
        
        Stage theStage = (Stage) username.getScene().getWindow();
        theStage.hide();
        if(activityLogButtonPressed == false){
            activityLogButtonPressed = true;
            ActivityLogCtrl.getActivityLogCtrl(theStage);
        }else{
            ActivityLogCtrl.getActivityLogCtrl(theStage).showUI();
        }
        
    }
    
    @FXML protected void handleTrackResourcesButtonAction(ActionEvent event){
        
        Stage theStage = (Stage) username.getScene().getWindow();
        theStage.hide();
        if(resourceButtonPressed == false){
            resourceButtonPressed = true;
            ResourceTrackerCtrl.getResourceTrackerCtrl(theStage);
        } else {
            ResourceTrackerCtrl.getResourceTrackerCtrl(theStage).showUI();
        }
    }
    
    public void setUser(User u){
        user = u;
        usernameLabel.setText(user.getUsername());
    }
    
}
