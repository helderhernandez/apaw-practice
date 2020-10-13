package es.upm.miw.apaw_practice.domain.models.videogame;

import java.util.List;

public class Level {

    private String id;
    private String description;
    private Integer maxTimeAllowed;
    private Integer recordPoints;
    private List<GamePlayer> gamePlayerList;
    private GameDeveloper gameDeveloper;

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

    public List<GamePlayer> getGamePlayerList() {
        return gamePlayerList;
    }

    public void setGamePlayerList(List<GamePlayer> gamePlayerList) {
        this.gamePlayerList = gamePlayerList;
    }

    public GameDeveloper getGameDeveloper() {
        return gameDeveloper;
    }

    public void setGameDeveloper(GameDeveloper gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", maxTimeAllowed=" + maxTimeAllowed +
                ", recordPoints=" + recordPoints +
                ", gamePlayerList=" + gamePlayerList +
                ", gameDeveloper=" + gameDeveloper +
                '}';
    }
}
