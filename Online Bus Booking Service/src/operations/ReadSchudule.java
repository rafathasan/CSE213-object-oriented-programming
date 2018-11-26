/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import classes.BusSchedule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rafikhan
 */
public class ReadSchudule {
    
    static public boolean incrementSchudule(String ScheduleId){
            ArrayList<BusSchedule> list = null;
                try{
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("SCHEDULE")));
                    list = (ArrayList<BusSchedule>) ois.readObject();
                    ois.close();
                }catch(Exception ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Data Retrive Failed");
                }
                
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getId().equals(ScheduleId)){
                        if(list.get(i).getSeatAvailable()>0)
                            list.get(i).setSeatAvailable(list.get(i).getSeatAvailable()-1);
                        else
                            return false;
                    }
                }
                
                if(list!=null){
                    try{
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("SCHEDULE")));
                        oos.writeObject(list);
                        oos.flush();
                        oos.close();
                        return true;
                    }catch(Exception ex){
                        if(JOptionPane.showOptionDialog(null, "Send Error report", "File write Exception", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==JOptionPane.OK_OPTION){
                            SystemErrorHandle.reportError(ex);
                        return false;
                        }
                    }
                }
        return false;
                
    }
    
    static public boolean decrementSchudule(String ScheduleId){
            ArrayList<BusSchedule> list = null;
                try{
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("SCHEDULE")));
                    list = (ArrayList<BusSchedule>) ois.readObject();
                    ois.close();
                }catch(Exception ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Data Retrive Failed");
                }
                
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getId().equals(ScheduleId)){
                        if(list.get(i).getSeatAvailable()>0)
                            list.get(i).setSeatAvailable(list.get(i).getSeatAvailable()+1);
                        else
                            return false;
                    }
                }
                
                if(list!=null){
                    try{
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("SCHEDULE")));
                        oos.writeObject(list);
                        oos.flush();
                        oos.close();
                        return true;
                    }catch(Exception ex){
                        if(JOptionPane.showOptionDialog(null, "Send Error report", "File write Exception", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==JOptionPane.OK_OPTION){
                            SystemErrorHandle.reportError(ex);
                        return false;
                        }
                    }
                }
        return false;
                
    }
    
    
    
    
    
    static public BusSchedule FindSchuduleById(String ScheduleId){
            ArrayList<BusSchedule> list = null;
                try{
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("SCHEDULE")));
                    list = (ArrayList<BusSchedule>) ois.readObject();
                    ois.close();
                }catch(Exception ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Data Retrive Failed");
                }
                
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getId().equals(ScheduleId)){
                        return list.get(i);
                    }
                }
        return null;
    }
        
    static public ArrayList<BusSchedule> getBusSchudule(){
        ArrayList<BusSchedule> list = new ArrayList<>();
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("SCHEDULE")));
                list = (ArrayList<BusSchedule>) ois.readObject();
                ois.close();
            }catch(Exception ex){
            }
        return list;
    }
}
