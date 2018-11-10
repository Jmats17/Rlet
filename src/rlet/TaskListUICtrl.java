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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML private Button addtask;
    private ObservableList<Task> taskList;
    
    private Stage theStage;
    private ArrayList<Task> testList;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        taskList = FXCollections.observableArrayList(LoginCtrl.getLoggedInUser().getTaskList().getList());
        testList = LoginCtrl.getLoggedInUser().getTaskList().getList();
        //for testing purposes: table is only displaying the date even though the tasks have other info that is set below
        for(Task t : testList){
            System.out.println(t.getName());
            System.out.println(t.getDueDate());
            System.out.println(t.getStatus() + "\n");
        }
        taskName.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        taskDueDate.setCellValueFactory(new PropertyValueFactory<Task, Date>("dueDate"));
        taskStatus.setCellValueFactory(new PropertyValueFactory<Task, Boolean>("completed"));
        
        taskListTable.setItems(taskList);
    }
    
    @FXML protected void handleAddTaskButtonAction(ActionEvent event){
        
        
        Stage theStage = (Stage) taskName.getTableView().getScene().getWindow();
        theStage.hide();
        TaskCtrl.getTaskCtrl(theStage).reqNewTask();
        
    }
    
     @FXML protected void handleViewTaskButtonAction(ActionEvent event){
        
        //actiontarget.setText("View Task button pressed");
        Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        
    }
    
    

   
}
