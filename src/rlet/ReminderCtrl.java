/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ReminderCtrl {
    
    Stage stage;
    @FXML private Text actiontarget;
    private static ReminderCtrl reminderCtrl;
    
    private ReminderCtrl(Stage existingStage){
        stage = existingStage;
        try {
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewReminderUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Create Reminder");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public static ReminderCtrl getReminderCtrl(Stage existingStage){ 
        if (reminderCtrl == null) {
            
            reminderCtrl = new ReminderCtrl(existingStage); 
            
        }
        return reminderCtrl; 
    } 
}
