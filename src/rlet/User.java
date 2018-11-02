/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

/**
 *
 * @author kviro
 */
import java.io.Serializable;

public abstract class User implements Serializable{
    
    protected String username;
    protected char[] password;
    protected TaskList taskList; 
    
    public User(String newUsername, char[] newPassword){
        
        username = newUsername;
        password = newPassword;
        taskList = new TaskList(username);
    }
    
    public String getUsername(){
        
        return username;
        
    }
    
    public char[] getPassword(){
        
        return password;
        
    }
    
}
