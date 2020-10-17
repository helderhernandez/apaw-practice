package es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.builders;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CoachEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CourtEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.MemberTeamEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamEntity;

import java.util.List;

public interface TeamBuilder {

    interface Name {
        Optionals name(String name);
    }

    interface Optionals {
        Optionals players(List<MemberTeamEntity> players);
        Optionals courtsToPlay(List<CourtEntity> courtsToPlay);
        Optionals coachTeam(CoachEntity coachTeam);
        TeamEntity build();
    }
}
