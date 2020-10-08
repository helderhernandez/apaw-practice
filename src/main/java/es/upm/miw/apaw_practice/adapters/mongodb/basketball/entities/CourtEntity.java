package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class CourtEntity {
    @Id
    private String id;
    private LocalDateTime dateMatch;
    private Integer numberTeams;
    private Integer capacity;

    public CourtEntity() {
        //Empty constructor for the framework
    }

    public CourtEntity(LocalDateTime dateMatch, Integer numberTeams, Integer capacity) {
        this.id = UUID.randomUUID().toString();
        this.dateMatch = dateMatch;
        this.numberTeams = numberTeams;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(LocalDateTime dateMatch) {
        this.dateMatch = dateMatch;
    }

    public Integer getNumberTeams() {
        return numberTeams;
    }

    public void setNumberTeams(Integer numberTeams) {
        this.numberTeams = numberTeams;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (id.equals(((CourtEntity) o).id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "CourtEntity{" +
                "id='" + id + '\'' +
                ", dateMatch=" + dateMatch +
                ", numberTeams=" + numberTeams +
                ", capacity=" + capacity +
                '}';
    }
}
