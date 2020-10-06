package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

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

    public AccidentEntity(String refAccident, LocalDateTime date, String place) {
        this.id = UUID.randomUUID().toString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccidentEntity that = (AccidentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(refAccident, that.refAccident) &&
                Objects.equals(date, that.date) &&
                Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, refAccident, date, place);
    }

    @Override
    public String toString() {
        return "AccidentEntity{" +
                "id='" + id + '\'' +
                ", refAccident='" + refAccident + '\'' +
                ", date=" + date +
                ", place='" + place + '\'' +
                '}';
    }
}
