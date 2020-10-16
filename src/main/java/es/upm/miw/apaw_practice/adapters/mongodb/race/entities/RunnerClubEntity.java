package es.upm.miw.apaw_practice.adapters.mongodb.race.entities;

import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class RunnerClubEntity {
    @Id
    private String id;
    private String name;
    private String location;
    private LocalDateTime foundationDate;

    public RunnerClubEntity() {
        // empty for framework
    }

    public RunnerClubEntity(String id, String name, String location, LocalDateTime foundationDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.foundationDate = foundationDate;
    }

    public RunnerClubEntity(RunnerClubCreation runnerClubCreation) {
        this.id = UUID.randomUUID().toString();
        this.name = runnerClubCreation.getName();
        this.location = runnerClubCreation.getLocation();
        this.foundationDate = runnerClubCreation.getFoundationDate();
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

    public LocalDateTime getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDateTime foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((RunnerClubEntity) obj).name));
    }

    @Override
    public String toString() {
        return "RunnerClubEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }

    public RunnerClub toRunnerClub() {
        RunnerClub runnerClub = new RunnerClub();
        BeanUtils.copyProperties(this, runnerClub);
        return runnerClub;
    }

    public void fromRunnerClub(RunnerClub runnerClub) {
        BeanUtils.copyProperties(runnerClub, this);
    }
}
