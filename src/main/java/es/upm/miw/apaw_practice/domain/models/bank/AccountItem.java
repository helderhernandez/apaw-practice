package es.upm.miw.apaw_practice.domain.models.bank;

import java.math.BigDecimal;

public class AccountItem {
    private BigDecimal amount;

    public AccountItem() {
        //Empty for framework
    }

    public AccountItem(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountItem{" +
                "amount=" + amount +
                '}';
    }
}
