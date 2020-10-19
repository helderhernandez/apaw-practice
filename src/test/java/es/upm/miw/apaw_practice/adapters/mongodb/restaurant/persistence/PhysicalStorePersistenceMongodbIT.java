package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class PhysicalStorePersistenceMongodbIT {
    @Autowired
    private PhysicalStorePersistenceMongodb physicalStorePersistenceMongodb;

    @Test
    void testCreateConflict() {
        PhysicalStore physicalStore = new PhysicalStore("address3", 460, false, LocalDateTime.of(2020, 10, 15, 10, 00));
        assertThrows(ConflictException.class, () -> this.physicalStorePersistenceMongodb.create(physicalStore));
    }

    @Test
    void testSearch2() {
        Stream<PhysicalStore> physicalStore = this.physicalStorePersistenceMongodb
                .findAddressPhysicalStoreWithAFoodTypeScoreHigherThan("foodType2",7.0);
        assertEquals("address1", physicalStore.collect(Collectors.toList()).get(0).getAddress());
    }
}
