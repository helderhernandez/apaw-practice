package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class FlightPersistenceMongodbIT {

    @Autowired
    private FlightPersistenceMongodb flightPersistence;

    @Test
    void testReadAll() {
        List<Flight> flightList = flightPersistence
                .readAll().collect(Collectors.toList());
        assertEquals("madrid", flightList.get(0).getDestinationCity());
        assertEquals("11112", flightList.get(1).getPlane().getLicensePlate());
    }

    @Test
    void testReadByIdNotFound() {
        assertThrows(NotFoundException.class, () -> flightPersistence.readById("aa"));
    }

    @Test
    void testUpdateNotFound() {
        Flight flight = new Flight();
        flight.setId("aa");
        assertThrows(NotFoundException.class, () -> flightPersistence.update(flight));
    }

    @Test
    void testUpdate() {
        Flight flight = flightPersistence.readAll().collect(Collectors.toList()).get(0);
        flight.setPrice(new BigDecimal(5));
        Flight updatedFlight = flightPersistence.update(flight);
        assertEquals(new BigDecimal(5), updatedFlight.getPrice());
    }
}
