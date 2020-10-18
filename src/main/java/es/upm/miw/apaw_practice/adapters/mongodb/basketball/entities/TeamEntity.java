package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.builders.TeamBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class TeamEntity {
    @Id
    private String id;
    private String name;
    @DBRef
    private List<MemberTeamEntity> players;
    @DBRef
    private List<CourtEntity> courtsToPlay;
    @DBRef
    private CoachEntity coachTeam;

    public  TeamEntity() {
        //Empty constructor for the framework
    }

    public TeamEntity(String name, List<MemberTeamEntity> players, List<CourtEntity> courtsToPlay, CoachEntity coachTeam) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.players = players;
        this.courtsToPlay = courtsToPlay;
        this.coachTeam = coachTeam;
    }

    public  static TeamBuilder.Name builder() {
        return new Builder();
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

    public List<MemberTeamEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<MemberTeamEntity> players) {
        this.players = players;
    }

    public List<CourtEntity> getCourtsToPlay() {
        return courtsToPlay;
    }

    public void setCourtsToPlay(List<CourtEntity> courtsToPlay) {
        this.courtsToPlay = courtsToPlay;
    }

    public CoachEntity getCoachTeam() {
        return coachTeam;
    }

    public void setCoachTeam(CoachEntity coachTeam) {
        this.coachTeam = coachTeam;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (id.equals(((TeamEntity) o).id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", players=" + players +
                ", courtsToPlay=" + courtsToPlay +
                ", coachTeam=" + coachTeam +
                '}';
    }

    public static class Builder implements TeamBuilder.Name, TeamBuilder.Optionals {

        private TeamEntity teamEntity;

        public Builder() {
            this.teamEntity = new TeamEntity();
            this.teamEntity.id = UUID.randomUUID().toString();
        }

        @Override
        public TeamBuilder.Optionals name(String name) {
            this.teamEntity.name = name;
            return this;
        }

        @Override
        public TeamBuilder.Optionals players(List<MemberTeamEntity> players) {
            this.teamEntity.players = players;
            return this;
        }

        @Override
        public TeamBuilder.Optionals courtsToPlay(List<CourtEntity> courtsToPlay) {
            this.teamEntity.courtsToPlay = courtsToPlay;
            return this;
        }

        @Override
        public TeamBuilder.Optionals coachTeam(CoachEntity coachTeam) {
            this.teamEntity.coachTeam = coachTeam;
            return this;
        }

        @Override
        public TeamEntity build() {
            return this.teamEntity;
        }
    }
}
