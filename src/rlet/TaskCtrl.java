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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class TaskCtrl {
    
    @FXML private Text actiontarget;
    private static TaskCtrl taskCtrl;
    private Task selectedTask;
    private Stage stage; //used to not be private
   
    private TaskCtrl(Stage existingStage, Task existingTask){
        selectedTask = existingTask;
        stage = existingStage;
        try {
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TaskUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Task Details");
            stage.setScene(new Scene(root));
            
            stage.show();
            
            TaskUICtrl controller = (TaskUICtrl)fxmlLoader.getController();
            controller.setTask(selectedTask); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static TaskCtrl getTaskCtrl(Stage existingStage, Task existingTask)
    { 
        if (taskCtrl == null) {
            
            taskCtrl = new TaskCtrl(existingStage, existingTask); 
            
        }
        return taskCtrl; 
    } 
    
    public void showUI(){
        try {
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TaskUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Task Details");
            stage.setScene(new Scene(root));
            
            stage.show();
            
            TaskUICtrl controller = (TaskUICtrl)fxmlLoader.getController();
            controller.setTask(selectedTask); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    
   
    
}
