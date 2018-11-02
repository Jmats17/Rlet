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
public class Task implements Serializable{
    
    private String name;
    private String dueDate;
    private boolean completed = false;
    
    public Task(String n, String d){
        name = n;
        dueDate = d;
    }
    
    public String getName(){
        
        return name;
        
    }
    
    public String getDueDate(){
        
        return dueDate;
   
    }
    
    public boolean getStatus(){
        
        return completed;
        
    }
}
