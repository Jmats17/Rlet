/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    
    private static TaskListCtrl taskListCtrl;
    private TaskList taskList;
    
    Stage stage;
    
    private TaskListCtrl(Stage existingStage){
        
        stage = existingStage;
        taskList = NavigationCtrl.getNavigationCtrl(stage).getCurrentUser().getTaskList();
        showUI();
        
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
        showUI();
        
    }
    
    public void removeTask(Task t){
        
        taskList.removeTask(t);
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
        showUI();
    }
    
    public ObservableList<Task> getTaskList(){
        
        ObservableList<Task> observableTaskList = FXCollections.observableArrayList(taskList.getList());
        return observableTaskList;
        
    }
    
    public void showUI(){
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
    
}
