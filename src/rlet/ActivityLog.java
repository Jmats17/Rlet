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
public class ActivityLog implements Serializable{
    
    ArrayList<Task> taskLog;
    
    public ActivityLog(){
        
        taskLog = new ArrayList<Task>();
        
    }
    
    public void addToLog(Task t){
        
        taskLog.add(t);
        
    }
    
    public ArrayList<Task> getLog(){
        return taskLog;
    }
    
    
    
}
