package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@TestConfig
public class CustomerPesistenceMongodbIT {

    @Autowired
    private CustomerPersistenceMongodb customerPersistence;

    @Test
    void testAssertDNINotExist() {
        assertDoesNotThrow(() -> this.customerPersistence.assertDniNotExist("511511522L"));
    }


}
