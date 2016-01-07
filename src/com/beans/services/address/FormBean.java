package com.beans.services.address;

import com.beans.LocaleChangerBean;
import com.beans.UserBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.*;

/**
 * Created by user on 04.01.2016.
 */
@ManagedBean(name = "form")
@SessionScoped
public class FormBean implements Serializable{
    @ManagedProperty(value = "#{localeChanger}")
    LocaleChangerBean localeChanger;
    /////////////////////debug
    @ManagedProperty(value = "#{user}")
    UserBean user;

    public void setUser(UserBean user) {
        this.user = user;
    }
    ///////////////////////
    public void setLocaleChanger(LocaleChangerBean localeChanger) {
        this.localeChanger = localeChanger;
    }
    private String country;
    ArrayList<MyLocale> countries;
    @PostConstruct
    public void init(){
        country = localeChanger.getLocale().getCountry();
        countries = new ArrayList<>(Arrays.asList(
                new MyLocale(Locale.US),
                new UkraineLocale()
        ));
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        user.setName(country);
        System.out.println("*******username " + country);
        this.country = country;
    }

    public List getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<MyLocale> countries) {
        this.countries = countries;
    }

    public void countryChanged(ValueChangeEvent event){
        ///debug
        System.out.println("*****valueChangeListener");
        StringBuilder builder = new StringBuilder(event.getNewValue().toString());
        ///////////////
        for (MyLocale locale : countries){
            /*debug*/builder.append("  ").append(locale.getCountry());
            if (locale.getCountry().equals(event.getNewValue().toString())){
                builder.append(locale.getCountry()).append(" equals ").append(event.getNewValue());
                localeChanger.setLocale(locale.getLocale());
                //FacesContext.getCurrentInstance().getViewRoot().setLocale(locale.getLocale());
                break;
            }
        }
        /*debug*/user.setName(builder.toString());
        /*debug*/System.out.println("***********"+builder.toString());
    }
}
