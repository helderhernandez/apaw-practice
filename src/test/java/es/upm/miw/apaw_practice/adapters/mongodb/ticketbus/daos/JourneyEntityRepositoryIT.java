package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.JourneyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class JourneyEntityRepositoryIT {

    @Autowired
    private JourneyRepository journeyRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(journeyRepository.findAll().stream()
                .anyMatch(journey ->
                        journey.getReference() != null &&
                                "Madrid".equals(journey.getDeparture()) &&
                                "Barcelona".equals(journey.getArrive()) &&
                                Integer.valueOf(5).equals(journey.getNumStops()) &&
                                !"".equals(journey.toString())
                )
        );
    }

    @Test
    void testEquals(){
        JourneyEntity journeyEntity = journeyRepository.findAll().stream()
                .findFirst()
                .get();

        JourneyEntity journeyTest= new JourneyEntity();
        journeyTest.setDeparture(journeyEntity.getDeparture());
        journeyTest.setArrive(journeyEntity.getArrive());
        journeyTest.setNumStops(journeyEntity.getNumStops());
        journeyTest.setId(journeyEntity.getId());
        journeyTest.setReference(journeyEntity.getReference());
        journeyTest.setRegistrationDate(journeyEntity.getRegistrationDate());

        assertEquals(journeyEntity, journeyTest);
    }

}
