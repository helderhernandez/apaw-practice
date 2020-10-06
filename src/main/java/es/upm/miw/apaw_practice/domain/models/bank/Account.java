package es.upm.miw.apaw_practice.domain.models.bank;

import java.math.BigDecimal;

public class Account {
    private String id;
    private BigDecimal amount;
    private String IBAN;

    public Account() {
        //Empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", IBAN='" + IBAN + '\'' +
                '}';
    }
}
