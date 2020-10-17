package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class AccidentEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String refAccident;
    private LocalDateTime date;
    private String place;

    public AccidentEntity() {
        //empty from framework
    }

    public AccidentEntity(String id, String refAccident, LocalDateTime date, String place) {
        this.id = id;
        this.refAccident = refAccident;
        this.date = date;
        this.place = place;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Accident toAccident() {
        Accident accident = new Accident();
        BeanUtils.copyProperties(this, accident);
        return accident;
    }
}
