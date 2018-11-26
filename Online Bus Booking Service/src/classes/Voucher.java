/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import operations.ShortUUID;

/**
 *
 * @author rafikhan
 */
public class Voucher implements Serializable{
    
    private int amount;

    /**
     * Get the value of amount
     *
     * @return the value of amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set the value of amount
     *
     * @param amount new value of amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    private String couponCode;//=ShortUUID.UUID();

    public Voucher(int amount, String couponCode) {
        this.amount = amount;
        if(couponCode.equals("")||couponCode.equals(null)){
            this.couponCode = ShortUUID.UUID();
        }
        else{
            this.couponCode = couponCode;
        }
    }

    /**
     * Get the value of couponCode
     *
     * @return the value of couponCode
     */
    public String getCouponCode() {
        return couponCode;
    }

}
