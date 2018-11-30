/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.Serializable;
import javafx.collections.ObservableList;

/**
 *
 * @author kviro
 */
public class PersistentDataCollection implements Serializable{
    
    private UserList theUserList;
    private ActivityLog theActivityLog;
    private CostTracker theCostTracker;
    
    public PersistentDataCollection(){
        if(theUserList == null){
            theUserList = new UserList();
        }
        
        if(theActivityLog == null){
            theActivityLog = new ActivityLog();
        }
        
        if(theCostTracker == null){
            theCostTracker = new CostTracker();
        }

    }
    
    public UserList getUserList(){
        return theUserList;
    }
    
    public ActivityLog getActivityLog(){
        return theActivityLog;
    }
    
    public CostTracker getCostTracker(){
        return theCostTracker;
    }
    
}
