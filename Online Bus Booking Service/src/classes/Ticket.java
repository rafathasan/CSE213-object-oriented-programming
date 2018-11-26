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
public class Ticket implements Serializable{
    private String Schuduleid ;
    private String date;
    private String BusReg = "";
    private String userId;
    private int person;
    private int fare = 0;
    private Payment payment = new Payment();
    
    public boolean isPaymentDone(){
        return payment.isDone();
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
    
    public int getPerson() {
        return person;
    }

    public int getFare() {
        return fare;
    }

    
    public Ticket(String Schuduleid,String userId, String date, String BusReg, int person, int fare) {
        this.userId = userId;
        this.date = date;
        this.BusReg = BusReg;
        this.person = person;
        this.fare = fare;
        this.Schuduleid = Schuduleid;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }



    public String getDate() {
        return date;
    }

    public String getBusReg() {
        return BusReg;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return Schuduleid;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setBusReg(String BusReg) {
        this.BusReg = BusReg;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    
}
