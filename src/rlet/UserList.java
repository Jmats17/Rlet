/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.util.*;
import java.io.*;
/**
 *
 * @author kviro
 */


public class UserList implements Serializable{

    private ArrayList<User> userList = new ArrayList<User>();
    //private ResourceTracker resourceTracker;
    
    public UserList(){
        
        if(userList.isEmpty() || userList == null){
            
            this.createTestUserList();
            
        }
        //resourceTracker = new ResourceTracker(userList);
        
    }
    /*
    public ResourceTracker getResourceTracker(){
        return resourceTracker;
    }
    */
    public void createTestUserList(){
       
        for (int i = 0; i < 3; i++){
            String testUsername = "Test" + i;
            char[] testPassword = {'T', 'e', 's', 't'};
            userList.add(new Roommate(testUsername, testPassword));
        }
        System.out.println("Test UserList created");
        
        
    }

    public void printUserList(){
        System.out.println("The UserList has these users:");
        for(int i = 0; i < userList.size(); i++){
            User currentUser = userList.get(i);
            System.out.println(currentUser.getUsername());
            currentUser.getTaskList().printTaskList();
        }
    }
    
    public void addUser(User u){
        
        userList.add(u);
        
    }
    
    public ArrayList getList(){
        
        return userList;
        
    }
    
    public User authenticate(String testUsername, char[] testPassword){
        
        boolean usernameValid = false;
        boolean passwordValid = false;
        
        for(User u: userList){
            String passwordToTest = new String(testPassword);
            
            if(testUsername.equals(u.getUsername())){
                
                System.out.println("Username found: " + u.getUsername());
                usernameValid = true;
                
                if(passwordToTest.equals(new String(u.getPassword()))){
                    passwordValid = true;
                    return u;
                }
               
            }
            
        }
        return null;
        
    }
    
    
}
