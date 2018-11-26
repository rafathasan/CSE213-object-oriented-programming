/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.UUID;
import javax.print.event.PrintJobListener;

/**
 *
 * @author rafikhan
 */
public class Bus implements Serializable{
    private String id = UUID.randomUUID().toString();
    private String company;
    private String regNo;
    private boolean ac;
    private int seats = 0;
    private int seatFare = 0;
    private float fareExtendedRatio = 1;

    public String calcTotalFare(){
        return String.valueOf(Math.round(seatFare*fareExtendedRatio));
    }
    public float getFareExtendedRatio() {
        return fareExtendedRatio;
    }

    public void setFareExtendedRatio(int fareExtendedRatio) {
        this.fareExtendedRatio = fareExtendedRatio;
    }

    

    public void setSeatFare(int SeatFare) {
        this.seatFare = SeatFare;
    }

    public int getSeatFare() {
        return seatFare;
    }
    private boolean inService = false;
    
    public String getCompany() {
        return company;
    }
    public void setInService(boolean inService) {
        this.inService = inService;
    }

    public boolean isInService() {
        return inService;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Bus() {
    }
    
    public Bus(String company, String regNo, int seats, boolean ac,boolean inService,String id, int seatFare, float fareExtendedRatio) {
        this.company = company;
        this.regNo = regNo;
        this.ac = ac;
        this.seats = seats;
        this.inService = inService;
        if(id==null || id.equals("")){
            this.id = UUID.randomUUID().toString();
        }else{
            this.id = id;
        }
        this.seatFare = seatFare;
        this.fareExtendedRatio = fareExtendedRatio;
    }
    

    public String getId() {
        return id;
    }

    public String getRegNo() {
        return regNo;
    }

    public boolean isAc() {
        return ac;
    }

    public int getSeats() {
        return seats;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }


    public void setSeats(int seats) {
        this.seats = seats;
    }
    
}
