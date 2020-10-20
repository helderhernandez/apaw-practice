package es.upm.miw.apaw_practice.domain.models.sportyrental;

import es.upm.miw.apaw_practice.domain.models.sportyrental.reservationsportybuilders.ReservationSportyBuilders;

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
        //empty for framework
    }

    public static ReservationSportyBuilders.IdReservation builder() {
        return new Builder();
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

    public static class Builder implements ReservationSportyBuilders.IdReservation, ReservationSportyBuilders.DateReservation, ReservationSportyBuilders.RefReservation, ReservationSportyBuilders.Optionals {

        private ReservationSporty reservationSporty;

        public Builder() {
            this.reservationSporty = new ReservationSporty();
        }

        @Override
        public ReservationSportyBuilders.DateReservation idReservation(String idReservation) {
            this.reservationSporty.idReservation = idReservation;
            return this;
        }

        @Override
        public ReservationSportyBuilders.RefReservation dateReservation(LocalDateTime dateReservation) {
            this.reservationSporty.dateReservation = dateReservation;
            return this;
        }

        @Override
        public ReservationSportyBuilders.Optionals refReservation(String refReservation) {
            this.reservationSporty.refReservation = refReservation;
            return this;
        }

        @Override
        public ReservationSportyBuilders.Optionals amount(BigDecimal amount) {
            this.reservationSporty.amount = amount;
            return this;
        }

        @Override
        public ReservationSportyBuilders.Optionals paidOut(Boolean paidOut) {
            this.reservationSporty.paidOut = paidOut;
            return this;
        }

        @Override
        public ReservationSportyBuilders.Optionals listCustomersSporty(List<CustomerSporty> customersSporty) {
            this.reservationSporty.customersSporty = customersSporty;
            return this;
        }

        @Override
        public ReservationSportyBuilders.Optionals categorySporty(CategorySporty categorySporty) {
            this.reservationSporty.categorySporty = categorySporty;
            return this;
        }

        @Override
        public ReservationSportyBuilders.Optionals listDiscountsSporty(List<DiscountSporty> discountsSporty) {
            this.reservationSporty.discountsSporty = discountsSporty;
            return this;
        }

        @Override
        public ReservationSporty build() {
            return this.reservationSporty;
        }
    }
}
