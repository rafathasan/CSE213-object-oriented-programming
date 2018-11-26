/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import classes.user.Admin;
import classes.user.Employee;
import classes.user.Passenger;
import classes.user.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author rafikhan
 */
public class FindUser {
    static public User FindUserById(String userId){
        ArrayList<User> list = null;
        ArrayList<Admin> ad = null;
        ArrayList<Employee> em = null;
        ArrayList<Passenger> pa = null;
        try {
            ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(new File("ADMIN")));
            ad = (ArrayList<Admin>) ois1.readObject();
        } catch (Exception e) {
        }
        
        try {
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(new File("EMPLOYEE")));
            em = (ArrayList<Employee>) ois2.readObject();
        } catch (Exception e) {
        }
        
        try{
            ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream(new File("PASSENGER")));
            pa = (ArrayList<Passenger>) ois3.readObject();
        }catch(Exception ex){
        }
        
        list = new ArrayList<User>();
        if(ad!=null){
            for(Admin temp: ad){
                list.add(temp);
            }
        }
        if(em!=null){
            for(Employee temp: em){
                list.add(temp);
            }
        }
        if(pa!=null){
            for(Passenger temp: pa){
                list.add(temp);
            }
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equals(userId)){
                return list.get(i);
            }
        }
                
        return null;
    }

    static public Boolean changePasswordById(String userId, String old, String replace){
        ArrayList<User> list = null;
        ArrayList<Admin> ad = null;
        ArrayList<Employee> em = null;
        ArrayList<Passenger> pa = null;
        boolean succes = false;
        try {
            ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(new File("ADMIN")));
            ad = (ArrayList<Admin>) ois1.readObject();
        } catch (Exception e) {
        }
        
        try {
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(new File("EMPLOYEE")));
            em = (ArrayList<Employee>) ois2.readObject();
        } catch (Exception e) {
        }
        
        try{
            ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream(new File("PASSENGER")));
            pa = (ArrayList<Passenger>) ois3.readObject();
        }catch(Exception ex){
        }
        
        list = new ArrayList<User>();
        
        if(ad!=null){
            for(int i=0;i<ad.size();i++){
                if(ad.get(i).getId().equals(userId)){
                    succes = ad.get(i).changePassword(old, replace);
                }
            }
        }
        if(em!=null){
            for(int i=0;i<em.size();i++){
                if(em.get(i).getId().equals(userId)){
                    succes = em.get(i).changePassword(old, replace);
                }
            }
        }
        if(pa!=null){
            for(int i=0;i<pa.size();i++){
                if(pa.get(i).getId().equals(userId)){
                    succes = pa.get(i).changePassword(old, replace);
                }
            }
        }
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("ADMIN")));
            oos.writeObject(ad);
            oos.close();
        } catch (Exception e) {
        }
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("EMPLOYEE")));
            oos.writeObject(em);
            oos.close();
        } catch (Exception e) {
        }
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("PASSENGER")));
            oos.writeObject(pa);
            oos.close();
        }catch(Exception ex){
        }
        
        
        return succes;
    }
    
    
    static public User FindUserByEmail(String email){
        ArrayList<User> list = null;
        ArrayList<Admin> ad = null;
        ArrayList<Employee> em = null;
        ArrayList<Passenger> pa = null;
        try {
            ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(new File("ADMIN")));
            ad = (ArrayList<Admin>) ois1.readObject();
        } catch (Exception e) {
        }
        
        try {
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(new File("EMPLOYEE")));
            em = (ArrayList<Employee>) ois2.readObject();
        } catch (Exception e) {
        }
        
        try{
            ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream(new File("PASSENGER")));
            pa = (ArrayList<Passenger>) ois3.readObject();
        }catch(Exception ex){
        }
        
        list = new ArrayList<User>();
        if(ad!=null){
            for(Admin temp: ad){
                list.add(temp);
            }
        }
        if(em!=null){
            for(Employee temp: em){
                list.add(temp);
            }
        }
        if(pa!=null){
            for(Passenger temp: pa){
                list.add(temp);
            }
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getEmail().equals(email)){
                return list.get(i);
            }
        }
                
        return null;
    }
}
