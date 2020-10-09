package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import es.upm.miw.apaw_practice.domain.models.bank.Account;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Document
public class AccountEntity {
    @Id
    private String id;
    private BigDecimal amount;
    @Indexed(unique = true)
    private String IBAN;
    @DBRef
    private CustomerEntity customerEntity;

    public AccountEntity(BigDecimal amount, CustomerEntity customerEntity, String IBAN) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.customerEntity = customerEntity;
        this.IBAN = IBAN;
    }

    public AccountEntity() {
        //Empty for framework
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

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
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
        AccountEntity that = (AccountEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IBAN);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", IBAN='" + IBAN + '\'' +
                ", customerEntity=" + customerEntity +
                '}';
    }

    public Account toAccount() {
        Account account = new Account();
        BeanUtils.copyProperties(this, account);
        return account;
    }

    public String getIdByCustomer(CustomerEntity customerEntity) {
        if (this.customerEntity.equals(customerEntity))
            return this.getId();
        else return null;
    }
}
