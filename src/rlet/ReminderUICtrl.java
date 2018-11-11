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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ReminderUICtrl implements Initializable{
    
    @FXML private TextField dateField;
    @FXML private TextField timeField;
    @FXML private Button createReminderButton;
    private Stage stage;
    private Task selectedTask;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    @FXML protected void handleCreateReminderButtonAction(ActionEvent event){
        
        String dateString = dateField.getText();
        String timeString = timeField.getText();
        String fullDateString = dateString + " " + timeString;
        ReminderListCtrl.getReminderListCtrl(stage).addNewReminder(fullDateString);
        
    }
    
    public void setTask(Task t) {
        this.selectedTask = t;
    }
}
