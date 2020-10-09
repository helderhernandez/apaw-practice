package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SharedAccountPersistenceMongodbIT {

    @Autowired
    private SharedAccountPersistenceMongodb sharedAccountPersistence;

    @Test
    void testFindDNIBySharedAccount() {
        List<String> dnis = List.of("511511511L", "511511777L", "511511444M", "666511511J", "511333511A");
        assertTrue(this.sharedAccountPersistence.findDNIBySharedAccount().containsAll(dnis));
    }
}
