package es.upm.miw.apaw_practice.adapters.mongodb.airport.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.airport.Plane;
import es.upm.miw.apaw_practice.domain.models.airport.PlaneCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class PlanePersistenceMongodbIT {

    @Autowired
    private PlanePersistenceMongodb planePersistence;

    @Test
    void testCreate() {
        PlaneCreation planeCreation =
                new PlaneCreation("model", 100, false, "2001");
        Plane plane = planePersistence.create(planeCreation);
        assertEquals("2001", plane.getLicensePlate());
    }

    @Test
    void testCreateConflict() {
        PlaneCreation planeCreation =
                new PlaneCreation("model", 100, false, "11111");
        assertThrows(ConflictException.class, () -> this.planePersistence.create(planeCreation));
    }
}
