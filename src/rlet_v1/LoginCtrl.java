/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet_v1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.beans.property.StringProperty;
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
    
    public LoginCtrl(){
        
        char[] justinPassword = new char[] {'j', 'm'};
        Roommate user1 = new Roommate("Justin", justinPassword);
        char[] kenPassword = new char[] {'k', 'v'};
        Roommate user2 = new Roommate("Ken", kenPassword);
        
        testList.addUser(user1);
        testList.addUser(user2);
        
        
    }
    
    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
        
        //actiontarget.setText("Sign in button pressed");
        //System.out.println(getUsername());
        //System.out.println(getPassword());
        String username = getUsername();
        char[] password = getPassword();
        
        boolean authenticated = testList.authenticate(username, password);
        
        if(authenticated == true){
            Stage stage = (Stage) label.getScene().getWindow();
            //hide stage
            NavigationCtrl theNavigationCtrl = NavigationCtrl.getNavigationCtrl(stage);
            
        }
        
    }
    
    private String getUsername() {
        
        return usernameField.getText();
        
    }
    
    private char[] getPassword() {
        
        char[] input = passwordField.getText().toCharArray();
        return input;
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
