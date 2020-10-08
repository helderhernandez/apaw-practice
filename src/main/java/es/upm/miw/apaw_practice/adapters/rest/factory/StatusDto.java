package es.upm.miw.apaw_practice.adapters.rest.factory;

public class StatusDto {
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "StatusDto{" +
                "active=" + active +
                '}';
    }
}
