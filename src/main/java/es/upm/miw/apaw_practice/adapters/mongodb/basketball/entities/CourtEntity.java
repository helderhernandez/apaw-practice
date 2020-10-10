package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class CourtEntity {
    @Id
    private String id;
    private LocalDate dateMatch;
    private String name;
    private Integer capacity;

    public CourtEntity() {
        //Empty constructor for the framework
    }

    public CourtEntity(String name, Integer capacity) {
        this.id = UUID.randomUUID().toString();
        this.dateMatch = LocalDate.now();
        this.name = name;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(LocalDate dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
