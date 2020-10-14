package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities;

import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class PassengerBusEntity {

    private static final String ENTITY_REF_NAME = "PSNG";

    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private String docIdentify;
    private String name;
    private String familyName;
    private String phone;
    private String email;
    private Boolean accesibility;

    public PassengerBusEntity() {
        //empty from framework
    }

    public PassengerBusEntity(String docIdentify, String name, String familyName, String phone, String email, Boolean accesibility) {
        this.id = UUID.randomUUID().toString();
        this.reference = GenRefEntity.getReferenceId(ENTITY_REF_NAME);
        this.docIdentify = docIdentify;
        this.name = name;
        this.familyName = familyName;
        this.phone = phone;
        this.email = email;
        this.accesibility = accesibility;
    }

    public PassengerBusEntity(PassengerBusCreation passenger) {
        BeanUtils.copyProperties(passenger, this);
        this.id = UUID.randomUUID().toString();
        this.reference = GenRefEntity.getReferenceId(ENTITY_REF_NAME);
    }

    public PassengerBus toPassengerBus() {
        PassengerBus passengerBus = new PassengerBus();
        BeanUtils.copyProperties(this, passengerBus);
        return passengerBus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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

    public Boolean getAccesibility() {
        return accesibility;
    }

    public void setAccesibility(Boolean accesibility) {
        this.accesibility = accesibility;
    }

    public String getDocIdentify() {
        return docIdentify;
    }

    public void setDocIdentify(String docIdentify) {
        this.docIdentify = docIdentify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerBusEntity that = (PassengerBusEntity) o;
        return id.equals(that.id) &&
                docIdentify.equals(that.docIdentify) &&
                name.equals(that.name) &&
                familyName.equals(that.familyName) &&
                phone.equals(that.phone) &&
                email.equals(that.email) &&
                Objects.equals(accesibility, that.accesibility);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "PassengerBusEntity{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", docIdentify='" + docIdentify + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", accesibility=" + accesibility +
                '}';
    }
}
