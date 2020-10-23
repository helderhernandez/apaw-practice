package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class CustomerAssociateEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String documentId;
    private String name;
    private LocalDate birthday;
    private LocalDateTime registrationDate;
    @DBRef
    private List<RentalFilmEntity> films;

    public CustomerAssociateEntity() {
        // empty from framework
    }

    public CustomerAssociateEntity(String documentId, String name, LocalDate birthday, List<RentalFilmEntity> films) {
        this.id = UUID.randomUUID().toString();
        this.documentId = documentId;
        this.name = name;
        this.birthday = birthday;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public CustomerAssociate toCustomerAssociate() {
        CustomerAssociate customerAssociate = new CustomerAssociate();
        BeanUtils.copyProperties(this, customerAssociate);
        List<RentalFilm> rentalFilms = this.films.stream()
                .map(RentalFilmEntity::toRentalFilm)
                .collect(Collectors.toList());
        customerAssociate.setFilms(rentalFilms);
        return customerAssociate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAssociateEntity customerAssociateEntity = (CustomerAssociateEntity) o;
        return id.equals(customerAssociateEntity.id) &&
                documentId.equals(customerAssociateEntity.documentId) &&
                name.equals(customerAssociateEntity.name) &&
                birthday.equals(customerAssociateEntity.birthday) &&
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
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", films=" + films +
                '}';
    }
}
