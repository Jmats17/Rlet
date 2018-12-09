/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ResourceTrackerCtrl {
    
    private static ResourceTrackerCtrl theResourceTrackerCtrl;
    private ResourceTracker resourceTracker;
    private User user;
    Stage stage;
    
    
    private ResourceTrackerCtrl(Stage existingStage){
        
        stage = existingStage;
        user = NavigationCtrl.getNavigationCtrl(stage).getCurrentUser();
        resourceTracker = PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getResourceTracker();
        showUI();
    }
    
    public static ResourceTrackerCtrl getResourceTrackerCtrl(Stage theStage){
        
        if(theResourceTrackerCtrl != null){
            return theResourceTrackerCtrl;
        }else{
            theResourceTrackerCtrl = new ResourceTrackerCtrl(theStage);
            return theResourceTrackerCtrl;
        }
    }
    
    public void addResource(Resource r){
        resourceTracker.addResource(r);
    }
    
    public HashMap<User,Double> getWaterUsageTracker(){
        return resourceTracker.getWaterUsageTracker();
    }
    
    public HashMap<User,Double> getElectricityUsageTracker(){
        return resourceTracker.getElectricityUsageTracker();
    }
    
    public void createBills(){
         resourceTracker.createBills(user);
    }
    
    public void resetMonthlyUsage(){
        resourceTracker.resetMonthlyUsage();
    }
    
    public double getRentCost(){
        return resourceTracker.getRentCost();
    }
    
    public double getGrocerySplit(){
        return resourceTracker.getGrocerySplit();
    }
    
    public double calculateWaterBill(){
        return resourceTracker.calculateWaterBill(user);
    }
    
    public double calculateElectricBill(){
        return resourceTracker.calculateElectricBill(user);
    }
    
    public ArrayList<Resource> getResourceList(){
        return resourceTracker.getResourceList();
    }
    
    public void showUI(){
       try {
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResourceTrackerUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Resource Tracker");
            stage.setScene(new Scene(root));
            stage.show();
            
            ResourceTrackerUICtrl controller = (ResourceTrackerUICtrl)fxmlLoader.getController();
            controller.setResourceTracker(user, resourceTracker); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
}
