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
public class ResourceTracker implements Serializable{
    
    double waterRate = 0.00295; // per gallon
    double electricityRate = 0.12; //per kilowatt hour
    double totalGroceryCost = 0.00; 
    double monthlyRent = 1200.00;
    private ArrayList<User> userList;
    //hashmaps of water and electricity usage per user
    HashMap<User, Double> waterUsageTracker;
    HashMap<User, Double> electricityUsageTracker;
    ArrayList<Resource> resourceList;
    
    public ResourceTracker(ArrayList<User> listOfUsers){
        userList = listOfUsers;
        if(waterUsageTracker == null){//i think createtest method is causing nullpointer bc the userlist is null
            this.createTestWaterUsageTracker();
        }
        this.printWaterUsageTracker();
        
        if(electricityUsageTracker == null){
            this.createTestElectricityUsageTracker();
        }
        this.printElectricityUsageTracker();
        
        if(resourceList == null || resourceList.isEmpty()){
            this.createTestResourceList();
        }
        
    }
    /*
    public HashMap<User, Double> getWaterUsageTracker(){
        return waterUsageTracker;
    }
    */
    
    public void addResource(Resource r){
        resourceList.add(r);
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
    }
    
    public ArrayList<Resource> getResourceList(){
        return resourceList;
    }
    /*
    public ArrayList<User> getUsers(){
        return userList;
    }
*/
    
    public void addGroceryCost(double d){
        totalGroceryCost += d;
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
    }
    
    
    public double getRentCost(){
        return monthlyRent / (double) userList.size();
    }
    
    public double getGrocerySplit(){
        return totalGroceryCost / (double) userList.size();
    }
    
    public void createBills(User loggedInUser){
            
        Task task = new Task("Grocery split", "12/05/18 12:00:00", loggedInUser.getUsername());
        task.setCost(getGrocerySplit());
        loggedInUser.getTaskList().addTask(task);
           
        Task task2 = new Task("Rent", "11/30/18 06:00:00", loggedInUser.getUsername());
        task2.setCost(getRentCost());
        loggedInUser.getTaskList().addTask(task2);
           
        Task task3 = new Task("Water Bill", "11/30/18 05:00:00", loggedInUser.getUsername());
        task3.setCost(calculateWaterBill(loggedInUser));
        loggedInUser.getTaskList().addTask(task3);
        
        Task task4 = new Task("Electric Bill", "11/30/18 07:00:00", loggedInUser.getUsername());
        task4.setCost(calculateElectricBill(loggedInUser));
        loggedInUser.getTaskList().addTask(task4);
        
        PersistentDataCtrl.getPersistentDataCtrl().writeSerializedDataModel();
    }
   
    public HashMap<User,Double> getWaterUsageTracker(){
        return waterUsageTracker;
    }
    
    public HashMap<User,Double> getElectricityUsageTracker(){
        return electricityUsageTracker;
    }
    
    public double calculateWaterBill(User user){
        double usage = ((Double)waterUsageTracker.get(user));
        return usage * waterRate;
    }
    
    public double calculateElectricBill(User user){
        double usage = ((Double)electricityUsageTracker.get(user));
        return usage * electricityRate;
    }
    
    public void resetMonthlyUsage(){
        totalGroceryCost = 0.00;
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
            System.out.println("Electricity usage reset: " + current1.getValue());
        } 
    }
    
    public void createTestResourceList(){
        resourceList = new ArrayList<Resource>();
        resourceList.add(new Resource("TestResource", 40, 20.00, userList));
        resourceList.add(new Resource("TestResource2", 20, 30.00, userList));
        
    }
    
    public void createTestWaterUsageTracker(){
        
        waterUsageTracker = new HashMap<>();
        for(User u:userList){
            Double randomUsage = 2400 + (Math.random() * ((3000-2400) + 1));
            waterUsageTracker.put(u, randomUsage);
        }
    }
    
    public void createTestElectricityUsageTracker(){
        
        electricityUsageTracker = new HashMap<>();
        for(User u:userList){
            Double randomUsage = 700 + (Math.random() * ((1000-700) + 1));
            electricityUsageTracker.put(u, randomUsage);
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
