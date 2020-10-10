package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class OwnerEntity {

    @Id
    private String id;
    private String name;
    private String familyName;
    private String dni;

    public OwnerEntity() {
        //empty from framework
    }

    public OwnerEntity(String id, String name, String dni, String familyName) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.familyName = familyName;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerEntity that = (OwnerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(familyName, that.familyName) &&
                Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, familyName, dni);
    }

    @Override
    public String toString() {
        return "OwnerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
