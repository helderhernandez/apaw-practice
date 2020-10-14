package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.restaurant.PhysicalStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

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
}
