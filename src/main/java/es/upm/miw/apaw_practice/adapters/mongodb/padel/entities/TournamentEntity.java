package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document
public class TournamentEntity {
    @Id
    private String id;
    private String name;
    private LocalDateTime startDay;
    private LocalDateTime finishDay;
    private Integer level;
    private List<PlayerEntity> playerEntities;

    public TournamentEntity() {
        //Empty for framework
    }

    public TournamentEntity(String name, LocalDateTime startDay, LocalDateTime finishDay, Integer level, List<PlayerEntity> playerEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.startDay = startDay;
        this.finishDay = finishDay;
        this.level = level;
        this.playerEntities = playerEntities;
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

    public LocalDateTime getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDateTime startDay) {
        this.startDay = startDay;
    }

    public LocalDateTime getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(LocalDateTime finishDay) {
        this.finishDay = finishDay;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<PlayerEntity> getPlayerEntities() {
        return playerEntities;
    }

    public void setPlayerEntities(List<PlayerEntity> playerEntities) {
        this.playerEntities = playerEntities;
    }
    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((PlayerEntity) obj).getId()));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "TournamentEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startDay=" + startDay +
                ", finishDay=" + finishDay +
                ", level=" + level +
                ", playerEntities=" + playerEntities +
                '}';
    }
}
