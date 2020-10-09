package es.upm.miw.apaw_practice.adapters.mongodb.basketball.dao;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
                        "Profesional".equals(team.getCategory()) &&
                        "Victor".equals(team.getCoachTeam().getName()) &&
                        "Leonor".equals(team.getPlayers().get(0).getName()) &&
                        15500 == team.getCourtsToPlay().get(0).getCapacity()
        ));
    }
}
