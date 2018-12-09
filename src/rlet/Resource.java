/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kviro
 */
public class Resource implements Serializable{
    
    private String name;
    private double totalNumber;
    private double totalResourceCost;
    private HashMap<User, Double> usage;
    private ArrayList<User> userList;
    
    public Resource(String itemName, double startAmount, double totalCost, ArrayList<User> u){
       //need way to get userlist without causing infinite loop upon .ser file deletion/re-creation
       name = itemName;
       userList = u;
       totalResourceCost = totalCost;
       totalNumber = startAmount;
       usage = new HashMap<User, Double>();
       for(User user: userList){
           
           usage.put(user, 0.00);
       }

    }
    
    public String getName(){
        return name;
    }
    
    public HashMap<User,Double> getUsage(){
        return usage;
    }
    
    public double getAmountRemaining(){
        return totalNumber;
    }
    public double getTotalResourceCost(){
        return totalResourceCost;
    }
    
    public void addResource(double d, double c){
        totalNumber += d;
        totalResourceCost += c;
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
    }
    
    public void useResource(User u, double d){
        totalNumber -= d;
        usage.put(u, usage.get(u) + d);
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
    }
    
    public double calculateCostToUser(User u){
        return ((usage.get(u) / totalNumber) * totalResourceCost);
    }
}
