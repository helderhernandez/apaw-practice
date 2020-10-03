package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CustomerEntityRepositoryIT {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindByDNI() {
        assertTrue(this.customerRepository.findByDNI("511511511L").isPresent());
        CustomerEntity customerEntity = this.customerRepository.findByDNI("511511511L").get();
        assertEquals("Ulises", customerEntity.getName());
        assertEquals("666777888", customerEntity.getPhone());
        assertEquals("ulises@email.com", customerEntity.getEmail());
    }
}
