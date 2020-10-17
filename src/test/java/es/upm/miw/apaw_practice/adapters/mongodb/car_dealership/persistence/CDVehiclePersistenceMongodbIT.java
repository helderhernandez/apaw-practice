package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.persistence.CDVehiclePersistenceMongodb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class CDVehiclePersistenceMongodbIT {

    @Autowired
    CDVehiclePersistenceMongodb vehiclePersistenceMongodb;

    @Test
    void testFindBrandsByEmployeeName() {
        assertEquals(Arrays.asList("Seat","Citroen","Opel"), vehiclePersistenceMongodb.findBrandsByEmployeeName("Pablo Coronado").collect(Collectors.toList()));
    }
}
