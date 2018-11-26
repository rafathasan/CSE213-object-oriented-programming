/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author rafikhan
 */
public class ReadCityFile {
    static public Vector<String> read(){
        Vector<String> list=new Vector<String>();
        try{
            Scanner sc = new Scanner(new File("cities.txt"));
            while(sc.hasNextLine()){
                list.add(sc.nextLine());
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ReadCityFile Operation: Data Retrive Failed");
        }

        return list;
    }
}
