/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ResourceTrackerUICtrl implements Initializable{
    
    @FXML private Button generateBillsButton;
    @FXML private Button addResourceButton;
    @FXML private Label waterCost;
    @FXML private Label electricCost;
    @FXML private Label rentCost;
    @FXML private Label groceryCost;
    @FXML private Label quickViewLabel;
    @FXML private Label waterUsage;
    @FXML private Label electricUsage;
    @FXML private TableView<Resource> resourceTable;
    @FXML private TableColumn<Resource, String> nameCol;
    @FXML private TableColumn<Resource, Double> totalCol; 
    @FXML private TableColumn<Resource, Double> usageCol;
    @FXML private TableColumn<Resource, Double> costCol;
    @FXML private Button backButton;
    private ObservableList<Resource> resourceList;
    private User user;
    private ResourceTracker resourceTracker;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
       user = LoginCtrl.getLoggedInUser();
       
       ArrayList<Resource> list = PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getResourceTracker().getResourceList();
       resourceList = FXCollections.observableArrayList(list);
       //resourceTable.setItems(resourceList);
       //nameCol.setCellValueFactory(new PropertyValueFactory<Resource, String>("name"));
       nameCol.setCellValueFactory(cellData -> {
       Resource currentResource = cellData.getValue();
       return new ReadOnlyStringWrapper(currentResource.getName());
       });
       totalCol.setCellValueFactory(cellData -> {
       Resource currentResource = cellData.getValue();
       return new SimpleDoubleProperty(currentResource.getAmountRemaining()).asObject();
       });
       DecimalFormat df = new DecimalFormat("#.##");
       usageCol.setCellValueFactory(cellData -> {
           Resource currentResource = cellData.getValue();
           return new SimpleDoubleProperty(Double.parseDouble(df.format(currentResource.getUsage().get(user)))).asObject();
       });
       
       costCol.setCellValueFactory(cellData -> {
           Resource currentResource = cellData.getValue();
           
           return new SimpleDoubleProperty(Double.parseDouble(df.format(currentResource.calculateCostToUser(user)))).asObject();
       });

       //totalCol.setCellValueFactory(new PropertyValueFactory<Resource, Double>("totalNumber"));
       resourceTable.setItems(resourceList);
       //usageCol.setCellValueFactory(new PropertyValueFactory<Resource, Double>("")); 
       //costCol.setCellValueFactory(new PropertyValueFactory<Resource, Double>(""));
       //these two values are inside a map - what String do i use, or maybe another way to do it? 
      
    }
    
    @FXML protected void handleGenerateBillsButtonAction(){
        Stage theStage = (Stage)electricUsage.getScene().getWindow();
        ResourceTrackerCtrl.getResourceTrackerCtrl(theStage).createBills();
        TaskListCtrl.getTaskListCtrl(theStage).showUI();
    }
    
    public void setResourceTracker(User u, ResourceTracker r) {
        
        this.user = u;
        this.resourceTracker = r;
        DecimalFormat df = new DecimalFormat("#.##");
        rentCost.setText("$" + df.format(resourceTracker.getRentCost()));
        groceryCost.setText("$" + df.format(resourceTracker.getGrocerySplit()));
        
        double waterUsageValue = resourceTracker.getWaterUsageTracker().get(user);
        waterUsage.setText(df.format(waterUsageValue));
        waterCost.setText("$" + df.format(resourceTracker.calculateWaterBill(user)));
        
        double electricUsageValue = resourceTracker.getElectricityUsageTracker().get(user);
        electricUsage.setText(df.format(electricUsageValue));
        electricCost.setText("$" + df.format(resourceTracker.calculateElectricBill(user)));
        
    }
    
    @FXML protected void handleAddResourceButtonAction(ActionEvent event){
        
        Stage theStage = (Stage)electricUsage.getScene().getWindow(); 
        NewResourceCtrl.getNewResourceCtrl(theStage);
        
    }
    
    @FXML protected void handleViewResourceButtonAction(){
        Stage theStage = (Stage) electricUsage.getScene().getWindow();
        Resource currentlySelectedResource = this.resourceTable.getSelectionModel().getSelectedItem();
        ResourceCtrl.getResourceCtrl(theStage, currentlySelectedResource);
    }
    
    @FXML protected void handleBackButtonAction(ActionEvent e){
           
        Stage theStage = (Stage) electricUsage.getScene().getWindow();
        theStage.hide();
        NavigationCtrl.getNavigationCtrl(theStage).setUpNavigationScene();
        
    }
    
    
}
