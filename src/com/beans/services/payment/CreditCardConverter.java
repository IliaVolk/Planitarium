package com.beans.services.payment;


import com.beans.Messages;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by user on 03.01.2016.
 */
@FacesConverter(forClass = CreditCard.class)
public class CreditCardConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent,
                              String s) throws ConverterException{
        StringBuilder builder = new StringBuilder(s);
        boolean foundInvalidCharacter = false;
        char invalidCharacter = '\0';
        int i = 0;
        while(i < builder.length() && !foundInvalidCharacter){
            char ch = builder.charAt(i);
            if (Character.isDigit(ch)){
                i++;
            }else if (Character.isWhitespace(ch)){
                builder.deleteCharAt(i);
            }else {
                foundInvalidCharacter = true;
                invalidCharacter = ch;
            }
        }

        if (foundInvalidCharacter){
            FacesMessage message = new FacesMessage(Messages.getString("badCreditCardCharacter"),
                    Messages.getString("badCreditCardCharacter_detail", String.valueOf(invalidCharacter)));
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }

        return new CreditCard(builder.toString());
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent,
                              Object o) throws ConverterException{
        String v = o.toString();
        int[] boundaries;
        int length = v.length();
        if (length == 13){
            boundaries = new int[]{4, 7, 10};
        }else if (length == 14){
            boundaries = new int[]{5,9};
        }else if(length == 15) {
            boundaries = new int[]{4,10};
        }else if(length == 16) {
            boundaries = new int[]{4,8,12};
        }else if (length == 22) {
            boundaries = new int[]{6,14};
        }else return v;

        StringBuilder result = new StringBuilder();
        int start = 0;
        for (int i = 0; i < boundaries.length; i++) {
            int end = boundaries[i];
            result.append(v.substring(start,end));
            result.append(" ");
            start = end;
        }
        result.append(v.substring(start));
        return result.toString();
    }
}
