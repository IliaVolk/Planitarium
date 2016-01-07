package com.beans.services.payment;

import com.beans.Messages;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by user on 03.01.2016.
 */
@FacesValidator("com.beans.services.payment.CreditCardValidator")
public class CreditCardValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o == null) return;

        String cardNumber;
        if (o instanceof CreditCard)
            cardNumber = o.toString();
        else cardNumber = o.toString().replaceAll("\\D", "");
        if (!luhnCheck(cardNumber)){
            FacesMessage message = new FacesMessage(
                    Messages.getString("badLuhnCheck")
            );
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

    }
    private boolean luhnCheck(String cardNumber){
        int sum = 0;
        for (int i = cardNumber.length()-1; i >=0; i-=2){
            sum += Integer.parseInt(cardNumber.substring(i, i+1));
            if (i > 0){
                int d = Integer.parseInt(cardNumber.substring(i-1,i));
                if (d > 9) d -= 9;
                sum += d;
            }
        }
        return  sum % 10 == 0;
    }
}
