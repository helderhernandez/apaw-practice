package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.ticketbus.Journey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class JourneyPersistenceMongodbIT {

    @Autowired
    private JourneyPersistenceMongodb journeyPersistenceMongodb;

    void testJourney(Journey journey){
        assertNotNull(journey);
        assertNotNull(journey.getId());
        assertEquals("Madrid", journey.getDeparture());
        assertEquals("Barcelona", journey.getArrive());
        assertEquals(5, journey.getNumStops());
    }

    @Test
    void testFindAll(){
        List<Journey> journeys = journeyPersistenceMongodb.findAll().collect(Collectors.toList());
        assertNotNull(journeys);
        assertEquals(2, journeys.size());
        testJourney(journeys.get(0));
    }
}
