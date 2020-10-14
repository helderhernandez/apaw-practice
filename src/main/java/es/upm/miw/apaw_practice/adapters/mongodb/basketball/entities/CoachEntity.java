package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import es.upm.miw.apaw_practice.domain.models.basketball.Coach;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class CoachEntity {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String dni;

    public CoachEntity() {
        //Empty constructor for the framework
    }

    public CoachEntity(CoachCreation coachCreation) {
        BeanUtils.copyProperties(coachCreation, this);
        this.id = UUID.randomUUID().toString();
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
                ", dni='" + dni + '\'' +
                '}';
    }

    public Coach toCoach() {
        Coach coach = new Coach();
        BeanUtils.copyProperties(this, coach);
        return coach;
    }
}
