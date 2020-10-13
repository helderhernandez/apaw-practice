package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

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


    private SharedAccountEntity(Builder builder) {
        this.id = builder.id;
        this.IBAN = builder.IBAN;
        this.type = builder.type;
        this.amount = builder.amount;
        this.customerEntities = builder.customerEntities;
    }

    public static class Builder {

        private final String id;
        private final String IBAN;
        private BigDecimal amount;
        private String type;
        private List<CustomerEntity> customerEntities;

        public Builder(String IBAN) {
            this.id = UUID.randomUUID().toString();
            this.IBAN = IBAN;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder customerEntities(List<CustomerEntity> customerEntities) {
            this.customerEntities = customerEntities;
            return this;
        }

        public SharedAccountEntity build() {
            return new SharedAccountEntity(this);
        }

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

    public Stream<String> getDNIs() {
        return this.customerEntities.stream().
                map(CustomerEntity::getDNI);
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
