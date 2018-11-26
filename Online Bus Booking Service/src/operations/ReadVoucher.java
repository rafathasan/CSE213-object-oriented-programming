/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import classes.Voucher;
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
public class ReadVoucher {
    static public ArrayList<Voucher> readVoucher(){
        ArrayList<Voucher> list = null;
        ObjectInputStream ois;
        try{
            ois = new ObjectInputStream(new FileInputStream(new File("VOUCHER")));
            list = (ArrayList<Voucher>) ois.readObject();
            ois.close();
            return list;
        }catch(Exception ex){
            return list;
        }
    }
    
    static public void FindAndDeleteVoucher(String text){
        ArrayList<Voucher> list = new ArrayList<Voucher>();
        ObjectInputStream ois;
        try{
            ois = new ObjectInputStream(new FileInputStream(new File("VOUCHER")));
            list = (ArrayList<Voucher>) ois.readObject();
            ois.close();
            for(int i=0; i<list.size();i++){
                if(text.equals(list.get(i).getCouponCode())){
                    Voucher temp = list.get(i);
                    list.remove(i);
                }
            }
        }catch(Exception ex){
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("VOUCHER")));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
        }
    }
    
    static public Voucher FindVoucher(String text){
        ArrayList<Voucher> list = new ArrayList<Voucher>();
        ObjectInputStream ois;
        try{
            ois = new ObjectInputStream(new FileInputStream(new File("VOUCHER")));
            list = (ArrayList<Voucher>) ois.readObject();
            ois.close();
            for(int i=0; i<list.size();i++){
                if(text.equals(list.get(i).getCouponCode())){
                    return list.get(i);
                }
            }
        }catch(Exception ex){
            return null;
        }
        return null;
    }
}
