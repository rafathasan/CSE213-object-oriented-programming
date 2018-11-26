/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import classes.Ticket;
import classes.user.Passenger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author rafikhan
 */
public class FindPassenger {
    
        static public ArrayList<Passenger> getPassenger(){
        ArrayList<Passenger> list = new ArrayList<Passenger>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("PASSENGER")));
            list = (ArrayList<Passenger>) ois.readObject();
            ois.close();
        }catch(Exception e) {
        }
        return list;
    }
    
        static public void addPassenger(Passenger p){
        ArrayList<Passenger> list=null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("PASSENGER")));
            list = (ArrayList<Passenger>) ois.readObject();
            ois.close();
        }catch(Exception ex){
            System.out.println("Passenger input Failed");
        }
        if(list == null){
            list = new ArrayList<Passenger>();
        }
        
        list.add(p);
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("PASSENGER")));
            oos.writeObject(list);
            oos.flush();
            oos.close();
        }catch(Exception ex){
            System.out.println("Passenger output Failed");
        }
        
    }
}
