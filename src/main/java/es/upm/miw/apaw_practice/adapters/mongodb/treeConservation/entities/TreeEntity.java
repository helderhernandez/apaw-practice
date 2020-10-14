package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspection;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Tree;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class TreeEntity {
    @Id
    private String id;
    private LocalDateTime registrationDate;
    private String specie;
    private String age;
    private Boolean isMonitored;
    @DBRef
    private List<InspectionEntity> inspectionEntities;
    @DBRef
    private List<DiseaseEntity> diseaseEntities;

    public TreeEntity() {
        //empty from framework
    }

    public TreeEntity(String specie, String age, List<InspectionEntity> inspectionEntities, List<DiseaseEntity> diseaseEntities) {
        this.id = UUID.randomUUID().toString();
        this.registrationDate = LocalDateTime.now();
        this.specie = specie;
        this.age = age;
        this.inspectionEntities = inspectionEntities;
        this.diseaseEntities = diseaseEntities;
        this.isMonitored = Boolean.FALSE;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
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

    public List<InspectionEntity> getInspectionEntities() {
        return inspectionEntities;
    }

    public void setInspectionEntities(List<InspectionEntity> inspectionEntities) {
        this.inspectionEntities = inspectionEntities;
    }

    public List<DiseaseEntity> getDiseaseEntities() {
        return diseaseEntities;
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
                ", registrationDate=" + registrationDate +
                ", specie='" + specie + '\'' +
                ", age='" + age + '\'' +
                ", isMonitored=" + isMonitored +
                ", inspectionEntities=" + inspectionEntities +
                ", diseaseEntities=" + diseaseEntities +
                '}';
    }

    public Tree toTree() {
        Tree tree = new Tree();
        BeanUtils.copyProperties(this, tree, "inspectionEntities", "diseaseEntities");
        List<Inspection> inspections = this.inspectionEntities.stream().
                map(InspectionEntity::toInspection).collect(Collectors.toList());
        tree.setInspections(inspections);
        List<String> diseasesName = this.diseaseEntities.stream().
                map(DiseaseEntity::getName).collect(Collectors.toList());
        tree.setDiseasesName(diseasesName);
        return tree;
    }
}
