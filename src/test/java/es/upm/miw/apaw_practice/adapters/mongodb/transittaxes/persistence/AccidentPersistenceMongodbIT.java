package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class AccidentPersistenceMongodbIT {

    @Autowired
    private AccidentPersistenceMongodb accidentPersistenceMongodb;

    @Test
    void testReadById() {

        Accident accident = accidentPersistenceMongodb.read("003");
        assertEquals("Madrid",accident.getPlace());
        assertEquals("ACC003",accident.getRefAccident());
        assertEquals(2019,accident.getDate().getYear());
    }
}
