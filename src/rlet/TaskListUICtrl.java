/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class TaskListUICtrl implements Initializable{

    @FXML private Text actiontarget;
    private static TaskListUICtrl theTaskListUICtrl;
    
    @FXML private TableView<Task> taskListTable;
    @FXML private TableColumn<Task, String> taskName;
    @FXML private TableColumn<Task, Date> taskDueDate;
    @FXML private TableColumn<Task, Boolean> taskStatus;
    @FXML private Button addTask;
    @FXML private Button backButton;
    private ObservableList<Task> taskList;
    
    private Stage theStage;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //taskListTable.getItems().clear(); doesn't solve problem
        taskList = FXCollections.observableArrayList(LoginCtrl.getLoggedInUser().getTaskList().getList());
        
        taskListTable.setItems(taskList);
        //taskName.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        taskName.setCellValueFactory(cellData -> {
        Task currentTask = cellData.getValue();
        return new ReadOnlyStringWrapper(currentTask.getName());
        });
        taskDueDate.setCellValueFactory(new PropertyValueFactory<Task, Date>("dueDate"));
        taskStatus.setCellValueFactory(new PropertyValueFactory<Task, Boolean>("completed"));
        taskStatus.setCellValueFactory(cellData -> {
        Task currentTask = cellData.getValue();
        return new ReadOnlyBooleanWrapper(currentTask.getStatus());
        });
        
    }
    
    @FXML protected void handleAddTaskButtonAction(ActionEvent e){
        
        Stage theStage = (Stage) addTask.getScene().getWindow();
        theStage.hide();
        NewTaskCtrl.getNewTaskCtrl(theStage).showUI();
        
    }
    
    @FXML protected void handleViewTaskButtonAction(){
        
        theStage = (Stage) addTask.getScene().getWindow();
        Task currentlySelectedTask = this.taskListTable.getSelectionModel().getSelectedItem();
        TaskCtrl.getTaskCtrl(theStage, currentlySelectedTask).showUI();
        
    }
    
    @FXML protected void handleBackButtonAction(ActionEvent e){
        
        Stage theStage = (Stage) addTask.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).setUpNavigationScene();
        
    }


   
}
