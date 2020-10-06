package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class FlightPersistenceMongodbIT {

    @Autowired
    private FlightPersistenceMongodb flightPersistence;

    @Test
    void testReadAll() {
        List<Flight> flightList = flightPersistence
                .readAll().collect(Collectors.toList());
        assertEquals(3, flightList.size());
        assertEquals("madrid", flightList.get(0).getDestinationCity());
        assertEquals("11112", flightList.get(1).getPlane().getLicensePlate());
    }
}
