package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities;

import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloper;
import es.upm.miw.apaw_practice.domain.models.videogame.GamePlayer;
import es.upm.miw.apaw_practice.domain.models.videogame.Level;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class LevelEntity {

    @Id
    private String id;
    private String description;
    private Integer maxTimeAllowed;
    private Integer recordPoints;
    @DBRef
    private List<GamePlayerEntity> gamePlayerEntities;
    private GameDeveloperEntity gameDeveloperEntity;

    public LevelEntity() {
        //empty from framework
    }

    public LevelEntity(String description, Integer maxTimeAllowed, Integer recordPoints, List<GamePlayerEntity> gamePlayerEntities, GameDeveloperEntity gameDeveloperEntity) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.maxTimeAllowed = maxTimeAllowed;
        this.recordPoints = recordPoints;
        this.gamePlayerEntities = gamePlayerEntities;
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

    public List<GamePlayerEntity> getGamePlayerEntities() {
        return gamePlayerEntities;
    }

    public void setGamePlayerEntity(List<GamePlayerEntity> gamePlayerEntity) {
        this.gamePlayerEntities = gamePlayerEntities;
    }

    public GameDeveloperEntity getGameDeveloperEntity() {
        return gameDeveloperEntity;
    }

    public void setGameDeveloperEntity(GameDeveloperEntity gameDeveloperEntity) {
        this.gameDeveloperEntity = gameDeveloperEntity;
    }

    public Level toLevel(){
        Level level = new Level();
        GameDeveloper gameDeveloper = this.gameDeveloperEntity.toGameDeveloper();
        BeanUtils.copyProperties(this, level, new String []{"gamePlayerEntities","gameDeveloperEntity"});
        List <GamePlayer> gamePlayerList = this.gamePlayerEntities.stream()
                .map(GamePlayerEntity::toGamePlayer)
                .collect(Collectors.toList());
        level.setGameDeveloper(gameDeveloper);

        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelEntity that = (LevelEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(gamePlayerEntities, that.gamePlayerEntities) &&
                Objects.equals(gameDeveloperEntity, that.gameDeveloperEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, gamePlayerEntities, gameDeveloperEntity);
    }

    @Override
    public String toString() {
        return "LevelEntity{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", maxTimeAllowed=" + maxTimeAllowed +
                ", recordPoints=" + recordPoints +
                ", playerEntity=" + gamePlayerEntities +
                ", gameDeveloperEntity=" + gameDeveloperEntity +
                '}';
    }
}
