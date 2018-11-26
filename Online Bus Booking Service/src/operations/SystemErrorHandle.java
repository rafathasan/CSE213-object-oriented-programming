/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafikhan
 */
public class SystemErrorHandle {
    static public void reportError(Exception ex){
        ArrayList<Exception> list = null;
        if(new File("ERROR").exists()){
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(new FileInputStream(new File("ERROR")));
                list = (ArrayList<Exception>) ois.readObject();
                ois.close();
                list.add(ex);
            } catch (Exception ex1) {  
            }
        }else{
            list = new ArrayList<Exception>();
            list.add(ex);
        }
        
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("ERROR")));
            oos.writeObject(list);
            oos.flush();
            oos.close();
        } catch (Exception e) {
        }
        
        
    }
}
