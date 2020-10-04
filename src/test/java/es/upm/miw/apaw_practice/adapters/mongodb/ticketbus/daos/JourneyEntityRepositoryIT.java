package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class JourneyEntityRepositoryIT {

    @Autowired
    private JourneyRepository journeyRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(journeyRepository.findAll().stream()
                .anyMatch(journey ->
                        "Madrid".equals(journey.getDeparture()) &&
                                "Barcelona".equals(journey.getArrive()) &&
                                Integer.valueOf(5).equals(journey.getNumStops())
                )
        );
    }

}
