package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class SocialListResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient.delete()
                .uri(SocialListResource.LISTS + SocialListResource.ID, "ko")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindVerifiedNickNamesByListName() {
        this.webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path(SocialListResource.LISTS + SocialListResource.SEARCH)
                        .queryParam("q", "listName:Family")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .consumeWith(entitiesList -> {
                    assertNotNull(entitiesList);
                    assertNotNull(entitiesList.getResponseBody());
                    assertTrue(entitiesList.getResponseBody().size() > 0 &&
                            entitiesList.getResponseBody().get(0).contains("Pepe_o") &&
                            entitiesList.getResponseBody().get(0).contains("Francisco26"));
                });
    }

}
