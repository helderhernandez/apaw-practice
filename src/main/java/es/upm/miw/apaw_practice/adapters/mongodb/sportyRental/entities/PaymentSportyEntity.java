package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
public class PaymentSportyEntity {

    @Id
    private String idPayment;
    private String IBAN;
    private LocalDateTime datePayment;
    private BigDecimal amount;
    private Boolean paidOut;
    @DBRef
    private ReservationSportyEntity reservationSportyEntity;

    public PaymentSportyEntity() {
    }

    public PaymentSportyEntity(String idPayment, String IBAN, LocalDateTime datePayment, BigDecimal amount, Boolean paidOut, ReservationSportyEntity reservationSportyEntity) {
        this.idPayment = idPayment;
        this.IBAN = IBAN;
        this.datePayment = datePayment;
        this.amount = amount;
        this.paidOut = paidOut;
        this.reservationSportyEntity = reservationSportyEntity;
    }

    public String getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(String idPayment) {
        this.idPayment = idPayment;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public LocalDateTime getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDateTime datePayment) {
        this.datePayment = datePayment;
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

    public ReservationSportyEntity getReservationSportyEntity() {
        return reservationSportyEntity;
    }

    public void setReservationSportyEntity(ReservationSportyEntity reservationSportyEntity) {
        this.reservationSportyEntity = reservationSportyEntity;
    }

    @Override
    public String toString() {
        return "PaymentSportyEntity{" +
                "idPayment='" + idPayment + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", datePayment=" + datePayment +
                ", amount=" + amount +
                ", paidOut=" + paidOut +
                ", reservationSportyEntity=" + reservationSportyEntity +
                '}';
    }
}
