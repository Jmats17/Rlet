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
    
    ArrayList<Task> TaskLog;
    
    public ActivityLog(){
        
        TaskLog = new ArrayList<Task>();
        
    }
    
    public void addItem(Task t){
        
        //TaskLog.add(t);
        
    }
    
}
