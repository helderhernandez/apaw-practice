package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class CustomerPesistenceMongodbIT {

    @Autowired
    private CustomerPersistenceMongodb customerPersistence;

    @Test
    void testAssertDNINotExist() {
        assertDoesNotThrow(() -> this.customerPersistence.assertDniNotExist("511511522L"));
    }

    @Test
    void testFindDNIByMortgageAndSharedAccount() {
        List<String> dnis = List.of("511511511L", "511511444M", "666511511J", "511333511A");
        assertTrue(this.customerPersistence.findDNIByMortgageAndSharedAccount().containsAll(dnis));
    }

    @Test
    void testFindCustomerByShareholderWithValueGreaterThan() {
        List<String> dnis = List.of("511511444M", "511333511A");
        assertTrue(this.customerPersistence.findCustomerByShareholderWithValueGreaterThan(BigDecimal.valueOf(1.50))
                .stream()
                .map(CustomerEntity::getDNI)
                .collect(Collectors.toList())
                .containsAll(dnis));
    }
}
