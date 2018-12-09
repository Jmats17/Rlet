/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
/**
 *
 * @author kviro
 */
public class NavigationCtrl {
    
    
    @FXML private Stage stage;
    @FXML private Text actiontarget;
    
    private static NavigationCtrl theNavigationCtrl;
    private User user;
    
    private NavigationCtrl(Stage theExistingStage, User u){
        
        user = u;
        stage = theExistingStage;
        this.setUpNavigationScene();
        stage.show();
    }
    
    public static NavigationCtrl getNavigationCtrl(Stage theStage, User u){
        
        if(theNavigationCtrl != null){
            return theNavigationCtrl;
        }else{
            theNavigationCtrl = new NavigationCtrl(theStage, u);
            return theNavigationCtrl;
        }
    }
    
    
    public static NavigationCtrl getNavigationCtrl(Stage theStage){
        
        if(theNavigationCtrl != null){
            return theNavigationCtrl;
        } else {
            return null;
        }
    }
    
    @FXML public void setUpNavigationScene(){
       
        Scene scene;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NavigationUI.fxml"));
            Parent root = fxmlLoader.load();
            scene = new Scene(root);
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
            
            NavigationUICtrl controller = (NavigationUICtrl)fxmlLoader.getController();

            controller.setUser(user); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public User getCurrentUser(){
        return user;
    }
    
    public TaskCtrl getTaskCtrl(Stage theStage){
        return TaskCtrl.getTaskCtrl(theStage, null);
    }
    
    public ActivityLogCtrl getActivityLogCtrl(Stage theStage){
       return ActivityLogCtrl.getActivityLogCtrl(theStage);
    }
    
    public TaskListCtrl getTaskListCtrl(Stage theStage){
        return TaskListCtrl.getTaskListCtrl(theStage);
    }
    
    public PersistentDataCtrl getPersistentDataCtrl(){
        return PersistentDataCtrl.getPersistentDataCtrl();
    }
    
    
    
    public void exit(){
        System.exit(0);
    }
    
}
