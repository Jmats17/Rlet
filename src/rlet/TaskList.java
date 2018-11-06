/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
   /* 
    public void readDataListFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(dataListFileName);
            in = new ObjectInputStream(fis);
            taskList = (ArrayList<Task>)in.readObject();
            in.close();
            if(!taskList.isEmpty()){
                System.out.println("There are tasks in the task list");
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
            out.writeObject(taskList);
            out.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
  */  
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
    
    public void addtask(Task t){
        
        taskList.add(t);
        
    }
    
    public ArrayList getList(){
        
        return taskList;
        
    }
    
    public String getListOwner(){
        
        return listOwner;
        
    }
    
}
