package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig

public class OwnerPersistenceMongodbIT {

    @Autowired
    private OwnerPersistenceMongodb ownerPersistenceMongodb;

    @Test
    void testDelete() {
        ownerPersistenceMongodb.deleteById("ow2");
        Owner owner = new Owner();
        owner.setDni("00000000C");
        owner.setFamilyName("Jhon");
        owner.setName("Smith");
        Owner owner2 = ownerPersistenceMongodb.create(owner);
        assertEquals(owner.getDni(), owner2.getDni());
    }
}
