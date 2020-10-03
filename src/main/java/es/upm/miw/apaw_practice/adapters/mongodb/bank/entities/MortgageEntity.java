package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Document
public class MortgageEntity {
    @Id
    private String id;
    private BigDecimal amount;
    private BigDecimal paidout;
    @DBRef
    private CustomerEntity customerEntity;

    public MortgageEntity() {
        //Empty for framework
    }

    public MortgageEntity(BigDecimal amount, BigDecimal paidout, CustomerEntity customerEntity) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.paidout = paidout;
        this.customerEntity = customerEntity;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPaidout() {
        return paidout;
    }

    public void setPaidout(BigDecimal paidout) {
        this.paidout = paidout;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MortgageEntity that = (MortgageEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MortgageEntity{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", paidout=" + paidout +
                ", customerEntity=" + customerEntity +
                '}';
    }
}
