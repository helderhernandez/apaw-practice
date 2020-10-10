package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.TransitTaxesSeederService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig

public class OwnerPersistenceMongodbIT {

    @Autowired
    private OwnerPersistenceMongodb ownerPersistenceMongodb;

    @Autowired
    private TransitTaxesSeederService transitTaxesSeederService;

    @Test
    void testDelete(){

        ownerPersistenceMongodb.deleteById("ow1");

        transitTaxesSeederService.deleteAll();
        transitTaxesSeederService.seedDatabase();

    }

}
