package es.upm.miw.apaw_practice.domain.models.race;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Race {
    private String id;
    private String name;
    private String location;
    private LocalDateTime date;
    private BigDecimal prize;
    private List<Section> sections;
    private List<Runner> runners;

    public Race() {
        // empty for framework
    }

    public Race(String id, String name, String location, LocalDateTime date, BigDecimal prize, List<Section> sections, List<Runner> runners) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.prize = prize;
        this.sections = sections;
        this.runners = runners;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Runner> getRunners() {
        return runners;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((Race) obj).id));
    }

    @Override
    public String toString() {
        return "Race{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", prize=" + prize +
                ", sections=" + sections +
                ", runners=" + runners +
                '}';
    }
}
