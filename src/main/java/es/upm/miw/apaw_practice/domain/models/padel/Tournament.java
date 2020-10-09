package es.upm.miw.apaw_practice.domain.models.padel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Tournament {
    private String id;
    private String name;
    private LocalDateTime startDay;
    private LocalDateTime finishDay;
    private Integer level;
    private List<Player> playerEntities;

    public Tournament() {
        //Empty for framework
    }

    public Tournament(String name, LocalDateTime startDay, LocalDateTime finishDay, Integer level, List<Player> playerEntities) {
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

    public List<Player> getPlayerEntities() {
        return playerEntities;
    }

    public void setPlayerEntities(List<Player> playerEntities) {
        this.playerEntities = playerEntities;
    }


    @Override
    public String toString() {
        return "Tournament{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startDay=" + startDay +
                ", finishDay=" + finishDay +
                ", level=" + level +
                ", players=" + playerEntities +
                '}';
    }
}
