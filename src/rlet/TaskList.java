/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kviro
 */
public class TaskList implements Serializable{
    private ArrayList<Task> taskList = new ArrayList<Task>();
    private String dataListFileName = "dataList.ser";
    private String listOwner;
    
    public TaskList(String username){
        
        listOwner = username;
            
        this.createTestTaskList();
           
        
        this.printTaskList();
    }
 
    public void createTestTaskList(){
        for (int i = 0; i < 2; i++){
            String testTaskName = "TestTaskname" + i;
            String testDueDate = "2018/11/05 10:00:00";
            taskList.add(new Task(testTaskName, testDueDate, listOwner));
        }
        System.out.println("Test TaskList created");
        //System.out.println("The TaskList is: " + taskList);
    }

    public void printTaskList(){
        
        System.out.println("The user has these tasks");
        for(int i = 0; i < taskList.size(); i++){
            Task currentTask = (Task) taskList.get(i);
            System.out.println("Task Name: " + currentTask.getName());
            System.out.println("Due Date: " + currentTask.getDueDate());
            currentTask.getReminderList().printReminderList();
            System.out.println("Completed: " + currentTask.getStatus() + "\n");
        }
    }
    
    public void addTask(Task t){
        
        taskList.add(t);
        
    }
    
    public ArrayList getList(){
        
        return taskList;
        
    }
    
    public String getListOwner(){
        
        return listOwner;
        
    }
    
    public void removeTask(Task t){
        
        taskList.remove(t);
        
    }
    
}
