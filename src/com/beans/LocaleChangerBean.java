package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Locale;

/**
 * Created by user on 04.01.2016.
 */
@ManagedBean(name = "localeChanger")
@SessionScoped
public class LocaleChangerBean {
    private Locale locale;
    public void setLocale(Locale locale){
        this.locale = locale;
        FacesContext.getCurrentInstance().getViewRoot().
                setLocale(locale);
    }
    public Locale getLocale(){
        if (locale != null) {
            setLocale(locale);
            return locale;
        }else return FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }
}
