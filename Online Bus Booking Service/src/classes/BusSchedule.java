/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author rafikhan
 */
public class BusSchedule implements Serializable{
    private String id = UUID.randomUUID().toString();
    private String busReg;
    private String start;
    private boolean active=false;
    private int fare;
    private int fareWithProfit;

    public void setDepartCity(String departCity) {
        this.departCity = departCity;
    }

    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }

    public String getDepartCity() {
        return departCity;
    }

    public String getArriveCity() {
        return arriveCity;
    }
    private String end;
    private String departCity;
    private String arriveCity;
    private String arriving;
    private String depart;

    public BusSchedule(String busReg, String start, String end, String departCity, String arriveCity, String arriving, String depart, int seatAvailable, int fare, int fareWithProfit,String id, boolean active) {
        this.busReg = busReg;
        this.start = start;
        this.end = end;
        this.departCity = departCity;
        this.arriveCity = arriveCity;
        this.arriving = arriving;
        this.depart = depart;
        this.seatAvailable = seatAvailable;
        this.fare = fare;
        this.fareWithProfit = fareWithProfit;
        if(id==null || id.equals("")){
            this.id = UUID.randomUUID().toString();
        }else{
            this.id =  id;
        }
        this.active = active;
    }
    
    public BusSchedule(String busReg, String start, String end, String departCity, String arriveCity, String arriving, String depart, int seatAvailable,String id, boolean active) {
        this.busReg = busReg;
        this.start = start;
        this.end = end;
        this.departCity = departCity;
        this.arriveCity = arriveCity;
        this.arriving = arriving;
        this.depart = depart;
        this.seatAvailable = seatAvailable;
        if(id==null || id.equals("")){
            this.id = UUID.randomUUID().toString();
        }else{
            this.id =  id;
        }
        this.active = active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }


    private int seatAvailable;

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }


    public String getId() {
        return id;
    }

    public void setBusReg(String busReg) {
        this.busReg = busReg;
    }

    public String getBusReg() {
        return busReg;
    }


    public String getArriving() {
        return arriving;
    }

    public String getDepart() {
        return depart;
    }


    public void setArriving(String arriving) {
        this.arriving = arriving;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }
    
}
