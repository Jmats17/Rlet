/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class TaskCtrl {
    
    private static TaskCtrl taskCtrl;
    Stage stage;
    
    private TaskCtrl(Stage existingStage){
        
        stage = existingStage;
        try {
            
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TaskListUI.fxml"));
            Parent root1 = fxmlLoader.load();
            
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Task List");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(NavigationCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static TaskCtrl getTaskCtrl(Stage existingStage)
    { 
        if (taskCtrl == null) {
            
            taskCtrl = new TaskCtrl(existingStage); 
            
        }
        return taskCtrl; 
    } 
}
