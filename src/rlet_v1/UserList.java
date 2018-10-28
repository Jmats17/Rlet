/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet_v1;

//import java.util.ArrayList;
import java.util.ArrayList;
/**
 *
 * @author kviro
 */
public class UserList {
    
    private ArrayList<User> userList;
    
    public UserList(){
        
        userList = new ArrayList();
        
    }
    
    public void addUser(User u){
        
        userList.add(u);
        
    }
    
    public ArrayList getList(){
        
        return userList;
        
    }
    
    public boolean authenticate(String testUsername, char[] testPassword){
        
        boolean usernameValid = false;
        boolean passwordValid = true;
       
        for(User u: userList){
            
            if(testUsername.equals(u.getUsername())){
                System.out.println("Username found: " + u.getUsername());
                usernameValid = true;
                //System.out.println("Correct password: " + u.getPassword());
                //System.out.println("User password: " + testPassword);
                
                for(int i = 0; i < testPassword.length; i++){
                    
                    if(testPassword[i] != u.getPassword()[i]){
                        System.out.println("Incorrect Password");
                        return false;
                    }
                    
                }
                
            }
        }
        
        if(usernameValid == true && passwordValid == true){
            
            return true;
            
        } else {
            
            return false;
            
        }
       
    
    }
    
    
}
