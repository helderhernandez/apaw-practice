package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class MemberTeamEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String dni;
    private Boolean available;

    public MemberTeamEntity() {
        //Empty constructor for the framework
    }

    public MemberTeamEntity(String name, String surname, String dni, Boolean available) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.available = available;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (dni.equals(((MemberTeamEntity) o).dni));
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "MemberTeamEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", isAvailable=" + available +
                '}';
    }
}
