/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kviro
 */
public class CostTracker implements Serializable{
    
    double waterRate = 0.00295; // per gallon
    double electricityRate = 0.12; //per kilowatt hour
    double monthlyGroceryCost = 320.00; 
    double monthlyRent = 1200.00;
    private ArrayList<User> userList;
    
    //hashmaps of water and electricity usage per user
    HashMap<String, Double> waterUsageTracker;
    HashMap<String, Double> electricityUsageTracker;
    
    public CostTracker(){
        userList = PersistentDataCtrl.getPersistentDataCtrl().getPersistentDataCollection().getUserList().getList();
        
        if(waterUsageTracker.isEmpty() || waterUsageTracker == null){
            
            this.createTestWaterUsageTracker();
            
        }
        this.printWaterUsageTracker();
        
        if(electricityUsageTracker.isEmpty() || electricityUsageTracker == null){
            
            this.createTestElectricityUsageTracker();
            
        }
        this.printElectricityUsageTracker();
        
    }
    
    
    public void addGroceryCost(double d){
        monthlyGroceryCost += d;
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
    }
    
    public void splitGroceryCost(){
        for(User u:userList){
            Task task = new Task("Grocery split", "12/05/18 12:00:00", u.getUsername());
            u.getTaskList().addTask(task);
            u.getTaskList().printTaskList();
        }  
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
    }
    
    public void splitRent(){
        for(User u:userList){
            Task task = new Task("Rent", "11/30/18 06:00:00", u.getUsername());
            u.getTaskList().addTask(task);
            u.getTaskList().printTaskList();
        }  
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
    }
    
    public double calculateWaterBill(String username){
        double usage = ((Double)waterUsageTracker.get(username)).doubleValue();
        return usage * waterRate;
    }
    
    public double calculateElectricityBill(String username){
        double usage = ((Double)electricityUsageTracker.get(username)).doubleValue();
        return usage * electricityRate;
    }
    
    public void resetMonthlyUsage(){
        
        monthlyGroceryCost = 0.00;
        
        Set set = waterUsageTracker.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry current = (Map.Entry)i.next();
            current.setValue(new Double(0.00));
            System.out.println("Water usage reset:" + current.getValue());
        } 
        
        Set set2 = electricityUsageTracker.entrySet();
        Iterator j = set.iterator();
        while(j.hasNext()) {
            Map.Entry current1 = (Map.Entry)j.next();
            current1.setValue(new Double(0.00));
            System.out.println("Water usage reset: " + current1.getValue());
        } 
    }
    
    public void createTestWaterUsageTracker(){
        waterUsageTracker = new HashMap<>();
        for(User u:userList){
            Double randomUsage = 2400 + (Math.random() * ((3000-2400) + 1));
            waterUsageTracker.put(u.getUsername(), randomUsage);
        }
    }
    
    public void createTestElectricityUsageTracker(){
        electricityUsageTracker = new HashMap<>();
        for(User u:userList){
            Double randomUsage = 700 + (Math.random() * ((1000-700) + 1));
            electricityUsageTracker.put(u.getUsername(), randomUsage);
        }
    }
    
    public void printWaterUsageTracker(){
        Set set = waterUsageTracker.entrySet();
        Iterator i = set.iterator();
       
        while(i.hasNext()) {
            Map.Entry current = (Map.Entry)i.next();
            System.out.print(current.getKey() + ": ");
            System.out.println(current.getValue());
        } 
    }
    
    public void printElectricityUsageTracker(){
        Set set = electricityUsageTracker.entrySet();
        Iterator i = set.iterator();
       
        while(i.hasNext()) {
            Map.Entry current = (Map.Entry)i.next();
            System.out.print(current.getKey() + ": ");
            System.out.println(current.getValue());
        } 
    }
    
    
}
