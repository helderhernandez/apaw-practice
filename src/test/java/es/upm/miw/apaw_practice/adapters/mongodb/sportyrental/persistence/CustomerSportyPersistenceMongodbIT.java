package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.SportyRentalSeederService;
import es.upm.miw.apaw_practice.domain.models.sportyRental.CustomerSporty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CustomerSportyPersistenceMongodbIT {

    @Autowired
    private CustomerSportyPersistenceMongodb customerSportyPersistenceMongodb;

    @Autowired
    private SportyRentalSeederService sportyRentalSeederService;

    @AfterEach
    void resetDatabase() {
        sportyRentalSeederService.deleteAll();
        sportyRentalSeederService.seedDatabase();
    }

    @Test
    void testDeleteByDni() {

        Optional<CustomerSporty> customerSportyOptional = this.customerSportyPersistenceMongodb.readAll().filter(customer -> "50206090J".equals(customer.getDni())).findFirst();
        assertNotNull(customerSportyOptional);
        assertTrue(customerSportyOptional.isPresent());
        CustomerSporty customerSporty = customerSportyOptional.get();
        this.customerSportyPersistenceMongodb.deleteByDni(customerSporty.getDni());

        assertEquals(0, this.customerSportyPersistenceMongodb.readAll().filter(customer -> "50206090J".equals(customer.getDni())).count());
    }
}
