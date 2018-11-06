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
    private String username;
    
    private NavigationCtrl(Stage theExistingStage){
        
        stage = theExistingStage;
        this.setUpNavigationScene();
        stage.show();
    }
    
    public static NavigationCtrl getNavigationCtrl(Stage theStage){
        
        if(theNavigationCtrl != null){
            return theNavigationCtrl;
        }else{
            theNavigationCtrl = new NavigationCtrl(theStage);
            return theNavigationCtrl;
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
    
    public void getTaskCtrl(Stage theStage){
        TaskCtrl.getTaskCtrl(theStage);
    }
   
    public void exit(){
        System.exit(0);
    }
    
}
