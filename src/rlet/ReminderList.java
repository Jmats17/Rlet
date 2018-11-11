/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kviro
 */
public class ReminderList implements Serializable{
    
    private ArrayList<Reminder> reminderList = new ArrayList<Reminder>();
    
    public ReminderList(){
        
        this.createTestReminderList();
           
        this.printReminderList();
        
    }
    public void createTestReminderList(){
        for (int i = 0; i < 1; i++){
       
            String testDueDate = "05/11/2018 09:00:00";
            addReminder(testDueDate);
        }
        System.out.println("Test Reminder created");
        //System.out.println("The TaskList is: " + taskList);
    }
    
    public void printReminderList(){
        
        System.out.println("The Task has these reminders");
        for(int i = 0; i < reminderList.size(); i++){
            Reminder currentReminder = (Reminder) reminderList.get(i);
            System.out.println("Reminder set for: " + currentReminder.getDate());
        }
    }
    
    public void addReminder(String dateString){
        
        reminderList.add(new Reminder(dateString));
        //PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
        
    }
    
    public void removeReminder(Reminder r){
        
        reminderList.remove(r);
        
    }
    
    public ArrayList<Reminder> getList(){
        
        return reminderList;
        
    }
}
