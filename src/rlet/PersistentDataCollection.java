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
    private ResourceTracker theResourceTracker;
    
    public PersistentDataCollection(){
        if(theUserList == null){
            theUserList = new UserList();
        }
        
        if(theActivityLog == null){
            theActivityLog = new ActivityLog();
        }
        
        if(theResourceTracker == null){
            theResourceTracker = new ResourceTracker(theUserList.getList());
        }
        
    }
    
    public UserList getUserList(){
        return theUserList;
    }
    
    public ActivityLog getActivityLog(){
        return theActivityLog;
    }
    
    public ResourceTracker getResourceTracker(){
        return theResourceTracker;
    }

}
