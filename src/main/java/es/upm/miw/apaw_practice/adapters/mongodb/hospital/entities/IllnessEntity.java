package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import es.upm.miw.apaw_practice.domain.models.hospital.Illness;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.UUID;

@Document
public class IllnessEntity {

    @Id
    private String id;
    private Integer phase;
    private String [] symptoms;
    private String [] causes;
    private Boolean contagious;

    public IllnessEntity(){
        //empty for framework
    }

    public static IllnessBuilder.Phase builder(){
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public String[] getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String[] symptoms) {
        this.symptoms = symptoms;
    }

    public String[] getCauses() {
        return causes;
    }

    public void setCauses(String[] causes) {
        this.causes = causes;
    }

    public Boolean getContagious() {
        return contagious;
    }

    public void setContagious(Boolean contagious) {
        this.contagious = contagious;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() &&
                (id.equals(((IllnessEntity) obj).id));
    }

    @Override
    public String toString() {
        return "IllnessEntity{" +
                "id='" + id + '\'' +
                ", phase=" + phase +
                ", symptoms=" + Arrays.toString(symptoms) +
                ", causes=" + Arrays.toString(causes) +
                ", contagious=" + contagious +
                '}';
    }

    public Illness toIllness() {
        Illness illness = new Illness();
        BeanUtils.copyProperties(this,illness);
        return illness;
    }

    public void fromIllness(Illness illness) {
        BeanUtils.copyProperties(illness,this);
    }

    public static class Builder implements IllnessBuilder.Phase,IllnessBuilder.Symptoms,IllnessBuilder.Causes,IllnessBuilder.Contagious,IllnessBuilder.Build{
        private IllnessEntity illnessEntity;
        private Integer numElemSymptoms;
        private Integer numElemCauses;
        public Builder(){
            this.numElemSymptoms=0;
            this.numElemCauses=0;
            this.illnessEntity=new IllnessEntity();
            this.illnessEntity.id = UUID.randomUUID().toString();
        }

        @Override
        public IllnessBuilder.Symptoms phase(Integer phase) {
            this.illnessEntity.phase=phase;
            return this;
        }

        @Override
        public IllnessBuilder.Symptoms symptoms(String symptom) {
            if (this.illnessEntity.symptoms == null) {
                this.illnessEntity.symptoms = new String[10];
            }
            this.illnessEntity.symptoms[numElemSymptoms]=symptom;
            numElemSymptoms++;
            return this;
        }

        @Override
        public IllnessBuilder.Causes endSymptoms() {
            return this;
        }

        @Override
        public IllnessBuilder.Causes causes(String cause) {
            if (this.illnessEntity.causes == null) {
                this.illnessEntity.causes = new String[10];
            }
            this.illnessEntity.causes[numElemCauses]=cause;
            numElemCauses++;
            return this;
        }

        @Override
        public IllnessBuilder.Contagious endCauses() {
            return this;
        }

        @Override
        public IllnessBuilder.Build contagious(Boolean contagious) {
            this.illnessEntity.contagious=contagious;
            return this;
        }

        @Override
        public IllnessEntity build(){
            return this.illnessEntity;
        }
    }
}
