package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.InstructorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SessionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class SessionEntityRepositoryIT {

    @Autowired
    private SessionRepository sessionRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.sessionRepository.findById("S01").isPresent());
        SessionEntity session = this.sessionRepository.findById("S01").get();
        assertEquals(2, session.getRoomNumber());
        assertTrue(session.getAssistants().stream()
                .map(AssistantEntity::getName)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("Julia", "Elena")));

        assertTrue(this.sessionRepository.findById("S00").isPresent());
        SessionEntity session1 = this.sessionRepository.findById("S00").get();
        assertEquals(1, session1.getRoomNumber());
        assertEquals(0, session1.getAssistants().stream().count());
    }


}
