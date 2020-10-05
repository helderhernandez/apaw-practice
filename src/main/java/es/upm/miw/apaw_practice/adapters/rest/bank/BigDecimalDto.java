package es.upm.miw.apaw_practice.adapters.rest.bank;

import java.math.BigDecimal;

public class BigDecimalDto {
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BigDecimalDto{" +
                "amount=" + amount +
                '}';
    }
}
