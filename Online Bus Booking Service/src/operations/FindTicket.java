/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import classes.Ticket;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafikhan
 */
public class FindTicket {
    
    static public ArrayList<Ticket> getTicket(){
        ArrayList<Ticket> list=null;
        ArrayList<Ticket> found= new ArrayList<Ticket>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("TICKET")));
            list = (ArrayList<Ticket>) ois.readObject();
            ois.close();
        }catch(Exception ex){
        }
        if(list!=null){
            for(int i=0;i<list.size();i++){
                if(list.get(i).getPayment().isDone()){
                    found.add(list.get(i));
                }
            }
        }
        
        return found;
    }
    
    static public void updateTicket(Ticket ticket){
        ArrayList<Ticket> list= new ArrayList<Ticket>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("TICKET")));
            list = (ArrayList<Ticket>) ois.readObject();
            ois.close();
        }catch(Exception ex){
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equals(ticket.getId()) && list.get(i).getDate().equals(ticket.getDate())){
                list.remove(i);
            }
        }
        list.add(ticket);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("TICKET")));
            oos.writeObject(list);
            oos.flush();
            oos.close();
        }catch(Exception ex){
        }
        
    }
    
    static public void deleteTicket(String ticketId, String date, String paymentId){
        ArrayList<Ticket> list=null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("TICKET")));
            list = (ArrayList<Ticket>) ois.readObject();
            ois.close();
        }catch(Exception ex){
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equals(ticketId)&&date.equals(list.get(i).getDate())&&paymentId.equals(list.get(i).getPayment().getId())){
                list.remove(i);
            }
        }
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("TICKET")));
            oos.writeObject(list);
            oos.flush();
            oos.close();
        }catch(Exception ex){
        }
        
    }
    
        static public void addTicket(Ticket ticket){
        ArrayList<Ticket> list=null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("TICKET")));
            list = (ArrayList<Ticket>) ois.readObject();
            ois.close();
        }catch(Exception ex){
        }
        if(list == null){
            list = new ArrayList<Ticket>();
        }
        
        list.add(ticket);
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("TICKET")));
            oos.writeObject(list);
            oos.flush();
            oos.close();
        }catch(Exception ex){
        }
        
    }
}
