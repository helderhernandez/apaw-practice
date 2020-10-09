package es.upm.miw.apaw_practice.domain.models.transport;

public class ExtraPaidUpdate {
    private String id;
    private Boolean paid;

    public ExtraPaidUpdate() {
        //empty for framework
    }

    public ExtraPaidUpdate(String id, Boolean paid) {
        this.id = id;
        this.paid = paid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "ExtraPaidUpdate{" +
                "id='" + id + '\'' +
                ", paid=" + paid +
                '}';
    }
}
