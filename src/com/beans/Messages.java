package com.beans;

import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by user on 03.01.2016.
 */
public class Messages {
    private static final ResourceBundle RESOURCE_BUNDLE  = ResourceBundle.getBundle("messages",
            FacesContext.getCurrentInstance().getViewRoot().getLocale(),
    Thread.currentThread().getContextClassLoader());
    private Messages() {
    }
    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
    public static String getString(String key, Object... params  ) {
        try {
            return MessageFormat.format(RESOURCE_BUNDLE.getString(key), params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
