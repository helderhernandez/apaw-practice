package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class SharedAccountEntity {
    @Id
    private String id;
    private BigDecimal amount;
    private String type;
    @Indexed(unique = true)
    private String IBAN;
    @DBRef
    private List<CustomerEntity> customerEntities;

    public SharedAccountEntity() {
        //Empty for framework
    }

    public SharedAccountEntity(BigDecimal amount, String type, String IBAN, List<CustomerEntity> customerEntities) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.type = type;
        this.IBAN = IBAN;
        this.customerEntities = customerEntities;
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

    public List<CustomerEntity> getCustomerEntities() {
        return customerEntities;
    }

    public void setCustomerEntities(List<CustomerEntity> customerEntities) {
        this.customerEntities = customerEntities;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedAccountEntity that = (SharedAccountEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IBAN);
    }

    @Override
    public String toString() {
        return "SharedAccountEntity{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", customerEntities=" + customerEntities +
                '}';
    }
}
