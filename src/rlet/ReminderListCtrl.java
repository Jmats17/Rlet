/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ReminderListCtrl {
    Stage stage;
    private static ReminderListCtrl reminderListCtrl;
    private ReminderList reminderList;
    private ObservableList<Reminder> observableReminderList;
    
    private ReminderListCtrl(Stage existingStage){
        
        stage = existingStage;
        
        try {
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReminderListUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Reminder List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ReminderListCtrl getReminderListCtrl(Stage existingStage)
    { 
        if (reminderListCtrl == null) {
            
            reminderListCtrl = new ReminderListCtrl(existingStage); 
            
        }
        return reminderListCtrl; 
    } 
    
    public void addNewReminder(String dateString){
        
        reminderList.addReminder(dateString);
        NavigationCtrl.getNavigationCtrl(stage).getPersistentDataCtrl().writeSerializedDataModel();
        
    }
    
    public void deleteReminder(){
        
        
        
    }
    
    public ObservableList<Reminder> getReminderList(){
        
        ObservableList<Reminder> observableTaskList = FXCollections.observableArrayList(reminderList.getList());
        return observableReminderList;
        
    }
}
