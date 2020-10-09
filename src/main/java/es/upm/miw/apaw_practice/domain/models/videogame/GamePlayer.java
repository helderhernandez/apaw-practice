package es.upm.miw.apaw_practice.domain.models.videogame;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.ChallengeEntity;

import java.time.LocalDateTime;
import java.util.List;

public class GamePlayer {
    private String id;
    private String nickName;
    private LocalDateTime signUpDate;
    private Integer points;
    private Boolean isPremiumPlayer;
    private List<ChallengeEntity> challengeEntities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDateTime getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(LocalDateTime signUpDate) {
        this.signUpDate = signUpDate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getPremiumPlayer() {
        return isPremiumPlayer;
    }

    public void setPremiumPlayer(Boolean premiumPlayer) {
        isPremiumPlayer = premiumPlayer;
    }

    public List<ChallengeEntity> getChallengeEntities() {
        return challengeEntities;
    }

    public void setChallengeEntities(List<ChallengeEntity> challengeEntities) {
        this.challengeEntities = challengeEntities;
    }

    @Override
    public String toString() {
        return "GamePlayer{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signUpDate=" + signUpDate +
                ", points=" + points +
                ", isPremiumPlayer=" + isPremiumPlayer +
                ", challengeEntities=" + challengeEntities +
                '}';
    }
}
