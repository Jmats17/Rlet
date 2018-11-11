/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author kviro
 */
public class Task implements Serializable{
    
    private String taskName;
   
    private Date dueDate;
    private Boolean completed = false;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    protected ReminderList reminderList; 
    private String assignedUser;
    
    public Task(String n, String dateString, String username){
        taskName = n;
        assignedUser = username;
        try {
           dueDate = format.parse(dateString); 
           System.out.println(dueDate); 
        } catch (ParseException e) { 
           System.out.println("Unparseable using " + format); 
        }
        reminderList = new ReminderList();
    }
    
    public String getName(){
        
        return taskName;
        
    }
    
    public Date getDueDate(){
        
        return dueDate;
   
    }
    
    public Boolean getStatus(){
        
        return completed;
        
    }
    
    public void markAsDone(){
        
        completed = true;
        
    }
    
    public ReminderList getReminderList(){
        
        return reminderList;
        
    }
    
    public String getAssignedUser(){
        
        return assignedUser;
        
    }
    
}
