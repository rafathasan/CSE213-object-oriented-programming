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
public class Payment implements Serializable{
    private String id = UUID.randomUUID().toString();
    private boolean done = false;

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }
    private String ticketId;
    private String amount;

    public Payment(String amount) {
        this.amount = amount;
    }
        
    public Payment(String id, String amount) {
        this.id = id;
        this.amount = amount;
    }

    public Payment(boolean done, String amount) {
        this.done = done;
        this.amount = amount;
    }
    public Payment() {
    }

    public String getId() {
        return id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getAmount() {
        return amount;
    }
}
