/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ResourceCtrl {
    
    private Stage stage;
    private static ResourceCtrl resourceCtrl;
    private Resource selectedResource;
    private User user;
    
    private ResourceCtrl(Stage existingStage, Resource existingResource){
        selectedResource = existingResource;
        stage = existingStage;
        user = NavigationCtrl.getNavigationCtrl(stage).getCurrentUser();
        showUI();
    }
    
    public static ResourceCtrl getResourceCtrl(Stage existingStage, Resource existingResource)
    { 
        if (resourceCtrl == null) {
            
            resourceCtrl = new ResourceCtrl(existingStage, existingResource); 
            
        }
        return resourceCtrl; 
    } 
    
    public void addResourceAmount(double d, double c){
        selectedResource.addResource(d, c);
    }
    
    public void reportResourceUsage(User u, double d){
        selectedResource.useResource(u, d);
    }
    
    public void showUI(){
        try {
            //load new fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResourceUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Resource Details");
            stage.setScene(new Scene(root));
            
            stage.show();
            
            ResourceUICtrl controller = (ResourceUICtrl)fxmlLoader.getController();
            controller.setResource(selectedResource, user); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
