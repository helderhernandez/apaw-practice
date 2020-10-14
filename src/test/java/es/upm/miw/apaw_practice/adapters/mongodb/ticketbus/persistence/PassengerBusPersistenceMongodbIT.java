package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class PassengerBusPersistenceMongodbIT {

    @Autowired
    private PassengerBusPersistenceMongodb passengerBusPersistenceMongodb;

    @Autowired
    private JourneyPersistenceMongodb journeyPersistenceMongodb;

    @Test
    void testFindJourneysByPassengerName() {

        String idJourney = journeyPersistenceMongodb.findIdByDepartureAndArrive("Madrid", "Barcelona");

        boolean hasJourney = passengerBusPersistenceMongodb.findIdJourneysFromNamePassenger("Ana")
                .anyMatch(idJourney::equals);

        assertEquals(Boolean.TRUE, hasJourney);
    }

    @Test
    void testFindJourneysByPassengerNameNotFound() {

        Long numResults = passengerBusPersistenceMongodb.findIdJourneysFromNamePassenger("Beatriz")
                .count();

        assertEquals(0L, numResults);
    }
}
