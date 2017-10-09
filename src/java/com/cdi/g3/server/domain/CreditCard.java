package com.cdi.g3.server.domain; 

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.utiles.Utility;



public final class CreditCard extends DomainObject {

    // ======================================
    // =             Attributes             =
    // ======================================
    
    
    private String idCreditCard;
    private String nameCreditCard;
    private String creditCardNumber;
    private String creditCardType;
    private String creditCardExpiryDate;
    private String creditCardCCV;

    // ======================================
    // =         Getters and Setters        =
    // ======================================
    
     public void checkData() throws CheckException {
        if (creditCardNumber == null || "".equals(creditCardNumber))
            throw new CheckException("Invalid credit card number");        
       if (creditCardType == null || "".equals(creditCardType))
            throw new CheckException("Invalid credit card type");   
       if (creditCardExpiryDate == null || "".equals(creditCardExpiryDate))
            throw new CheckException("Invalid credit card date expiry");  
        if (creditCardCCV == null || "".equals(creditCardCCV))
            throw new CheckException("Invalid credit ccv");   
        
    }
    
    @Override
    public String getId() {
        return idCreditCard;
    }
    @Override
    public void setId(String idCreditCard) {
        this.idCreditCard = idCreditCard;
    }

    public String getNameCreditCard() {
        return nameCreditCard;
    }

    public void setNameCreditCard(String nameCreditCard) {
        this.nameCreditCard = nameCreditCard;
    }
    
    
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(final String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(final String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardExpiryDate() {
        return creditCardExpiryDate;
    }

    public void setCreditCardExpiryDate(final String creditCardExpiryDate) {
        this.creditCardExpiryDate = creditCardExpiryDate;
    }

    public String getCreditCardCCV() {
        return creditCardCCV;
    }

    public void setCreditCardCCV(String creditCardCCV) {
        this.creditCardCCV = creditCardCCV;
    }
    
    
}
