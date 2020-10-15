package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.VideoclubSeederService;
import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CustomerAssociatePersistenceMongodbIT {
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
}
