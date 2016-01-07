package com.beans.services.address;

import com.beans.Messages;

import java.util.Locale;

/**
 * Created by user on 04.01.2016.
 */
public class UkraineLocale extends MyLocale{
    UkraineLocale(){}
    Locale locale = new Locale("ua");
    @Override
    public Locale getLocale(){
        return locale;
    }
    String country = "ua";
    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getDisplayCountry() {
        return Messages.getString("ukraine");
    }
}
