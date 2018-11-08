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
public class TaskListUICtrl {
    
    @FXML private Text actiontarget;
    private static TaskListUICtrl theTaskListUICtrl;
    @FXML private TextField taskNameField;
    @FXML private TextField taskDueDateField;
    
    public TaskListUICtrl(){
        
        
        
    }
    
    
    @FXML protected void handleAddTaskButtonAction(ActionEvent event){
        
        actiontarget.setText("Add Task button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getTaskListCtrl(theStage).addNewTask(new Task(taskNameField.getText(), taskDueDateField.getText()));
        
        
    }

   
}
