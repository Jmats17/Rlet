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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ReminderUICtrl implements Initializable{
    
    @FXML private DatePicker reminderDateField;
    @FXML private TextField timeField;
    @FXML private Button createReminderButton;
    private Stage stage;
    private Task selectedTask;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    @FXML protected void handleCreateReminderButtonAction(ActionEvent event){
        
        LocalDate date = reminderDateField.getValue();
        String s = date.toString();
        String dateString = s.replace("-", "/");
        String fullString = dateString + " " + timeField.getText();
       
        //System.out.println("before change");
        //selectedTask.getReminderList().printReminderList();
        
        ReminderListCtrl.getReminderListCtrl(stage, selectedTask).addNewReminder(fullString);
       // System.out.println("After change");
        //selectedTask.getReminderList().printReminderList();
        
        Stage stage = (Stage) createReminderButton.getScene().getWindow();
        TaskCtrl.getTaskCtrl(stage, selectedTask).showUI();
        
        
    }
    
    @FXML protected void handleCancelButtonAction(ActionEvent event){
        Stage stage = (Stage) createReminderButton.getScene().getWindow();
        ReminderCtrl.getReminderCtrl(stage, selectedTask).showUI(selectedTask);
    }
    
    public void setTask(Task t) {
        this.selectedTask = t;
    }
}
