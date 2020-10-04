package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class LevelEntity {

    @Id
    private String id;
    private String description;
    private Duration maxTimeAllowed;
    private Integer recordPoints;
    @DBRef
    private List<GamePlayerEntity> playerEntity;
    private GameDeveloperEntity gameDeveloperEntity;

    public LevelEntity() {
        //empty from framework
    }

    public LevelEntity(String id, String description, Duration maxTimeAllowed, Integer recordPoints, List<GamePlayerEntity> playerEntity, GameDeveloperEntity gameDeveloperEntity) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.maxTimeAllowed = maxTimeAllowed;
        this.recordPoints = recordPoints;
        this.playerEntity = playerEntity;
        this.gameDeveloperEntity = gameDeveloperEntity;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Duration getMaxTimeAllowed() { return maxTimeAllowed; }

    public void setMaxTimeAllowed(Duration maxTimeAllowed) { this.maxTimeAllowed = maxTimeAllowed; }

    public Integer getRecordPoints() { return recordPoints; }

    public void setRecordPoints(Integer recordPoints) { this.recordPoints = recordPoints; }

    public List<GamePlayerEntity> getPlayerEntity() { return playerEntity; }

    public void setPlayerEntity(List<GamePlayerEntity> playerEntity) { this.playerEntity = playerEntity; }

    public GameDeveloperEntity getGameDeveloperEntity() { return gameDeveloperEntity; }

    public void setGameDeveloperEntity(GameDeveloperEntity gameDeveloperEntity) { this.gameDeveloperEntity = gameDeveloperEntity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelEntity that = (LevelEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(playerEntity, that.playerEntity) &&
                Objects.equals(gameDeveloperEntity, that.gameDeveloperEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, playerEntity, gameDeveloperEntity);
    }

    @Override
    public String toString() {
        return "LevelEntity{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", maxTimeAllowed=" + maxTimeAllowed +
                ", recordPoints=" + recordPoints +
                ", playerEntity=" + playerEntity +
                ", gameDeveloperEntity=" + gameDeveloperEntity +
                '}';
    }
}
