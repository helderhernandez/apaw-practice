package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.CoachEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CoachEntityRepositoryIT {

    @Autowired
    private CoachRepository coachRepository;

    @Test
    void testFindCoachByDni() {
        assertTrue(this.coachRepository.findByDni("32222222C").isPresent());
        CoachEntity coach = this.coachRepository.findByDni("32222222C").get();
        assertEquals("Pablo", coach.getName());
        assertNotNull(coach.getId());
        assertEquals("32222222C", coach.getDni());
    }
}
