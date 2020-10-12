package es.upm.miw.apaw_practice.adapters.rest.garage;

import java.math.BigDecimal;

public class VehicleEstimatedBudgetUpdating {
    private String carRegistration;
    private BigDecimal estimatedBudget;

    public VehicleEstimatedBudgetUpdating() {
        // empty for framework
    }

    public VehicleEstimatedBudgetUpdating(String carRegistration, BigDecimal estimatedBudget) {
        this.carRegistration = carRegistration;
        this.estimatedBudget = estimatedBudget;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public BigDecimal getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(BigDecimal estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }
}
