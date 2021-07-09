package paymentSystem.entities;

import paymentSystem.BillingDetail;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {

    private String cardType;
    private short expirationMonth;
    private short expirationYear;


    public short getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(short expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public short getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(short expirationMonth) {
        this.expirationMonth = expirationMonth;
    }
}
