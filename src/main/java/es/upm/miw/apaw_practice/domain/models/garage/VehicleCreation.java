package es.upm.miw.apaw_practice.domain.models.garage;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VehicleCreation {

    private String carRegistration;
    private String model;
    private BigDecimal estimatedBudget;
    private LocalDateTime receptionDate;
    private LocalDateTime estimatedDeliveryDate;

    public VehicleCreation() {
        // empty for framework
    }

    public VehicleCreation(String carRegistration, String model, BigDecimal estimatedBudget, LocalDateTime receptionDate, LocalDateTime estimatedDeliveryDate) {
        this.carRegistration = carRegistration;
        this.model = model;
        this.estimatedBudget = estimatedBudget;
        this.receptionDate = receptionDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
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
}
