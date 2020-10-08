package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import es.upm.miw.apaw_practice.domain.models.hospital.PatientCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Document
public class PatientEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private String surname;
    private String [] pathologies;
    @DBRef
    private List<IllnessEntity> illnessEntities;

    public PatientEntity(){
        //empty for framework
    }

    public static PatientBuilder.Dni builder(){
        return new Builder();
    }

    public PatientEntity(PatientCreation patientCreation) {
        BeanUtils.copyProperties(patientCreation, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public List<IllnessEntity> getIllnessEntities() {
        return illnessEntities;
    }

    public void setIllnessEntities(List<IllnessEntity> illnessEntities) {
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

    public Patient toPatient() {
        Patient patient = new Patient();
        BeanUtils.copyProperties(this,patient);
        return patient;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pathologies=" + Arrays.toString(pathologies) +
                ", illnessEntities=" + illnessEntities +
                '}';
    }

    public static class Builder implements PatientBuilder.Dni, PatientBuilder.Optionals{

        private PatientEntity patientEntity;
        private Integer numElemPathologies;

        public Builder(){
            this.numElemPathologies=0;
            this.patientEntity=new PatientEntity();
            this.patientEntity.id = UUID.randomUUID().toString();
        }

        @Override
        public PatientBuilder.Optionals dni(String dni) {
            this.patientEntity.dni=dni;
            return this;
        }

        @Override
        public PatientBuilder.Optionals name(String name) {
            this.patientEntity.name=name;
            return this;
        }

        @Override
        public PatientBuilder.Optionals surname(String surname) {
            this.patientEntity.surname=surname;
            return this;
        }

        @Override
        public PatientBuilder.Optionals pathologies(String pathology) {
            if (this.patientEntity.pathologies == null) {
                this.patientEntity.pathologies = new String [10];
            }
            this.patientEntity.pathologies[numElemPathologies]=pathology;
            this.numElemPathologies++;
            return this;
        }

        @Override
        public PatientBuilder.Optionals illnessEntities(IllnessEntity illnessEntity) {
            if (this.patientEntity.illnessEntities == null) {
                this.patientEntity.illnessEntities = new ArrayList<IllnessEntity>();
            }
            this.patientEntity.illnessEntities.add(illnessEntity);
            return this;
        }

        @Override
        public PatientEntity build() {
            return this.patientEntity;
        }
    }
}
