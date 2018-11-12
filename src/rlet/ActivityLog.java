/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author kviro
 */
public class ActivityLog implements Serializable{
    
    private ArrayList<Task> activityLog;
    
    public ActivityLog(){
        
        activityLog = new ArrayList<Task>();
        
    }
    
    public void addItem(Task t){
        
        activityLog.add(t);
        
    }
    
    public ArrayList<Task> getActivityLog() {
       
        return activityLog;
    }
    
    
    
}
