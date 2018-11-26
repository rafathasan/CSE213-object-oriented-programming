/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.user;

import com.github.lgooddatepicker.components.DatePicker;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author rafikhan
 */
public class Employee extends User implements Serializable{
    private final String user = "Employee";
    private int salaryInHour;
    private int hour;
    private int days;
    private String lastPayroll = getToday();

    static public String getToday(){
        DatePicker date = new DatePicker();
        date.setDateToToday();
        return date.getText();
    }
    public String getLastPayroll() {
        return lastPayroll;
    }

    public void setLastPayroll(String lastPayroll) {
        this.lastPayroll = lastPayroll;
    }



    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHour() {
        return hour;
    }

    public int getDays() {
        return days;
    }

    public int getSalaryInHour() {
        return salaryInHour;
    }

    public void setSalaryInHour(int salaryInHour) {
        this.salaryInHour = salaryInHour;
    }
    
    

    public String getUser() {
        return user;
    }
    
    public Employee(){
        
    }

    public Employee(String name, String cell, String email, String address, String username, String password, int salaryInHour, int hour, int days, String id) {
        super(name, cell, email, address, username, password);
        this.salaryInHour = salaryInHour;
        this.hour = hour;
        this.days = days;
        if(id==null||id.equals("")){
            super.setId(UUID.randomUUID().toString());
        }else{
            super.setId(id);
        }
    }
    
    public Employee(String name, String cell, String email, String address, String username, int salaryInHour, int hour, int days, String id, String password, String lastPayroll) {
        super(name, cell, email, address, username);
        super.setDigestPassword(password);
        this.salaryInHour = salaryInHour;
        this.hour = hour;
        this.days = days;
        if(id!=null||id.equals("")){
            super.setId(id);
        }else{
            super.setId(UUID.randomUUID().toString());
        }
        this.lastPayroll = lastPayroll;
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
