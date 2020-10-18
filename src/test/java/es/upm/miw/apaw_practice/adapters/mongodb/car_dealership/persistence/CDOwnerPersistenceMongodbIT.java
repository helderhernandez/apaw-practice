package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestConfig
public class CDOwnerPersistenceMongodbIT {

    @Autowired
    private CDOwnerPersistenceMongodb cdOwnerPersistenceMongodb;

    @Test
    void testFindOwnerByBrand() {
        assertEquals(Arrays.asList("Pedro", "Manuel"), this.cdOwnerPersistenceMongodb.findOwnerByBrand("Opel").collect(Collectors.toList()));
    }

    @Test
    void testFindOwnerByBrandNotFound() {
        assertEquals(Arrays.asList(), this.cdOwnerPersistenceMongodb.findOwnerByBrand("Mercedes").collect(Collectors.toList()));
    }
}
