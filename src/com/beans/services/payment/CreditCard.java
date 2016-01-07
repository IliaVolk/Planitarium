package com.beans.services.payment;

import java.io.Serializable;

/**
 * Created by user on 03.01.2016.
 */
public class CreditCard implements Serializable {
    String number;
    CreditCard(String number){
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
