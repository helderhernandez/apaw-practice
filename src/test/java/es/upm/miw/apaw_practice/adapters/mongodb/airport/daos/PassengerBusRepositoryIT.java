package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class PassengerBusRepositoryIT {

    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    void testFindAll() {
        List<PassengerEntity> passengerRepositoryList = passengerRepository.findAll();

        assertEquals(2, passengerRepositoryList.size());
        assertEquals("sergio", passengerRepositoryList.get(0).getName());
        assertEquals("11112", passengerRepositoryList.get(0).getFlightEntities().get(1).getPlaneEntity().getLicensePlate());
        assertEquals("white", passengerRepositoryList.get(1).getSuitcaseEntities().get(0).getColor());
    }

}