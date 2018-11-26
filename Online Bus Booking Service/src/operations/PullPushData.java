/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafikhan
 */
public class PullPushData {
    static public DefaultTableModel pull(File file){
        Object obj = null;
        try {
            obj = new ObjectInputStream(new FileInputStream(file)).readObject();
        } catch (Exception ex) {
            System.out.println("Pull Operation Failed;");
            System.out.println(ex);
        }
        List lst = (List<Object[]>) obj;
        Object[][] data = new Object[lst.size()-2][];
        for(int i=1; i<lst.size();i++){
            data[i][i] = lst.get(i);
        }
        DefaultTableModel dm = new DefaultTableModel();
        //dm.setDataVector(data[][], lst.get(0));
        return null;
    }
}
