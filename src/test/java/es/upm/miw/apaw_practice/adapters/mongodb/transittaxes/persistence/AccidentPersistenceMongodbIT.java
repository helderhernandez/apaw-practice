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
        Accident accident = accidentPersistenceMongodb.readById("003");
        assertEquals("Madrid", accident.getPlace());
        assertEquals("ACC003", accident.getRefAccident());
        assertEquals(2019, accident.getDate().getYear());
    }
    @Test
    void testUpdatePlace(){
        Accident accident = accidentPersistenceMongodb.readById("003");
        accident.setPlace("Valencia");
        Accident accidentUpdate = accidentPersistenceMongodb.updatePlace(accident);
        assertEquals("Valencia", accidentUpdate.getPlace());
        Accident accidentRollBack = accidentPersistenceMongodb.readById("003");
        accidentRollBack.setPlace("Madrid");
        Accident accidentUpdateRollBack = accidentPersistenceMongodb.updatePlace(accidentRollBack);
        assertEquals("Madrid", accidentUpdateRollBack.getPlace());



    }
}
