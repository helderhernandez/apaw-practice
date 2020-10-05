package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.models.bank.CustomerCreation;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String DNI;
    private String phone;
    private String email;

    public CustomerEntity(String name, String DNI, String phone, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.DNI = DNI;
        this.phone = phone;
        this.email = email;
    }

    public CustomerEntity(CustomerCreation customerCreation) {
        BeanUtils.copyProperties(customerCreation, this);
        this.id = UUID.randomUUID().toString();
    }

    public CustomerEntity() {
        //Empty for framework;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object object) {
        return this == object || object != null && getClass() == object.getClass() && (DNI.equals(((CustomerEntity) object).DNI));
    }

    @Override
    public int hashCode() {
        return DNI.hashCode();
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", DNI='" + DNI + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    public Customer toCustomer() {
        Customer customer = new Customer();
        BeanUtils.copyProperties(this, customer);
        return customer;
    }
}
