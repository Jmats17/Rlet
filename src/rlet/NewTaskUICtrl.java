/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class NewTaskUICtrl implements Initializable{
    @FXML private Button submitButton;
    @FXML private TextField taskNameField;
    @FXML private TextField taskTimeField;
    @FXML private DatePicker taskDueDateField;
    @FXML private Label timeLabel;
    @FXML private Label nameLabel;
    @FXML private Label dueDateLabel;
    @FXML private Button cancelButton;
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event){
        
        Stage theStage = (Stage) submitButton.getScene().getWindow();
        String taskName = taskNameField.getText();
        
        LocalDate date = taskDueDateField.getValue();
        String s = date.toString();
        //System.out.println(s);
        String dateString = s.replace("-", "/");
        //System.out.println(dateString);
        String fullString = dateString + " " + taskTimeField.getText();
        
        Task newTask = new Task(taskName, fullString, NavigationCtrl.getNavigationCtrl(theStage).getCurrentUser().getUsername());
        TaskListCtrl.getTaskListCtrl(theStage).addNewTask(newTask);
        
        //theStage.hide();
        
    }
    
    @FXML protected void handleCancelButtonAction(ActionEvent event){
        
        Stage theStage = (Stage) submitButton.getScene().getWindow();
        theStage.hide();
        TaskListCtrl.getTaskListCtrl(theStage).showUI();
    
    }
}
