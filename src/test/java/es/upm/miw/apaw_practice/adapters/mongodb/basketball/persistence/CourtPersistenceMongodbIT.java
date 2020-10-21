package es.upm.miw.apaw_practice.adapters.mongodb.basketball.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.basketball.Court;
import es.upm.miw.apaw_practice.domain.models.basketball.CourtCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class CourtPersistenceMongodbIT {

    @Autowired
    private CourtPersistenceMongodb courtPersistenceMongodb;

    @Test
    void testCreateAndUpdate() {
        CourtCreation courtCreation = new CourtCreation("Jesus España", 450);
        Court courtBD = this.courtPersistenceMongodb.create(courtCreation);
        courtBD.setCapacity(1000);
        this.courtPersistenceMongodb.updateCapacity(courtBD);
        assertEquals(0, Integer.compare(1000, courtBD.getCapacity()));
    }
}
