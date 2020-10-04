package es.upm.miw.apaw_practice.adapters.rest.factory;

public class StatusDto {
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusDto{" +
                "status=" + status +
                '}';
    }
}
