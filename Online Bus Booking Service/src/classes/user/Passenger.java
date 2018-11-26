/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rafikhan
 */
public class Passenger extends User implements Serializable{
    private final String user = "Passeger";
    
    public String getUser() {
        return user;
    }
    public Passenger(){
        
    }

    public Passenger(String name, String cell, String email, String address, String username, String password) {
        super(name, cell, email, address, username, password);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCell() {
        return cell;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCell(String cell) {
        this.cell = cell;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }
}
