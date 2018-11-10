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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ReminderListUICtrl implements Initializable{
    
    @FXML private TableView reminderListTable;
   
    @FXML private TableColumn reminderDate;
    @FXML private Button newReminder;
    private ObservableList<Reminder> reminderList;
    private Stage theStage;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        theStage = (Stage) reminderListTable.getScene().getWindow();
        reminderList = ReminderListCtrl.getReminderListCtrl(theStage).getReminderList();
       
        reminderListTable.setItems(TaskListCtrl.getTaskListCtrl(theStage).getTaskList());
        
        reminderDate.setCellValueFactory(new PropertyValueFactory<Reminder, Date>("date"));
       
        reminderListTable.setItems(reminderList);
    }
    
    @FXML protected void handleNewReminderButtonAction(ActionEvent event){
        
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).getReminderListCtrl(theStage).addNewReminder(reminderDate.getText());
        
    }
    
    @FXML protected void handleDeleteReminderButtonAction(ActionEvent event){
        
        //actiontarget.setText("Delete Reminder button pressed");
        //Stage theStage = (Stage) actiontarget.getScene().getWindow();
        theStage.hide();
        //need to find which reminder was clicked
        //NavigationCtrl.getNavigationCtrl(theStage).getReminderListCtrl(theStage).deleteReminder();
        
    }
}
