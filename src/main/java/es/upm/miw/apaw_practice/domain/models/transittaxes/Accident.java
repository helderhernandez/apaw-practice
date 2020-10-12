package es.upm.miw.apaw_practice.domain.models.transittaxes;


import java.time.LocalDateTime;

public class Accident {

    private String refAccident;
    private LocalDateTime date;
    private String place;

    public Accident() {
        //empty from framework
    }

    public String getRefAccident() {
        return refAccident;
    }

    public void setRefAccident(String refAccident) {
        this.refAccident = refAccident;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
