package es.upm.miw.apaw_practice.domain.models.sportyRental;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationSporty {

    private String idReservation;
    private LocalDateTime dateReservation;
    private String refReservation;
    private BigDecimal amount;
    private Boolean paidOut;
    private List<CustomerSporty> customersSporty;
    private CategorySporty categorySporty;
    private List<DiscountSporty> discountsSporty;

    public ReservationSporty() {
    }

    public ReservationSporty(String idReservation, LocalDateTime dateReservation, String refReservation, BigDecimal amount, Boolean paidOut, List<CustomerSporty> customersSporty, CategorySporty categorySporty, List<DiscountSporty> discountsSporty) {
        this.idReservation = idReservation;
        this.dateReservation = dateReservation;
        this.refReservation = refReservation;
        this.amount = amount;
        this.paidOut = paidOut;
        this.customersSporty = customersSporty;
        this.categorySporty = categorySporty;
        this.discountsSporty = discountsSporty;
    }

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getRefReservation() {
        return refReservation;
    }

    public void setRefReservation(String refReservation) {
        this.refReservation = refReservation;
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

    public List<CustomerSporty> getCustomersSporty() {
        return customersSporty;
    }

    public void setCustomersSporty(List<CustomerSporty> customersSporty) {
        this.customersSporty = customersSporty;
    }

    public CategorySporty getCategorySporty() {
        return categorySporty;
    }

    public void setCategorySporty(CategorySporty categorySporty) {
        this.categorySporty = categorySporty;
    }

    public List<DiscountSporty> getDiscountsSporty() {
        return discountsSporty;
    }

    public void setDiscountsSporty(List<DiscountSporty> discountsSporty) {
        this.discountsSporty = discountsSporty;
    }

    @Override
    public String toString() {
        return "ReservationSporty{" +
                "idReservation='" + idReservation + '\'' +
                ", dateReservation=" + dateReservation +
                ", refReservation='" + refReservation + '\'' +
                ", amount=" + amount +
                ", paidOut=" + paidOut +
                ", customersSporty=" + customersSporty +
                ", categorySporty=" + categorySporty +
                ", discountsSporty=" + discountsSporty +
                '}';
    }
}
