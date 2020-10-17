package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.CustomerAssociateEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CustomerAssociateEntityRepositoryIT {
    @Autowired
    private CustomerAssociateRepository customerAssociateRepository;

    @Test
    void testFindByDocumentId() {
        assertTrue(this.customerAssociateRepository.findByDocumentId("DNI1").isPresent());
        CustomerAssociateEntity customerAssociate = this.customerAssociateRepository.findByDocumentId("DNI1").get();
        assertEquals("Javier Delgado Pérez", customerAssociate.getName());
        assertEquals(LocalDate.of(2005, 1, 1), customerAssociate.getBirthday());
        assertFalse(customerAssociate.getFilms().get(0).getCategories().get(0).getPlus18());
    }
}
