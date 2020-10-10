package es.upm.miw.apaw_practice.domain.models.transport;

public class Extra {

    private String id;
    private Integer workedHours;
    private Boolean paid;

    public Extra() {
        //empty for framework
    }

    public Extra(String id, Integer workedHours, Boolean paid) {
        this.id = id;
        this.workedHours = workedHours;
        this.paid = paid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "id='" + id + '\'' +
                ", workedHours=" + workedHours +
                ", paid=" + paid +
                '}';
    }

}
