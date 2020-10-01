package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document
public class PatientEntity {

    @Id
    private String id;
    private String name;
    private String surname;
    private String [] pathologies;
    private IllnessEntity [] illnessEntities;

    public PatientEntity(){
        //empty for framework
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

    public String[] getPathologies() {
        return pathologies;
    }

    public void setPathologies(String[] pathologies) {
        this.pathologies = pathologies;
    }

    public IllnessEntity[] getIllnessEntities() {
        return illnessEntities;
    }

    public void setIllnessEntities(IllnessEntity[] illnessEntities) {
        this.illnessEntities = illnessEntities;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() &&
                (id.equals(((PatientEntity) obj).id));
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pathologies=" + Arrays.toString(pathologies) +
                ", illnessEntities=" + Arrays.toString(illnessEntities) +
                '}';
    }
}
