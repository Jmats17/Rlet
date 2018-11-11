/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rlet;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author kviro
 */
public class Reminder implements Serializable{
    
    Date date;
           
    public Reminder(String dateString){
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      
        try {
           date = format.parse(dateString); 
           //System.out.println(date); 
        } catch (ParseException e) { 
           System.out.println("Unparseable using " + format); 
        }
    }
    
    public Date getDate(){
       
        return date;
        
    }
    
    
    
}
