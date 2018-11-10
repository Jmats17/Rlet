/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author kviro
 */
public class NewTaskUICtrl {
    
    @FXML private TextField taskNameField;
    @FXML private TextField taskDueDateField;
     //NavigationCtrl.getNavigationCtrl(theStage).getTaskListCtrl(theStage).addNewTask(new Task(taskNameField.getText(), taskDueDateField.getText()));
}
