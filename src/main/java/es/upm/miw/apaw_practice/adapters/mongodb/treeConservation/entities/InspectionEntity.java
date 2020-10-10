package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
public class InspectionEntity {

    @Id
    private String id;
    private LocalDate date;
    private String type;
    private String treeStatus;
    private InspectorEntity inspectorEntity;

    public InspectionEntity(LocalDate date, String type, String treeStatus, InspectorEntity inspectorEntity) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.type = type;
        this.treeStatus = treeStatus;
        this.inspectorEntity = inspectorEntity;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String isTreeStatus() {
        return treeStatus;
    }

    public InspectorEntity getInspectorEntity() {
        return inspectorEntity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTreeStatus(String treeStatus) {
        this.treeStatus = treeStatus;
    }

    public void setInspectorEntity(InspectorEntity inspectorEntity) {
        this.inspectorEntity = inspectorEntity;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (this.id.equals(((InspectionEntity) o).getId()));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "InspectionEntity{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", treeStatus=" + treeStatus +
                ", inspectorEntity=" + inspectorEntity +
                '}';
    }
}
