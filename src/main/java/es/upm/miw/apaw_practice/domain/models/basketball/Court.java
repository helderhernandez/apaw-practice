package es.upm.miw.apaw_practice.domain.models.basketball;

import java.time.LocalDate;

public class Court {
    private String id;
    private LocalDate dateMatch;
    private String name;
    private Integer capacity;

    public Court() {
        //Empty constructor for the framework
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
    public String toString() {
        return "Court{" +
                "id='" + id + '\'' +
                ", dateMatch=" + dateMatch +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
