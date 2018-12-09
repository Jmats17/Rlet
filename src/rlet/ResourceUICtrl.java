/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ResourceUICtrl implements Initializable{
    
    private Resource selectedResource;
    @FXML private Button addAmountButton;
    @FXML private Button reportUsageButton;
    @FXML private Button backButton;
    @FXML private Label nameValue;
    @FXML private Label amountValue;
    @FXML private Label totalCostValue;
    @FXML private Label usageValue;
    @FXML private Label userCostValue;
    @FXML private TextField addAmountField;
    @FXML private TextField reportUsageField;
    @FXML private TextField addCostField;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
       
    }
    
    @FXML protected void handleAddAmountButtonAction(ActionEvent event){
        Stage existingStage = (Stage)reportUsageButton.getScene().getWindow();
        double amountToAdd = Double.parseDouble(addAmountField.getText());
        double costToAdd = Double.parseDouble(addCostField.getText());
        ResourceCtrl.getResourceCtrl(existingStage, selectedResource).addResourceAmount(amountToAdd, costToAdd);
        ResourceCtrl.getResourceCtrl(existingStage, selectedResource).showUI();
    }
    
    @FXML protected void handleReportUsageButtonAction(ActionEvent event){
        Stage existingStage = (Stage)reportUsageButton.getScene().getWindow();
        double usageToRecord = Double.parseDouble(reportUsageField.getText());
        ResourceCtrl.getResourceCtrl(existingStage, selectedResource).reportResourceUsage(LoginCtrl.getLoggedInUser(), usageToRecord);
        ResourceCtrl.getResourceCtrl(existingStage, selectedResource).showUI();
    }
    
    public void setResource(Resource r, User user) {
        
        this.selectedResource = r;
        
        //set label text for resource data like name
        DecimalFormat df = new DecimalFormat("#.##");
        nameValue.setText(selectedResource.getName());
        amountValue.setText(df.format(selectedResource.getAmountRemaining()));
        totalCostValue.setText("$" + df.format(selectedResource.getTotalResourceCost()));
        usageValue.setText(df.format(selectedResource.getUsage().get(user)));
        userCostValue.setText("$" + df.format(selectedResource.calculateCostToUser(user)));
        
    }
    
    @FXML protected void handleBackButtonAction(ActionEvent e){
        
        
        Stage theStage = (Stage) reportUsageButton.getScene().getWindow();
        theStage.hide();
        ResourceTrackerCtrl.getResourceTrackerCtrl(theStage).showUI();
        
    }
    
   
}
