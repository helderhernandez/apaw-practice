package es.upm.miw.apaw_practice.adapters.mongodb.race.entities;

import es.upm.miw.apaw_practice.domain.models.race.Race;
import es.upm.miw.apaw_practice.domain.models.race.Runner;
import es.upm.miw.apaw_practice.domain.models.race.Section;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Document
public class RaceEntity {
    @Id
    private String id;
    private String name;
    private String location;
    private LocalDateTime date;
    private BigDecimal prize;
    private List<SectionEntity> sectionEntities;
    @DBRef
    private List<RunnerEntity> runnerEntities;

    public RaceEntity() {
        // empty for framework
    }

    public RaceEntity(String id, String name, String location, LocalDateTime date, BigDecimal prize, List<SectionEntity> sectionEntities, List<RunnerEntity> runnerEntities) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.prize = prize;
        this.sectionEntities = sectionEntities;
        this.runnerEntities = runnerEntities;
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

    public List<SectionEntity> getSectionEntities() {
        return sectionEntities;
    }

    public void setSectionEntities(List<SectionEntity> sectionEntities) {
        this.sectionEntities = sectionEntities;
    }

    public List<RunnerEntity> getRunnerEntities() {
        return runnerEntities;
    }

    public void setRunnerEntities(List<RunnerEntity> runnerEntities) {
        this.runnerEntities = runnerEntities;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((RaceEntity) obj).id));
    }

    @Override
    public String toString() {
        return "RaceEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", prize=" + prize +
                ", sectionEntities=" + sectionEntities +
                ", runnerEntities=" + runnerEntities +
                '}';
    }

    public Race toRace() {
        List<Section> sections = this.sectionEntities.stream()
                .map(SectionEntity::toSection)
                .collect(Collectors.toList());
        List<Runner> runners = this.runnerEntities.stream()
                .map(RunnerEntity::toRunner)
                .collect(Collectors.toList());
        return new Race(this.id, this.name, this.location, this.date, this.prize, sections, runners);
    }
}
