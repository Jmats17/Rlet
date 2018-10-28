/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet_v1;

/**
 *
 * @author kviro
 */
public abstract class User {
    
    protected String username;
    protected char[] password;
    
    public User(String newUsername, char[] newPassword){
        
        username = newUsername;
        password = newPassword;
                
    }
    
    public String getUsername(){
        
        return username;
        
    }
    
    public char[] getPassword(){
        
        return password;
        
    }
    
}
