package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.utils.ConsUtils;
import es.upm.miw.apaw_practice.domain.models.sportyrental.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        //empty for framework
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
        this.refReservation = ConsUtils.START_REFERENCE + UUID.randomUUID().toString().substring(ConsUtils.MAX_REFERENCE);
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
        return ReservationSporty.builder().idReservation(this.idReservation).dateReservation(this.dateReservation)
                .refReservation(this.refReservation).amount(this.amount).paidOut(this.paidOut).listCustomersSporty(this.convertToListCustomerSporty())
                .categorySporty(new CategorySporty(this.categorySportyEntity.getIdCategory(), this.categorySportyEntity.getDescription(), this.categorySportyEntity.getNumMaxPersons()))
                .listDiscountsSporty(this.convertToListDiscountSporty()).build();
    }

    private List<CustomerSporty> convertToListCustomerSporty() {
        return this.customerSportyEntities.stream().map(customerSporty -> new CustomerSporty(customerSporty.getIdCustomer(), customerSporty.getDni(),
                customerSporty.getName(), customerSporty.getSurnames(), customerSporty.getEmail(), customerSporty.getPhone())).collect(Collectors.toList());
    }

    private List<DiscountSporty> convertToListDiscountSporty() {
        return this.discountSportyEntity.stream().map(discountSporty -> new DiscountSporty(discountSporty.getIdDiscount(), discountSporty.getDescription(),
                discountSporty.getPercentage())).collect(Collectors.toList());
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
