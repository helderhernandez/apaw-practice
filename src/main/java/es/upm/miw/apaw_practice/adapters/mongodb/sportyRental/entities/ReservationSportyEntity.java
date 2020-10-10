package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document
public class ReservationSportyEntity {

    @Id
    private String idReservation;
    private LocalDateTime dateReservation;
    @Indexed(unique = true)
    private String refReservation;
    private BigDecimal amount;
    private Boolean paidOut;
    @DBRef
    private List<CustomerSportyEntity> customerSportyEntities;
    @DBRef
    private CategorySportyEntity categorySportyEntity;
    @DBRef
    private List<DiscountSportyEntity> discountSportyEntity;

    public ReservationSportyEntity() {
    }

    public ReservationSportyEntity(String idReservation, LocalDateTime dateReservation, String refReservation, BigDecimal amount, Boolean paidOut, List<CustomerSportyEntity> customerSportyEntities, CategorySportyEntity categorySportyEntity, List<DiscountSportyEntity> discountSportyEntity) {
        this.idReservation = idReservation;
        this.dateReservation = dateReservation;
        this.refReservation = refReservation;
        this.amount = amount;
        this.paidOut = paidOut;
        this.customerSportyEntities = customerSportyEntities;
        this.categorySportyEntity = categorySportyEntity;
        this.discountSportyEntity = discountSportyEntity;
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

    public List<CustomerSportyEntity> getCustomerSportyEntities() {
        return customerSportyEntities;
    }

    public void setCustomerSportyEntities(List<CustomerSportyEntity> customerSportyEntities) {
        this.customerSportyEntities = customerSportyEntities;
    }

    public CategorySportyEntity getCategorySportyEntity() {
        return categorySportyEntity;
    }

    public void setCategorySportyEntity(CategorySportyEntity categorySportyEntity) {
        this.categorySportyEntity = categorySportyEntity;
    }

    public List<DiscountSportyEntity> getDiscountSportyEntity() {
        return discountSportyEntity;
    }

    public void setDiscountSportyEntity(List<DiscountSportyEntity> discountSportyEntity) {
        this.discountSportyEntity = discountSportyEntity;
    }

    @Override
    public String toString() {
        return "ReservationSportyEntity{" +
                "idReservation='" + idReservation + '\'' +
                ", dateReservation=" + dateReservation +
                ", refReservation='" + refReservation + '\'' +
                ", amount=" + amount +
                ", paidOut=" + paidOut +
                ", customerSportyEntities=" + customerSportyEntities +
                ", categorySportyEntity=" + categorySportyEntity +
                ", discountSportyEntity=" + discountSportyEntity +
                '}';
    }
}
