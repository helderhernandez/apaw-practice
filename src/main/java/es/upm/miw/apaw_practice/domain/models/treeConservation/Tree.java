package es.upm.miw.apaw_practice.domain.models.treeConservation;

import java.time.LocalDateTime;
import java.util.List;

public class Tree {

    private String id;
    private LocalDateTime registrationDate;
    private String specie;
    private String age;
    private Boolean isMonitored;
    private List<Inspection> inspections;
    private List<String> diseasesName;

    public Tree() {
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getMonitored() {
        return isMonitored;
    }

    public void setMonitored(Boolean monitored) {
        isMonitored = monitored;
    }

    public List<Inspection> getInspections() {
        return inspections;
    }

    public void setInspections(List<Inspection> inspections) {
        this.inspections = inspections;
    }

    public List<String> getDiseasesName() {
        return diseasesName;
    }

    public void setDiseasesName(List<String> diseasesName) {
        this.diseasesName = diseasesName;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id='" + id + '\'' +
                ", registrationDate=" + registrationDate +
                ", specie='" + specie + '\'' +
                ", age='" + age + '\'' +
                ", isMonitored=" + isMonitored +
                ", inspections=" + inspections +
                ", diseasesName=" + diseasesName +
                '}';
    }
}
