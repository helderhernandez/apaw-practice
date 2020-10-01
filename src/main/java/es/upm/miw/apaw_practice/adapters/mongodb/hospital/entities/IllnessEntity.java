package es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document
public class IllnessEntity {

    @Id
    private String id;
    private int phase;
    private String [] symptoms;
    private String [] causes;
    private Boolean contagious;

    public IllnessEntity(){
        //empty for framework
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

    public void setPhase(int phase) {
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
}
