/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class NewResourceUICtrl implements Initializable{
    
    @FXML private Button createButton;
    @FXML private Button cancelButton;
    @FXML private TextField nameField;
    @FXML private TextField amountField;
    @FXML private TextField costField;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML protected void handleCreateButtonAction(ActionEvent event){
        Stage theStage = (Stage) nameField.getScene().getWindow();
        ArrayList<User> u = PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getUserList().getList();
        String name = nameField.getText();
        double amount = Double.parseDouble(amountField.getText());
        double cost = Double.parseDouble(costField.getText());
        Resource newResource = new Resource(name, amount, cost, u);
        ResourceTrackerCtrl.getResourceTrackerCtrl(theStage).addResource(newResource);
        ResourceTrackerCtrl.getResourceTrackerCtrl(theStage).showUI();
    }
    @FXML protected void handleCancelButtonAction(ActionEvent e){
        
        
        Stage theStage = (Stage) nameField.getScene().getWindow();
        theStage.hide();
        ResourceTrackerCtrl.getResourceTrackerCtrl(theStage).showUI();
        
    }
    
}
