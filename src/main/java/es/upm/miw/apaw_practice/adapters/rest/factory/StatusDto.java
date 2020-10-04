package es.upm.miw.apaw_practice.adapters.rest.factory;

public class StatusDto {
    private Boolean isActive;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "StatusDto{" +
                "isActive=" + isActive +
                '}';
    }
}
