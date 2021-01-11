package es.upm.miw.apaw_practice.domain.models.studio;


import java.time.LocalDateTime;

public class Appointment {
    private String id;
    private LocalDateTime date;
    private Boolean isActive;

    public Appointment() {
        // Empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", isActive=" + isActive +
                '}';
    }
}
