package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.utils.Constans;
import es.upm.miw.apaw_practice.domain.models.sportyRental.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public ReservationSportyEntity(ReservationCreationSporty reservationCreationSporty) {
        BeanUtils.copyProperties(reservationCreationSporty, this);
        this.idReservation = UUID.randomUUID().toString();
        this.dateReservation = LocalDateTime.now();
        this.refReservation = Constans.START_REFERENCE+UUID.randomUUID().toString().substring(Constans.MAX_REFERENCE);
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

    public ReservationSporty convertToReservationSporty() {
        return new ReservationSporty(this.idReservation,
                this.dateReservation,
                this.refReservation,
                this.amount,
                this.paidOut,
                this.convertToListCustomerSporty(),
                new CategorySporty(this.categorySportyEntity.getIdCategory(), this.categorySportyEntity.getDescription(), this.categorySportyEntity.getNumMaxPersons()),
                this.convertToListDiscountSporty());
    }

    private List<CustomerSporty> convertToListCustomerSporty() {
        List<CustomerSporty> listCustomerSporty = new ArrayList<CustomerSporty>();

        this.customerSportyEntities.stream().forEach(
                customerSporty -> {
                    listCustomerSporty.add(new CustomerSporty(customerSporty.getIdCustomer(), customerSporty.getDni(),
                            customerSporty.getName(), customerSporty.getSurnames(), customerSporty.getEmail(), customerSporty.getPhone()));
                }
        );
        return listCustomerSporty;
    }

    private List<DiscountSporty> convertToListDiscountSporty() {
        List<DiscountSporty> listDiscountSporty = new ArrayList<DiscountSporty>();

        this.discountSportyEntity.stream().forEach(
                discountSporty -> {
                    listDiscountSporty.add(new DiscountSporty(discountSporty.getIdDiscount(), discountSporty.getDescription(),
                            discountSporty.getPercentage()));
                }
        );
        return listDiscountSporty;
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
