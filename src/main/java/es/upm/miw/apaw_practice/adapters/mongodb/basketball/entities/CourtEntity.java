package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import es.upm.miw.apaw_practice.domain.models.basketball.Court;
import es.upm.miw.apaw_practice.domain.models.basketball.CourtCreation;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
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

    public CourtEntity(CourtCreation courtCreation) {
        BeanUtils.copyProperties(courtCreation, this);
        this.id = UUID.randomUUID().toString();
        this.dateMatch = LocalDate.now();
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

    public Court toCourt() {
        Court court = new Court();
        BeanUtils.copyProperties(this, court);
        return court;
    }
}
