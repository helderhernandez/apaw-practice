package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.FlightEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class FlightRepositoryIT {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    void testFindAll() {
        List<FlightEntity> flightEntityList = this.flightRepository.findAll();
        assertEquals(3, flightEntityList.size());
        assertEquals("11111", flightEntityList.get(0).getPlaneEntity().getLicensePlate());
        assertEquals("madrid", flightEntityList.get(0).getDestinationCity());
        assertEquals("dublin", flightEntityList.get(1).getDestinationCity());
        assertEquals("london", flightEntityList.get(2).getDestinationCity());
    }

}