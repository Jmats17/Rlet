/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ActivityLogUICtrl implements Initializable{
    @FXML private TableView<Task> activityLogTable;
    @FXML private TableColumn taskName;
    @FXML private TableColumn taskDueDate;
    @FXML private TableColumn taskStatus;
    @FXML private TableColumn assignedUser;
    private ObservableList<Task> taskList;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskList = FXCollections.observableArrayList(PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getActivityLog().getLog());
        activityLogTable.setItems(taskList);
        
        taskName.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        /* getValue() not working
        taskName.setCellValueFactory(cellData -> {
        Task currentTask = cellData.getValue();
        return new ReadOnlyStringWrapper(currentTask.getName());
        });
        */
        assignedUser.setCellValueFactory(new PropertyValueFactory<Task, String>("user"));
        taskDueDate.setCellValueFactory(new PropertyValueFactory<Task, Date>("dueDate"));
        
        taskStatus.setCellValueFactory(new PropertyValueFactory<Task, Boolean>("completed"));
        /* getValue() not working
        taskStatus.setCellValueFactory(cellData -> {
        Task currentTask = cellData.getValue();
        return new ReadOnlyBooleanWrapper(currentTask.getStatus());
        });
        */
    }
    
    @FXML protected void handleViewTaskButtonAction(){
        
        Stage theStage = (Stage) activityLogTable.getScene().getWindow();
        Task currentlySelectedTask = this.activityLogTable.getSelectionModel().getSelectedItem();
        TaskCtrl.getTaskCtrl(theStage, currentlySelectedTask);
        
    }
    
 
    
    
}
