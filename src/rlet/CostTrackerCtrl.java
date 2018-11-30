/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class CostTrackerCtrl {
    
    private static CostTrackerCtrl theCostTrackerCtrl;
    private CostTracker costTracker;
    @FXML private Stage stage;
    
    
    public CostTrackerCtrl(Stage existingStage){
        
        costTracker = PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getCostTracker();
        stage = existingStage;
        this.setUpCostTrackerScene();
        stage.show();
    }
    
    public static CostTrackerCtrl getCostTrackerCtrl(Stage theStage){
        
        if(theCostTrackerCtrl != null){
            return theCostTrackerCtrl;
        }else{
            theCostTrackerCtrl = new CostTrackerCtrl(theStage);
            return theCostTrackerCtrl;
        }
    }
    
    public void calculateWaterBill(User u){
        
    }
    
    public void calculateElectricityBill(User u){
        
    }
    
    public void addGroceryCost(double d){
        costTracker.addGroceryCost(d);
    }
    
    public void splitGroceryCost(){
        costTracker.splitGroceryCost();
    }
    
    public void splitRent(){
        costTracker.splitRent();
    }
    
    public void resetMonthlyUsage(){
        costTracker.resetMonthlyUsage();
    }
    
    @FXML public void setUpCostTrackerScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("CostTrackerUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Cost Tracker");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
