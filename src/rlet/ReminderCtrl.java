/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ReminderCtrl {
    
    private Stage stage;//used to not be private
   
    private static ReminderCtrl reminderCtrl;
    private Task selectedTask;
    
    private ReminderCtrl(Stage existingStage, Task t){
        stage = existingStage;
        showUI(t);
    }
    
    public static ReminderCtrl getReminderCtrl(Stage existingStage, Task t){ 
        if (reminderCtrl == null) {
            
            reminderCtrl = new ReminderCtrl(existingStage, t); 
            
        }
        return reminderCtrl; 
    } 
   
     
    public void showUI(Task t){
        try {
           
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewReminderUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Create Reminder");
            stage.setScene(new Scene(root));
            stage.show();
            
            selectedTask = t;
            ReminderUICtrl controller = (ReminderUICtrl)fxmlLoader.getController();
            controller.setTask(selectedTask); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
