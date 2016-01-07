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
    public void setLocale(Locale locale){
        FacesContext.getCurrentInstance().getViewRoot().
                setLocale(locale);
    }
    public Locale getLocale(){
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        setLocale(locale);
        return locale;
    }
}
