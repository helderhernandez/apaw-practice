package es.upm.miw.apaw_practice.domain.models.factory;

import java.time.LocalDate;

public class Machine {
    private String id;
    private Long serialNumber;
    private Boolean isActive;
    private LocalDate lastInspection;

    public Machine() {
        // empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getLastInspection() {
        return lastInspection;
    }

    public void setLastInspection(LocalDate lastInspection) {
        this.lastInspection = lastInspection;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id='" + id + '\'' +
                ", serialNumber=" + serialNumber +
                ", isActive=" + isActive +
                ", lastInspection=" + lastInspection +
                '}';
    }
}
