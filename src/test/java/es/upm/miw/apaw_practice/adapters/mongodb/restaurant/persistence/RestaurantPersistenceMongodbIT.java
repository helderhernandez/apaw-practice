package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@TestConfig
public class RestaurantPersistenceMongodbIT {
    @Autowired
    private RestaurantPersistenceMongodb restaurantPersistenceMongodb;

    @Test
    void testReadAll() {
        System.out.println(this.restaurantPersistenceMongodb.readAll()
        .collect(Collectors.toList()));
    }
}
