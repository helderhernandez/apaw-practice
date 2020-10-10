package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.CustomerSportyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class CustomerSportyEntityRepositoryIT {


    @Autowired
    private CustomerSportyRepository customerSportyRepository;


    @Test
    void testFindByDni() {
        assertTrue(customerSportyRepository.findByDni("50506080J").isPresent());
        CustomerSportyEntity customer = this.customerSportyRepository.findByDni("50506080J").get();
        assertEquals("Enrique", customer.getName());
        assertEquals("Lopez Sebastian", customer.getSurnames());
        assertEquals("enrique.lopez@gmail.com", customer.getEmail());
        assertEquals("666777999", customer.getPhone());
    }


    @Test
    void testCustomerCreateAndGet() {
        CustomerSportyEntity customerSport = new CustomerSportyEntity("1", "50778800K", "Juan", "Riofrio",
                "juan.riofrio@gmail.com", "777000999");
        this.customerSportyRepository.save(customerSport);
        assertTrue(this.customerSportyRepository.findAll().stream().
                anyMatch(customer -> "50778800K".equals(customer.getDni()) &&
                        "Juan".equals(customer.getName()) &&
                        "Riofrio".equals(customer.getSurnames()) &&
                        "juan.riofrio@gmail.com".equals(customer.getEmail())
                ));
    }

    @Test
    void testCustomerSet() {
        assertTrue(customerSportyRepository.findByDni("50206090J").isPresent());
        CustomerSportyEntity customer = this.customerSportyRepository.findByDni("50206090J").get();
        customer.setName("Elena");
        customer.setSurnames("Amores");
        customer.setEmail("elena.amores@hotmail.com");
        customer.setPhone("999555888");
        assertEquals("Elena", customer.getName());
        assertEquals("Amores", customer.getSurnames());
        assertEquals("elena.amores@hotmail.com", customer.getEmail());
        assertEquals("999555888", customer.getPhone());

    }
}
