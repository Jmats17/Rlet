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


public class UserList {

    private ArrayList<User> userList = new ArrayList<User>();
    private String dataListFileName = "dataList.ser";

    
    public UserList(){
        
        this.readDataListFile();
        
        if(userList.isEmpty() || userList == null){
            
            this.createTestUserList();
            this.writeDataListFile();
            this.readDataListFile();
            
        }
        
        this.printUserList();
    }
    
    public void readDataListFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(dataListFileName);
            in = new ObjectInputStream(fis);
            userList = (ArrayList<User>)in.readObject();
            in.close();
            if(!userList.isEmpty()){
                System.out.println("There are users in the user list");
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void writeDataListFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(dataListFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(userList);
            out.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void createTestUserList(){
        for (int i = 0; i < 4; i++){
            String testUsername = "TestUsername" + i;
            char[] testPassword = {'T', 'e', 's', 't'};
            userList.add(new Roommate(testUsername, testPassword));
        }
        System.out.println("Test UserList created");
        //System.out.println("The UserList is: "+ userList);
    }

    public void printUserList(){
        System.out.println("The UserList has these users:");
        for(int i = 0; i < userList.size(); i++){
            User currentUser = userList.get(i);
            System.out.println(currentUser.getUsername());
        }
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
