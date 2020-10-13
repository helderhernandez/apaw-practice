package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class MortgagePersistenceMongodbIT {
    @Autowired
    private MortgagePersistenceMongodb mortgagePersistence;

    @Test
    void testFindDNIbyCustomers() {
        List<String> DNIs = List.of("511511511L", "666511511J", "511511444M", "511333511A");
        assertTrue(this.mortgagePersistence.findDNIbyCustomers().containsAll(DNIs));
    }
}
