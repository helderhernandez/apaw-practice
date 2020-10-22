package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.CoreMatchers.equalTo;

@RestTestConfig
public class UserStoryResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(UserStoryResource.USER_STORY + UserStoryResource.ID_ID, "")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindByLabelName() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(UserStoryResource.USER_STORY + UserStoryResource.SEARCH)
                                .queryParam("q", "labelName:documentation")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(strings -> strings.get(0), equalTo("[\"login\"]"));
    }

}
