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
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("NavigationUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Navigation");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public User getCurrentUser(){
        return user;
    }
    
    public TaskCtrl getTaskCtrl(Stage theStage){
        return TaskCtrl.getTaskCtrl(theStage);
    }
    
    public ActivityLogCtrl getActivityLogCtrl(Stage theStage){
       return ActivityLogCtrl.getActivityLogCtrl(theStage);
    }
    
    public TaskListCtrl getTaskListCtrl(Stage theStage){
        return TaskListCtrl.getTaskListCtrl(theStage);
    }
    
    public ReminderCtrl getReminderCtrl(Stage theStage){
        return ReminderCtrl.getReminderCtrl(theStage);
    }
   
    public void exit(){
        System.exit(0);
    }
    
}
