package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ArticleEntity;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class TreeEntity {
    @Id
    private String id;
    private LocalDate registerDate;
    private String specie;
    private String age;
    private boolean isMonitored;
    private List<InspectionEntity> inspectionEntities;
    private List<DiseaseEntity> diseaseEntities;

    public TreeEntity(String specie, String age, List<InspectionEntity> inspectionEntities, List<DiseaseEntity> diseaseEntities) {
        this.id = UUID.randomUUID().toString();
        this.registerDate = LocalDate.now();
        this.specie = specie;
        this.age = age;
        this.inspectionEntities = inspectionEntities;
        this.diseaseEntities = diseaseEntities;
    }

    public String getId() {
        return id;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public String getSpecie() {
        return specie;
    }

    public String getAge() {
        return age;
    }

    public boolean isMonitored() {
        return isMonitored;
    }

    public List<InspectionEntity> getInspectionEntities() {
        return inspectionEntities;
    }

    public List<DiseaseEntity> getDiseaseEntities() {
        return diseaseEntities;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setMonitored(boolean monitored) {
        isMonitored = monitored;
    }

    public void setInspectionEntities(List<InspectionEntity> inspectionEntities) {
        this.inspectionEntities = inspectionEntities;
    }

    public void setDiseaseEntities(List<DiseaseEntity> diseaseEntities) {
        this.diseaseEntities = diseaseEntities;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (this.id.equals(((TreeEntity) o).getId()));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "TreeEntity{" +
                "id='" + id + '\'' +
                ", registerDate=" + registerDate +
                ", specie='" + specie + '\'' +
                ", age='" + age + '\'' +
                ", isMonitored=" + isMonitored +
                ", inspectionEntities=" + inspectionEntities +
                ", diseaseEntities=" + diseaseEntities +
                '}';
    }
}
