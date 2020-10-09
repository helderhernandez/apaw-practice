package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class InspectionEntity {
    private String id;
    private LocalDate inspectionDate;
    private boolean treeStatus;

    public String getId() {
        return id;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public boolean isTreeStatus() {
        return treeStatus;
    }

    public InspectionEntity() {
    }
}
