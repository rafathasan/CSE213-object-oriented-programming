/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import classes.user.Employee;
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
public class FindEmployee {
    
    static public ArrayList<Employee> getEmployee(){
        ArrayList<Employee> list = new ArrayList<Employee>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("EMPLOYEE")));
            list = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }catch(Exception e) {
        }
        return list;
    }
    
    static public void addEmployee(Employee emp){
        ArrayList<Employee> list = new ArrayList<Employee>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("EMPLOYEE")));
            list = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }catch(Exception e) {
        }
        list.add(emp);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("EMPLOYEE")));
            oos.writeObject(list);
            oos.close();
        }catch(Exception e) {
        }
        
    }
    
    static public void deleteEmployeeById(String id){
        ArrayList<Employee> list = new ArrayList<Employee>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("EMPLOYEE")));
            list = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }catch(Exception e) {
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equals(id)){
                list.remove(i);
            }
        }
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("EMPLOYEE")));
            oos.writeObject(list);
            oos.close();
        }catch(Exception e) {
        }
        
    }
}
