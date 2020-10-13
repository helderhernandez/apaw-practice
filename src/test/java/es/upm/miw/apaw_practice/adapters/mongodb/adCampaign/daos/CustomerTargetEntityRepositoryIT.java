package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.CustomerTargetEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CustomerTargetEntityRepositoryIT {

    @Autowired
    private CustomerTargetRepository customerTargetRepository;
    private CustomerTargetEntity customerTarget;


    @BeforeEach
    void before() {
        assertTrue(customerTargetRepository.findById("customer-01").isPresent());
        customerTarget = customerTargetRepository.findById("customer-01").get();
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.customerTargetRepository.findAll().stream().
                anyMatch(customer -> "customer-03".equals(customer.getId()) &&
                        "David".equals(customer.getName()) &&
                        "Amaya".equals(customer.getLastName()) &&
                        "daxamayac@gmail.com".equals(customer.getEmail()) &&
                        customer.getLikes() == null
                ));
    }

    @Test
    void testSetAndGet() {
        customerTarget.setId("999");
        customerTarget.setName("dax");
        customerTarget.setLastName("alex");
        customerTarget.setEmail("daamayac");
        customerTarget.setSubscribed(false);

        assertEquals("999", customerTarget.getId());
        assertEquals("dax", customerTarget.getName());
        assertEquals("alex", customerTarget.getLastName());
        assertEquals("daamayac", customerTarget.getEmail());
        assertEquals(false, customerTarget.isSubscribed());
    }
}
