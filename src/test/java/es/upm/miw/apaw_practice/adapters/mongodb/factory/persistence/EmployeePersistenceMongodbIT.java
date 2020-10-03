package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestConfig
public class EmployeePersistenceMongodbIT {

    @Autowired
    private EmployeePersistenceMongodb employeePersistence;

    @Test
    void testDniNotExist() {
        assertDoesNotThrow(() -> this.employeePersistence.assertDniNotExist("10101010K"));
    }
}
