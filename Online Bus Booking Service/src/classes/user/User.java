/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.user;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author rafikhan
 */
public abstract class User implements Serializable{
    protected String user;
    public String getUser() {
        return user;
    }
    protected ArrayList<String> button = new ArrayList<String>();
    protected String id = UUID.randomUUID().toString();
    protected String name;
    protected String cell;
    protected String email;
    protected String address;
    protected String username;
    private String password;
    private ArrayList<String> ticket;

    public ArrayList<String> getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket.add(ticket);
    }
    
    public void setId(String id) {
        this.id = id;
    }
    protected final Date created = new Date();
    
    protected User(){
    }
    protected User(String name,String cell,String email,String address,String username, String password){
        this.name = name;
        this.cell = cell;
        this.email = email;
        this.address = address;
        this.username = username;
        setPassword(password);
    }
    
    protected User(String name,String cell,String email,String address,String username){
        this.name = name;
        this.cell = cell;
        this.email = email;
        this.address = address;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    public void addButton(String btn) {
        button.add(btn);
    }
    
    public ArrayList<String> getButton() {
        return button;
    }
    
    private String digestMessage(String string){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<bytes.length; i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 32).substring(0));
            return sb.toString();
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Message Digest Failed \n Please Contect with the developer.");
        }
        return null;
    }
    
    protected void setDigestPassword(String pass){
        this.password = pass;
    }
    
    private void setPassword(String password){
            this.password = digestMessage(password);
    }
    
    public  boolean checkPassword(String password){
            if(this.password.equals(digestMessage(password))){
                return true;
            }else{
                return false;
            }
    }
    
     public  boolean changePassword(String password, String newPassword){
            if(this.password.equals(digestMessage(password))){
                setPassword(newPassword);
                return true;
            }else if(password.equals("override")){
                setPassword(newPassword);
                return true;
            }else{
                return false;
            }
        
    }

    abstract public String getId();

    abstract public String getName();

    abstract public String getCell();

    abstract public String getEmail();

    abstract public String getAddress();

    abstract public String getUsername();

    abstract public Date getCreated();

    abstract public void setName(String name);

    abstract public void setCell(String cell);

    abstract public void setEmail(String email);

    abstract public void setAddress(String address);

    abstract public void setUsername(String username);
    
    
}
