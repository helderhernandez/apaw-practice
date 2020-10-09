package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CDOwnerEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    private Long telephone;

    public CDOwnerEntity() {
        // Empty for framework
    }

    public CDOwnerEntity(String name, String surname, Long telephone) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CDOwnerEntity that = (CDOwnerEntity) o;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "CDOwnerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
