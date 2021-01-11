package es.upm.miw.apaw_practice.adapters.mongodb.studio.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class AppointmentEntity {
    @Id
    private String id;
    private LocalDateTime date;
    private Boolean isActive;
    private DesignEntity designEntity;

    public AppointmentEntity() {
        // Empty for framework
    }

    public AppointmentEntity(LocalDateTime date, Boolean isActive, DesignEntity designEntity) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.isActive = isActive;
        this.designEntity = designEntity;
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

    public DesignEntity getDesignEntity() {
        return designEntity;
    }

    public void setDesignEntity(DesignEntity designEntity) {
        this.designEntity = designEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppointmentEntity)) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "AppointmentEntity{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", isActive=" + isActive +
                ", designEntity=" + designEntity +
                '}';
    }
}


