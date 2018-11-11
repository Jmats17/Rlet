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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author kviro
 */
public class ActivityLogCtrl {
    
    @FXML private Stage stage;
    @FXML private Text actiontarget;
    
    private static ActivityLogCtrl theActivityLogCtrl;
    private ActivityLog activityLog;
   //
    private ActivityLogCtrl(Stage theExistingStage){
        
        activityLog = PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getActivityLog();
        stage = theExistingStage;
        this.setUpActivityLogScene();
        stage.show();
    }
    
    public static ActivityLogCtrl getActivityLogCtrl(Stage theStage){
        
        if(theActivityLogCtrl != null){
            return theActivityLogCtrl;
        }else{
            theActivityLogCtrl = new ActivityLogCtrl(theStage);
            return theActivityLogCtrl;
        }
    }
    
    @FXML public void setUpActivityLogScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("ActivityLogUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Activity Log");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addToLog(){
        
        
        
    }
    
}
