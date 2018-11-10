/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author kviro
 */
public class NewTaskUICtrl implements Initializable{
    
    @FXML private TextField taskNameField;
    @FXML private TextField taskDueDateField;
    
     //NavigationCtrl.getNavigationCtrl(theStage).getTaskListCtrl(theStage).addNewTask(new Task(taskNameField.getText(), taskDueDateField.getText()));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
