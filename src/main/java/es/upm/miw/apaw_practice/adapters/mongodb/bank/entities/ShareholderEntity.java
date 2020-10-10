package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class ShareholderEntity {
    @Id
    private String id;
    private BigDecimal percentage;
    private BigDecimal value;
    private LocalDateTime expirationDate;
    private Boolean active;
    @DBRef
    private List<CustomerEntity> customerEntities;

    public ShareholderEntity() {
        //Empty for framework
    }

    public ShareholderEntity(BigDecimal percentage, BigDecimal value, LocalDateTime expirationDate, Boolean active, List<CustomerEntity> customerEntities) {
        this.id = UUID.randomUUID().toString();
        this.percentage = percentage;
        this.value = value;
        this.expirationDate = expirationDate;
        this.active = active;
        this.customerEntities = customerEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public List<CustomerEntity> getCustomerEntities() {
        return customerEntities;
    }

    public void setCustomerEntities(List<CustomerEntity> customerEntities) {
        this.customerEntities = customerEntities;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShareholderEntity that = (ShareholderEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ShareholderEntity{" +
                "id='" + id + '\'' +
                ", percentage=" + percentage +
                ", value=" + value +
                ", expirationDate=" + expirationDate +
                ", isActive=" + active +
                ", customerEntities=" + customerEntities +
                '}';
    }
}
