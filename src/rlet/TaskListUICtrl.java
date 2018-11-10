/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class TaskListUICtrl implements Initializable{

    @FXML private Text actiontarget;
    private static TaskListUICtrl theTaskListUICtrl;
    
    @FXML private TableView taskListTable;
    @FXML private TableColumn taskName;
    @FXML private TableColumn taskDueDate;
    @FXML private TableColumn taskStatus;
    private ObservableList<Task> taskList;
    
    private Stage theStage;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        theStage = (Stage) taskName.getTableView().getScene().getWindow();
        taskList = TaskListCtrl.getTaskListCtrl(theStage).getTaskList();
       
        taskListTable.setItems(TaskListCtrl.getTaskListCtrl(theStage).getTaskList());
        taskName.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        taskDueDate.setCellValueFactory(new PropertyValueFactory<Task, Date>("dueDate"));
        taskStatus.setCellValueFactory(new PropertyValueFactory<Task, Boolean>("completed"));
        
        taskListTable.setItems(taskList);
    }
    
    @FXML protected void handleAddTaskButtonAction(ActionEvent event){
        
        //actiontarget.setText("Add Task button pressed");
        //Stage theStage = (Stage) taskName.getTableView().getScene().getWindow();
        theStage.hide();
       
        
    }
    
     @FXML protected void handleViewTaskButtonAction(ActionEvent event){
        
        //actiontarget.setText("View Task button pressed");
        //Stage theStage = (Stage) actiontarget.getScene().getWindow();
        //theStage.hide();
        
    }
    
    

   
}
