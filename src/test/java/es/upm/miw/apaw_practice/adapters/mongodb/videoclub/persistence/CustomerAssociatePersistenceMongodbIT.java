package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.VideoclubSeederService;
import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class CustomerAssociatePersistenceMongodbIT {
    @Autowired
    private VideoclubSeederService videoclubSeederService;

    @Autowired
    private CustomerAssociatePersistenceMongodb customerAssociatePersistenceMongodb;

    @AfterEach
    void resetBBDD() {
        this.videoclubSeederService.deleteAll();
        this.videoclubSeederService.seedDatabase();
    }

    @Test
    void testUpdateName() {
        CustomerAssociate customerAssociate = this.customerAssociatePersistenceMongodb
                .readByDocumentId("DNI4");
        assertNotNull(customerAssociate);
        assertNotNull(customerAssociate.getDocumentId());
        assertEquals("Laura Jiménez González", customerAssociate.getName());

        this.customerAssociatePersistenceMongodb.updateName("DNI4", "Laura Jiménez Cambiado");

        CustomerAssociate customerAssociateUpdated = this.customerAssociatePersistenceMongodb
                .readByDocumentId("DNI4");
        assertNotNull(customerAssociate);
        assertNotNull(customerAssociate.getDocumentId());

        assertEquals("Laura Jiménez Cambiado", customerAssociateUpdated.getName());
    }

    @Test
    void testDelete() {
        CustomerAssociate customerAssociate = this.customerAssociatePersistenceMongodb
                .readByDocumentId("DNI2");
        assertNotNull(customerAssociate);
        assertNotNull(customerAssociate.getDocumentId());

        this.customerAssociatePersistenceMongodb.deleteByDocumentId(customerAssociate.getDocumentId());

        assertFalse(this.customerAssociatePersistenceMongodb.readAll()
                .anyMatch(customerAssociate1
                        -> customerAssociate1.getDocumentId().equals(customerAssociate.getDocumentId())));
    }

    @Test
    void testFindDistinctNameByRentalFilms() {
        List<String> rentalFilmList = List.of("5555", "6666");
        List<String> customerAssociateNames = this.customerAssociatePersistenceMongodb
                .findDistinctNameByRentalFilms(rentalFilmList)
                .collect(Collectors.toList());

        assertEquals("Diego Hernández García", customerAssociateNames.get(0));
        assertEquals("Laura Jiménez González", customerAssociateNames.get(1));
    }
}
