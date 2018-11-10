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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author kviro
 */
public class ActivityLogUICtrl implements Initializable{
    @FXML private TableView activityLogTable;
    @FXML private TableColumn taskName;
    @FXML private TableColumn taskDueDate;
    @FXML private TableColumn taskStatus;
    @FXML private TableColumn assignedUser;
    private ObservableList<Task> taskList;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskList = FXCollections.observableArrayList(PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getActivityLog().getLog());
       
        taskName.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        assignedUser.setCellValueFactory(new PropertyValueFactory<Task, String>("user"));
        taskDueDate.setCellValueFactory(new PropertyValueFactory<Task, Date>("dueDate"));
        taskStatus.setCellValueFactory(new PropertyValueFactory<Task, Boolean>("completed"));
        
        activityLogTable.setItems(taskList);
    }
 
    
    
}
