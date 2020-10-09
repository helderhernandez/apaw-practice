package es.upm.miw.apaw_practice.domain.models.hospital;

import java.util.Arrays;

public class Illness {
    private String id;
    private Integer phase;
    private String[] symptoms;
    private String[] causes;
    private Boolean contagious;

    public Illness() {
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
    public String toString() {
        return "Illness{" +
                "id='" + id + '\'' +
                ", phase=" + phase +
                ", symptoms=" + Arrays.toString(symptoms) +
                ", causes=" + Arrays.toString(causes) +
                ", contagious=" + contagious +
                '}';
    }
}
