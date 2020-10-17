package es.upm.miw.apaw_practice.adapters.rest.videoclub;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.VideoclubSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import es.upm.miw.apaw_practice.domain.services.videoclub.CustomerAssociateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class CustomerAssociateResourceIT {

    @Autowired
    private VideoclubSeederService videoclubSeederService;

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private CustomerAssociateService customerAssociateService;

    @AfterEach
    void resetBBDD() {
        videoclubSeederService.deleteAll();
        videoclubSeederService.seedDatabase();
    }

    @Test
    void testUpdateName() {
        NameDto nameDto = new NameDto();
        nameDto.setName("Diego Hernández Cambiado");
        String documentIdToChange = "DNI3";

        CustomerAssociate customerAssociate = this.customerAssociateService
                .readByDocumentId(documentIdToChange);

        assertNotNull(customerAssociate);
        assertNotNull(customerAssociate.getDocumentId());
        assertEquals("Diego Hernández García", customerAssociate.getName());

        this.webTestClient
                .put()
                .uri(CustomerAssociateResource.CUSTOMERASSOCIATES +
                        "/" + documentIdToChange +
                        CustomerAssociateResource.NAME_NAME, documentIdToChange)
                .body(BodyInserters.fromValue(nameDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CustomerAssociate.class)
                .value(Assertions::assertNotNull)
                .value(customerAssociateUpd -> assertEquals("Diego Hernández Cambiado", customerAssociateUpd.getName()));
    }
    @Test
    void testDelete() {
        String documentIdToDelete = "DNI2";
        this.webTestClient
                .delete()
                .uri(CustomerAssociateResource.CUSTOMERASSOCIATES +
                        "/" + documentIdToDelete)
                .exchange()
                .expectStatus().isOk();
    }

}
