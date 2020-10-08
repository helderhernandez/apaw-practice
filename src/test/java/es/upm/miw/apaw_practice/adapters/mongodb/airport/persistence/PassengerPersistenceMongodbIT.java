package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class PassengerPersistenceMongodbIT {

    @Autowired
    private PassengerPersistenceMongodb passengerPersistenceMongodb;

    @Test
    void testFindDistinctNameUserByModelPlane() {
        List<Passenger> passengerList = passengerPersistenceMongodb
                .findDistinctNameUserByModelPlane("model1")
                .collect(Collectors.toList());

        assertEquals("sergio", passengerList.get(0).getName());
        assertEquals("red", passengerList.get(0).getSuitcaseList().get(0).getColor());

    }
}
