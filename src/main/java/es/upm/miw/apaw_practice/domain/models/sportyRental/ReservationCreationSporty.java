package es.upm.miw.apaw_practice.domain.models.sportyRental;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationCreationSporty {

    private BigDecimal amount;
    private Boolean paidOut;
    private List<CustomerCreationSporty> customersCreationSporty;
    private CategoryCreationSporty categoryCreationSporty;
    private List<DiscountCreationSporty> discountsCreationSporty;

    public ReservationCreationSporty() {
    }

    public ReservationCreationSporty(BigDecimal amount, Boolean paidOut, List<CustomerCreationSporty> customersCreationSporty, CategoryCreationSporty categoryCreationSporty, List<DiscountCreationSporty> discountsCreationSporty) {
        this.amount = amount;
        this.paidOut = paidOut;
        this.customersCreationSporty = customersCreationSporty;
        this.categoryCreationSporty = categoryCreationSporty;
        this.discountsCreationSporty = discountsCreationSporty;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getPaidOut() {
        return paidOut;
    }

    public void setPaidOut(Boolean paidOut) {
        this.paidOut = paidOut;
    }

    public List<CustomerCreationSporty> getCustomersCreationSporty() {
        return customersCreationSporty;
    }

    public void setCustomersCreationSporty(List<CustomerCreationSporty> customersCreationSporty) {
        this.customersCreationSporty = customersCreationSporty;
    }

    public CategoryCreationSporty getCategoryCreationSporty() {
        return categoryCreationSporty;
    }

    public void setCategoryCreationSporty(CategoryCreationSporty categoryCreationSporty) {
        this.categoryCreationSporty = categoryCreationSporty;
    }

    public List<DiscountCreationSporty> getDiscountsCreationSporty() {
        return discountsCreationSporty;
    }

    public void setDiscountsCreationSporty(List<DiscountCreationSporty> discountsCreationSporty) {
        this.discountsCreationSporty = discountsCreationSporty;
    }

    @Override
    public String toString() {
        return "ReservationCreationSporty{" +
                "amount=" + amount +
                ", paidOut=" + paidOut +
                ", customersCreationSporty=" + customersCreationSporty +
                ", categoryCreationSporty=" + categoryCreationSporty +
                ", discountsCreationSporty=" + discountsCreationSporty +
                '}';
    }
}
