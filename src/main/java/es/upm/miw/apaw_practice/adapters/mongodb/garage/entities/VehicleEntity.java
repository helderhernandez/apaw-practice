package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import es.upm.miw.apaw_practice.domain.models.garage.VehicleCreation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document
public class VehicleEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String carRegistration;
    private String model;
    private BigDecimal estimatedBudget;
    private LocalDateTime receptionDate;
    private LocalDateTime estimatedDeliveryDate;
    @DBRef
    private List<PieceEntity> pieceEntities;
    @DBRef
    private List<MechanicEntity> mechanicEntities;

    public VehicleEntity() {
        //empty for framework
    }

    public VehicleEntity(String carRegistration, String model, BigDecimal estimatedBudget, LocalDateTime receptionDate, LocalDateTime estimatedDeliveryDate) {
        this.id = UUID.randomUUID().toString();
        this.carRegistration = carRegistration;
        this.model = model;
        this.estimatedBudget = estimatedBudget;
        this.receptionDate = receptionDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public VehicleEntity(VehicleCreation vehicleCreation) {
        this.id = UUID.randomUUID().toString();
        this.carRegistration = vehicleCreation.getCarRegistration();
        this.model = vehicleCreation.getModel();
        this.estimatedBudget = vehicleCreation.getEstimatedBudget();
        this.receptionDate = vehicleCreation.getReceptionDate();
        this.estimatedDeliveryDate = vehicleCreation.getEstimatedDeliveryDate();
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
