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
public class TaskListCtrl {
    
    @FXML private Text actiontarget;
    private static TaskListCtrl taskListCtrl;
    private TaskList taskList;
    
    Stage stage;
    
    private TaskListCtrl(Stage existingStage){
        
        stage = existingStage;
        taskList = NavigationCtrl.getNavigationCtrl(stage).getCurrentUser().getTaskList();
        try {
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TaskListUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Task List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static TaskListCtrl getTaskListCtrl(Stage existingStage)
    { 
        if (taskListCtrl == null) {
            
            taskListCtrl = new TaskListCtrl(existingStage); 
            
        }
        return taskListCtrl; 
    } 
    
    public void addNewTask(Task t){
        
        taskList.addTask(t);
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
        
    }
    
    public void removeTask(Task t){
        
        taskList.removeTask(t);
        
    }
    
}
