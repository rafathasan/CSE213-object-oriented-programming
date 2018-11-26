/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import classes.Bus;
import classes.BusSchedule;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rafikhan
 */
public class FindBusByID {
    
    static public Bus byId(String id){
        ArrayList<Bus> list= new ArrayList<Bus>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        for(int i=0; i<list.size();i++){
            if(list.get(i).getId().equals(id)){
                return list.get(i);
            }
        }
        return null;
    }
    
    static public Bus byReg(String reg){
        ArrayList<Bus> list= new ArrayList<Bus>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        for(int i=0; i<list.size();i++){
            if(list.get(i).getRegNo().equals(reg)){
                return list.get(i);
            }
        }
        return null;
    }
    
    static public String getBusId(String regNo){
        ArrayList<Bus> list= new ArrayList<Bus>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        for(int i=0; i<list.size();i++){
            if(list.get(i).getRegNo().equals(regNo)){
                return list.get(i).getId();
            }
        }
        return "";
    }
    
    
    
    static public Bus getBusByReg(String id){
        ArrayList<Bus> list= new ArrayList<Bus>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        for(Bus temp:list){
            if(temp.getRegNo().equals(id)){
                return temp;
            }
        }
        return null;
    }
    
    static public String getTotalFareById(String id){
        ArrayList<Bus> list=null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        for(int i=0; i<list.size();i++){
            if(list.get(i).getId().equals(id)){
                return list.get(i).calcTotalFare();
            }
        }
        return "";
    }
    
    static public String getTotalFareByReg(String reg){
        ArrayList<Bus> list=null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        for(int i=0; i<list.size();i++){
            if(list.get(i).getRegNo().equals(reg)){
                return list.get(i).calcTotalFare();
            }
        }
        return "";
    }
    
    static public int getSeatByReg(String reg){
        ArrayList<Bus> list=null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        for(int i=0; i<list.size();i++){
            if(list.get(i).getRegNo().equals(reg)){
                return list.get(i).getSeats();
            }
        }
        return 0;
    }
    
    static public int getSeatById(String id){
        ArrayList<Bus> list=null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        for(int i=0; i<list.size();i++){
            if(list.get(i).getRegNo().equals(id)){
                return list.get(i).getSeats();
            }
        }
        return 0;
    }

    static public ArrayList<Bus> getBuses(){
        ArrayList<Bus> list= new ArrayList<Bus>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("BUS")));
            list = (ArrayList<Bus>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data Retrive Failed");
        }
        return list;
    }
}
