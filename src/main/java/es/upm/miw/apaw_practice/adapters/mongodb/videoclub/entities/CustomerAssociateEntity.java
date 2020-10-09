package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Document
public class CustomerAssociateEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String documentId;
    private String name;
    private String familyName;
    private LocalDate birthday;
    private String phone;
    private LocalDateTime registrationDate;
    @DBRef
    private List<RentalFilmEntity> films;

    public CustomerAssociateEntity() {
        // empty from framework
    }

    public CustomerAssociateEntity(String documentId, String name, String familyName, LocalDate birthday, String phone, List<RentalFilmEntity> films) {
        this.id = UUID.randomUUID().toString();
        this.documentId = documentId;
        this.name = name;
        this.familyName = familyName;
        this.birthday = birthday;
        this.phone = phone;
        this.registrationDate = LocalDateTime.now();
        this.films = films;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public List<RentalFilmEntity> getFilms() {
        return films;
    }

    public void setFilms(List<RentalFilmEntity> films) {
        this.films = films;
    }

    public Integer getAge() {
        LocalDate today = LocalDate.now();
        Period p = Period.between(birthday, today);
        return p.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAssociateEntity customerAssociateEntity = (CustomerAssociateEntity) o;
        return id.equals(customerAssociateEntity.id) &&
                documentId.equals(customerAssociateEntity.documentId) &&
                name.equals(customerAssociateEntity.name) &&
                familyName.equals(customerAssociateEntity.familyName) &&
                birthday.equals(customerAssociateEntity.birthday) &&
                phone.equals(customerAssociateEntity.phone) &&
                registrationDate.equals(customerAssociateEntity.registrationDate) &&
                films.equals(customerAssociateEntity.films);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "CustomerAssociateEntity{" +
                "id='" + id + '\'' +
                ", documentId='" + documentId + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", birthday=" + birthday +
                ", phone=" + phone +
                ", registrationDate=" + registrationDate +
                ", films=" + films +
                '}';
    }
}
