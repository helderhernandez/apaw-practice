package es.upm.miw.apaw_practice.domain.models.garage;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.MechanicEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.PieceEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Vehicle {

    private String id;
    private String carRegistration;
    private String model;
    private BigDecimal estimatedBudget;
    private LocalDateTime receptionDate;
    private LocalDateTime estimatedDeliveryDate;
    private List<PieceEntity> pieceEntities;
    private List<MechanicEntity> mechanicEntities;

    public Vehicle() {
        // empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(BigDecimal estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public LocalDateTime getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(LocalDateTime receptionDate) {
        this.receptionDate = receptionDate;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public List<PieceEntity> getPieceEntities() {
        return pieceEntities;
    }

    public void setPieceEntities(List<PieceEntity> pieceEntities) {
        this.pieceEntities = pieceEntities;
    }

    public List<MechanicEntity> getMechanicEntities() {
        return mechanicEntities;
    }

    public void setMechanicEntities(List<MechanicEntity> mechanicEntities) {
        this.mechanicEntities = mechanicEntities;
    }
}
