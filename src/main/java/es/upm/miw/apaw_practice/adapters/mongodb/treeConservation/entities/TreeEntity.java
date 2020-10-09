package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class TreeEntity {
    @Id
    private String id;
    private LocalDate plantingDate;
    private String specie;
    private String age;
    private boolean isMonitoringRequired;

    @Override
    public String toString() {
        return "TreeEntity{" +
                "id='" + id + '\'' +
                ", plantingDate=" + plantingDate +
                ", specie='" + specie + '\'' +
                ", age='" + age + '\'' +
                ", isMonitoringRequired=" + isMonitoringRequired +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeEntity that = (TreeEntity) o;
        return isMonitoringRequired == that.isMonitoringRequired &&
                Objects.equals(id, that.id) &&
                Objects.equals(plantingDate, that.plantingDate) &&
                Objects.equals(specie, that.specie) &&
                Objects.equals(age, that.age) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plantingDate, specie, age, isMonitoringRequired, status);
    }

    private String status;

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(LocalDate plantingDate) {
        this.plantingDate = plantingDate;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public boolean isMonitoringRequired() {
        return isMonitoringRequired;
    }

    public void setMonitoringRequired(boolean monitoringRequired) {
        isMonitoringRequired = monitoringRequired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
