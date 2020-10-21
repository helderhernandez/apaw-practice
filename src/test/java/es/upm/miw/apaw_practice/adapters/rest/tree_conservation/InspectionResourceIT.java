package es.upm.miw.apaw_practice.adapters.rest.tree_conservation;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class InspectionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdate() {
        TreeStatusDto treeStatusTest = new TreeStatusDto();
        treeStatusTest.setTreeStatus("fakeTreeStatus");
        this.webTestClient
                .put()
                .uri(InspectionResource.INSPECTIONS + InspectionResource.ID_ID + InspectionResource.TREE_STATUS, "fakeId")
                .body(BodyInserters.fromValue(treeStatusTest))
                .exchange()
                .expectStatus().isNotFound();
    }
}
