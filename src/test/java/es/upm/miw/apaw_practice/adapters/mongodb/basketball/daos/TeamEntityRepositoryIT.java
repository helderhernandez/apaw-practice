package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CoachEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.TeamEntity;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class TeamEntityRepositoryIT {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.teamRepository.findAll().stream()
        .anyMatch(team ->
                "Valencia Basket".equals(team.getName()) &&
                        team.getId() != null &&
                        "Victor".equals(team.getCoachTeam().getName()) &&
                        "Leonor".equals(team.getPlayers().get(0).getName()) &&
                        15500 == team.getCourtsToPlay().get(0).getCapacity()
        ));
    }

    @Test
    void testTeamBuilder() {
        TeamEntity teamEntity = TeamEntity.builder()
                .name("Junior Valencia")
                .coachTeam(new CoachEntity(new CoachCreation("Juan", "45678912H")))
                .build();

        assertEquals("Junior Valencia", teamEntity.getName());
        assertNotNull(teamEntity.getCoachTeam());
        assertNull(teamEntity.getCourtsToPlay());
        assertNull(teamEntity.getPlayers());
        assertNotNull(teamEntity.getId());
    }

}
