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
public class NewTaskCtrl {
    
    private Stage stage;
    private static NewTaskCtrl newTaskCtrl;
     
    private NewTaskCtrl(Stage existingStage){
        stage = existingStage;
        
        showUI();
    }
    
    public static NewTaskCtrl getNewTaskCtrl(Stage existingStage){
        
        if (newTaskCtrl == null) {
            
            newTaskCtrl = new NewTaskCtrl(existingStage); 
            
        }
        return newTaskCtrl; 
        
    }  
    
    public void showUI(){
         try {
           
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTaskUI.fxml"));
            Parent root = fxmlLoader.load();
            stage.setTitle("Task List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
