/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
/**
 *
 * @author kviro
 */
public class LoginCtrl implements Initializable {
    
    @FXML private Label label;
    @FXML private Text actiontarget;
    
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField = new PasswordField();
    
    private UserList testList = new UserList();
    private static User loggedInUser;
    
    public LoginCtrl(){
        
    }
    
    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
        
        //actiontarget.setText("Sign in button pressed");
        //System.out.println(getUsername());
        //System.out.println(getPassword());
        String username = getUsername();
        char[] password = getPassword();
        
        loggedInUser = testList.authenticate(username, password);
        
        if(loggedInUser != null){
            Stage stage = (Stage)passwordField.getScene().getWindow();
            stage.hide(); //hide stage before passing control
            NavigationCtrl theNavigationCtrl = NavigationCtrl.getNavigationCtrl(stage, loggedInUser);
            
        }
        
    }
    
    private String getUsername() {
        
        return usernameField.getText();
        
    }
    
    private char[] getPassword() {
        
        char[] input = passwordField.getText().toCharArray();
        return input;
        
    }
    
    public static User getLoggedInUser(){
        
        return loggedInUser;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
