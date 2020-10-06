package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class LevelEntity {

    @Id
    private String id;
    private String description;
    private Integer maxTimeAllowed;
    private Integer recordPoints;
    @DBRef
    private List<GamePlayerEntity> gamePlayerEntity;
    private GameDeveloperEntity gameDeveloperEntity;

    public LevelEntity() {
        //empty from framework
    }

    public LevelEntity(String description, Integer maxTimeAllowed, Integer recordPoints, List<GamePlayerEntity> gamePlayerEntity, GameDeveloperEntity gameDeveloperEntity) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.maxTimeAllowed = maxTimeAllowed;
        this.recordPoints = recordPoints;
        this.gamePlayerEntity = gamePlayerEntity;
        this.gameDeveloperEntity = gameDeveloperEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxTimeAllowed() {
        return maxTimeAllowed;
    }

    public void setMaxTimeAllowed(Integer maxTimeAllowed) {
        this.maxTimeAllowed = maxTimeAllowed;
    }

    public Integer getRecordPoints() {
        return recordPoints;
    }

    public void setRecordPoints(Integer recordPoints) {
        this.recordPoints = recordPoints;
    }

    public List<GamePlayerEntity> getGamePlayerEntity() {
        return gamePlayerEntity;
    }

    public void setGamePlayerEntity(List<GamePlayerEntity> gamePlayerEntity) {
        this.gamePlayerEntity = gamePlayerEntity;
    }

    public GameDeveloperEntity getGameDeveloperEntity() {
        return gameDeveloperEntity;
    }

    public void setGameDeveloperEntity(GameDeveloperEntity gameDeveloperEntity) {
        this.gameDeveloperEntity = gameDeveloperEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelEntity that = (LevelEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(gamePlayerEntity, that.gamePlayerEntity) &&
                Objects.equals(gameDeveloperEntity, that.gameDeveloperEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, gamePlayerEntity, gameDeveloperEntity);
    }

    @Override
    public String toString() {
        return "LevelEntity{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", maxTimeAllowed=" + maxTimeAllowed +
                ", recordPoints=" + recordPoints +
                ", playerEntity=" + gamePlayerEntity +
                ", gameDeveloperEntity=" + gameDeveloperEntity +
                '}';
    }
}
