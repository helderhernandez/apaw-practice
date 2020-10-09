package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities;

import es.upm.miw.apaw_practice.domain.models.airport.Plane;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.models.videogame.GamePlayer;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class GamePlayerEntity {

    @Id
    private String id;
    private String nickName;
    private LocalDateTime signUpDate;
    private Integer points;
    private Boolean isPremiumPlayer;
    private List<ChallengeEntity> challengeEntities;

    public GamePlayerEntity() {
        //empty for framework
    }


    public GamePlayerEntity(String nickName, Integer points, Boolean isPremiumPlayer, List<ChallengeEntity> challengeEntities) {
        this.id = UUID.randomUUID().toString();
        this.nickName = nickName;
        this.signUpDate = LocalDateTime.now();
        this.points = points;
        this.isPremiumPlayer = isPremiumPlayer;
        this.challengeEntities = challengeEntities;
    }

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

    public GamePlayer toGamePlayer(){
        GamePlayer gamePlayer = new GamePlayer();
        BeanUtils.copyProperties(this, gamePlayer, "challengeEntities");
        List<Challenge> challengeList = this.challengeEntities.stream()
                .map(ChallengeEntity::toChallenge)
                .collect(Collectors.toList());

        return gamePlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePlayerEntity that = (GamePlayerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nickName, that.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName);
    }



    @Override
    public String toString() {
        return "PlayerEntity{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", signUpDate=" + signUpDate +
                ", points=" + points +
                ", isPremiumPlayer=" + isPremiumPlayer +
                ", challengeEntities=" + challengeEntities +
                '}';
    }
}
