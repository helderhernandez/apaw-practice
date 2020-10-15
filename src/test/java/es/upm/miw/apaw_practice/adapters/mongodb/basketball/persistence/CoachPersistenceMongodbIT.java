package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Coach;
import es.upm.miw.apaw_practice.domain.models.basketball.CoachCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class CoachPersistenceMongodbIT {

    @Autowired
    private CoachPersistenceMongodb coachPersistenceMongodb;

    @Test
    void testCreateandRead() {
        CoachCreation coachCreation = new CoachCreation("Juan", "55555555K");
        this.coachPersistenceMongodb.create(coachCreation);
        Coach coachBD = this.coachPersistenceMongodb.readByDni("55555555K");
        assertEquals("Juan", coachBD.getName());
        assertNotNull(coachBD.getId());
        assertEquals("55555555K", coachBD.getDni());
    }
}
