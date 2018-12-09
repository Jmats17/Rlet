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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML private TableColumn<Task, String> taskName;
    @FXML private TableColumn<Task, Date> taskDueDate;
    @FXML private TableColumn<Task, Boolean> taskStatus;
    @FXML private TableColumn<Task, String> assignedUser;
    @FXML private Button backButton;
    private ObservableList<Task> activityLog;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showUI();
    }
    
    @FXML protected void handleViewTaskButtonAction(){
        
        Stage theStage = (Stage) activityLogTable.getScene().getWindow();
        Task currentlySelectedTask = this.activityLogTable.getSelectionModel().getSelectedItem();
        TaskCtrl.getTaskCtrl(theStage, currentlySelectedTask).showUI();
        
    }
    
    @FXML protected void handleBackButtonAction(ActionEvent e){
        
        Stage theStage = (Stage) activityLogTable.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).setUpNavigationScene();
        
    }
    
    public void showUI(){
        activityLog = FXCollections.observableArrayList(PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getActivityLog().getActivityLog());
        activityLogTable.setItems(activityLog);
        
        taskName.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        
        taskName.setCellValueFactory(cellData -> {
        Task currentTask = cellData.getValue();
        return new ReadOnlyStringWrapper(currentTask.getName());
        });
       
        assignedUser.setCellValueFactory(new PropertyValueFactory<Task, String>("user"));
        taskDueDate.setCellValueFactory(new PropertyValueFactory<Task, Date>("dueDate"));
        
        taskStatus.setCellValueFactory(new PropertyValueFactory<Task, Boolean>("completed"));
       
        taskStatus.setCellValueFactory(cellData -> {
        Task currentTask = cellData.getValue();
        return new ReadOnlyBooleanWrapper(currentTask.getStatus());
        });
    }
 
    
    
}
