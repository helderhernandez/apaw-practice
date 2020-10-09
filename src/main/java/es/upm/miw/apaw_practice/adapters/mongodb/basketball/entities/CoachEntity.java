package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class CoachEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String dni;
    private Integer numberTeamsCoaching;

    public CoachEntity() {
        //Empty constructor for the framework
    }

    public CoachEntity(String name, String surname, String dni, Integer numberTeamsCoaching) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.numberTeamsCoaching = numberTeamsCoaching;
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

    public Integer getNumberTeamsCoaching() {
        return numberTeamsCoaching;
    }

    public void setNumberTeamsCoaching(Integer numberTeamsCoaching) {
        this.numberTeamsCoaching = numberTeamsCoaching;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (dni.equals(((CoachEntity) o).dni));
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "CoachEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni='" + dni + '\'' +
                ", numberTeamsCoaching=" + numberTeamsCoaching +
                '}';
    }
}
