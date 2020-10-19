package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.OwnerRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.OwnerRestaurantEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurantUpdate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class OwnerRestaurantPersistenceMongodbIT {

    @Autowired
    OwnerRestaurantPersistenceMongodb ownerRestaurantPersistenceMongodb;

    @Autowired
    OwnerRestaurantRepository ownerRestaurantRepository;

    @Test
    void testUpdateOwnerNotFound() {
        OwnerRestaurantUpdate ownerRestaurantUpdate = new OwnerRestaurantUpdate("name8", "familyName8");
        assertThrows(NotFoundException.class,
                () -> this.ownerRestaurantPersistenceMongodb
                        .updateOwner("tag8", ownerRestaurantUpdate));
    }

    @Test
    void testUpdateOwner() {
        List<OwnerRestaurantEntity> ownerRestaurantList = ownerRestaurantRepository.findAll();
        OwnerRestaurantUpdate ownerRestaurantUpdate = new OwnerRestaurantUpdate("name8", "familyName8");
        assertEquals("name8", this.ownerRestaurantPersistenceMongodb
                .updateOwner(ownerRestaurantList.get(3).getId(), ownerRestaurantUpdate).getName());
    }
}
