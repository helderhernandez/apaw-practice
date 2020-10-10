package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class ReservationSportyEntity {

    @Id
    private String idReservation;
    private LocalDateTime dateReservation;
    @Indexed(unique = true)
    private String refReservation;
    @DBRef
    private List<CustomerSportyEntity> customerSportyEntities;
    @DBRef
    private CategorySportyEntity categorySportyEntity;

    public ReservationSportyEntity() {
    }

    public ReservationSportyEntity(String idReservation, LocalDateTime dateReservation, String refReservation, List<CustomerSportyEntity> customerSportyEntities, CategorySportyEntity categorySportyEntity) {
        this.idReservation = idReservation;
        this.dateReservation = dateReservation;
        this.refReservation = refReservation;
        this.customerSportyEntities = customerSportyEntities;
        this.categorySportyEntity = categorySportyEntity;
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

    @Override
    public String toString() {
        return "ReservationSportyEntity{" +
                "idReservation='" + idReservation + '\'' +
                ", dateReservation=" + dateReservation +
                ", refReservation='" + refReservation + '\'' +
                ", customerSportyEntities=" + customerSportyEntities +
                ", categorySportyEntity=" + categorySportyEntity +
                '}';
    }
}
