/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class TaskUICtrl implements Initializable{

    @FXML private GridPane taskDetailTable;
    @FXML private Label taskNameValue;
    @FXML private Label taskDueDateValue;
    @FXML private Label taskStatusValue;
    @FXML private Button markAsDone;
    private static TaskUICtrl TaskUICtrl;
    private Task selectedTask;
    
    @FXML private TableView<Reminder> reminderListTable;
    @FXML private TableColumn<Reminder, Date> reminderDate;
    @FXML private Button newReminder;
    private ObservableList<Reminder> reminderList;
    
   
 
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
       
    }
    
    @FXML protected void handleMarkAsDoneButtonAction(ActionEvent event){
        
        Stage theStage = (Stage) markAsDone.getScene().getWindow();
        //theStage.hide();
        selectedTask.markAsDone();
        TaskListCtrl.getTaskListCtrl(theStage).removeTask(selectedTask);
        ActivityLogCtrl.getActivityLogCtrl(theStage).addToLog(selectedTask);
        
        
        Stage stage = (Stage) newReminder.getScene().getWindow();
        TaskListCtrl.getTaskListCtrl(stage).showUI();
       
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
        
        
       
    }
    
    @FXML protected void handleAddReminderButtonAction(ActionEvent event){
        
        Stage theStage = (Stage) markAsDone.getScene().getWindow();
        theStage.hide();
        ReminderCtrl.getReminderCtrl(theStage, selectedTask);
        
    }

    public void setTask(Task t) {
        this.selectedTask = t;
        taskNameValue.setText(selectedTask.getName());
        taskDueDateValue.setText(selectedTask.getDueDate().toString());
        taskStatusValue.setText(selectedTask.getStatus().toString());
        
        reminderList = FXCollections.observableArrayList(selectedTask.getReminderList().getList());
        reminderDate.setCellValueFactory(new PropertyValueFactory<Reminder, Date>("date")); 
        reminderListTable.setItems(reminderList);
        
    }
    
    
    
    
}
