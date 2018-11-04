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
public class NavigationCtrl {//singleton pattern
    
    
    @FXML private Stage stage;
    @FXML private Text actiontarget;
    
    private static NavigationCtrl theNavigationCntl;
    
    private NavigationCtrl(Stage theExistingStage){
        stage = theExistingStage;
        this.setUpNavigationScene();
        stage.show();
    }
    
    public static NavigationCtrl getNavigationCtrl(Stage theStage){
        if(theNavigationCntl != null){
            return theNavigationCntl;
        }else{
            theNavigationCntl = new NavigationCtrl(theStage);
            return theNavigationCntl;
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
