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
    
    private String name;
    private String assignedUser;
    private Date dueDate;
    private boolean completed = false;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    protected ReminderList reminderList; 
    
    public Task(String n, String dateString, String username){
        name = n;
        assignedUser = username;
        try {
           dueDate = format.parse(dateString); 
           System.out.println(dueDate); 
        } catch (ParseException e) { 
           System.out.println("Unparseable using " + format); 
        }
        reminderList = new ReminderList(dueDate);
    }
    
    public String getName(){
        
        return name;
        
    }
    
    public Date getDueDate(){
        
        return dueDate;
   
    }
    
    public boolean getStatus(){
        
        return completed;
        
    }
    
    public void MarkAsDone(){
        
        completed = true;
        //ActivityLog.addItem(this);
        
    }
    
    public ReminderList getReminderList(){
        
        return reminderList;
        
    }
    
}
