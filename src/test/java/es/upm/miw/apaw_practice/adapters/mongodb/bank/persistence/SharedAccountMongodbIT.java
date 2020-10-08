package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestConfig
public class SharedAccountMongodbIT {

    @Autowired
    private SharedAccountPersistenceMongodb sharedAccountPersistence;

    @Test
    void testFindDNIBySharedAccount() {

    }
}
