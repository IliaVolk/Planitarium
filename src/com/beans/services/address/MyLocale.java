package com.beans.services.address;

import java.util.Locale;

/**
 * Created by user on 04.01.2016.
 */
public class MyLocale {
    private Locale locale;
    MyLocale(Locale locale){
        this.locale = locale;
    }
    public Locale getLocale(){
        return locale;
    }
    MyLocale(){}
    public String getCountry(){
        return locale.getCountry();
    }
    public String getDisplayCountry(){
        return locale.getDisplayCountry();
    }
}
