package es.upm.miw.apaw_practice.adapters.mongodb.hospital.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Bed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class BedPersistenceMongodbIT {

    @Autowired
    private BedPersistenceMongodb bedPersistenceMongodb;

    @Test
    void testFindWidth(){
        Stream<Bed> bedsSearch = this.bedPersistenceMongodb.findByNameWidthOfBeds("NameC");

    }


}
