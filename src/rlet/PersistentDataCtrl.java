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
/**
 *
 * @author kviro
 */
public class PersistentDataCtrl {
    
    private static PersistentDataCtrl thePersistentDataCntl;
    private PersistentDataCollection thePersistentDataCollection;
    private final String EXTERNAL_DATA_PATH = "";
    private final String DATA_FILE_NAME = "AppData.ser";
    
    private PersistentDataCtrl(){
        readSerializedDataModel(); 
        if(thePersistentDataCollection == null){
            thePersistentDataCollection = new PersistentDataCollection();
            writeSerializedDataModel();
            readSerializedDataModel(); 
        }
    }
    
    public static PersistentDataCtrl getPersistentDataCtrl(){
        if(thePersistentDataCntl == null){
            thePersistentDataCntl = new PersistentDataCtrl();
        }
        return thePersistentDataCntl;
    }
    
    public PersistentDataCollection getPersistentDataCollection(){
        return thePersistentDataCollection;
    }
    
    public void readSerializedDataModel(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        String filePath = EXTERNAL_DATA_PATH+DATA_FILE_NAME;
        try {
            fis = new FileInputStream(filePath);
            in = new ObjectInputStream(fis);
            thePersistentDataCollection = (PersistentDataCollection) in.readObject();
            in.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    
     public void writeSerializedDataModel(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        String filePath = EXTERNAL_DATA_PATH+DATA_FILE_NAME;
        try{
            fos = new FileOutputStream(filePath);
            out = new ObjectOutputStream(fos);
            out.writeObject(thePersistentDataCollection);
            out.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
