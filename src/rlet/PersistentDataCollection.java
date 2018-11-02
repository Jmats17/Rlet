/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.Serializable;

/**
 *
 * @author kviro
 */
public class PersistentDataCollection implements Serializable{
    
    private UserList theUserList;
    
    // All other persistent data will go below here
    
    public PersistentDataCollection(){
        if(theUserList == null){
            theUserList = new UserList();
        }
    }
    
    public UserList getUserList(){
        return theUserList;
    }
    
}
