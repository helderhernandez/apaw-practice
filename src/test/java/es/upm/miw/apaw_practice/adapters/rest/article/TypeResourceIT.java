package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.article.Type;
import es.upm.miw.apaw_practice.domain.models.article.TypeDescriptionUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class TypeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate(){
        Type typeCreation =
                new Type("Gourmet","Related to food");
        this.webTestClient
                .post()
                .uri(TypeResource.TYPES)
                .body(BodyInserters.fromValue(typeCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Type.class)
                .value(Assertions::assertNotNull)
                .value(typeDate -> assertNotNull(typeDate.getId()));
    }

    @Test
    void  testCreateConflict(){
        Type typeCreation =
                new Type("Sci-fi","Very cool");
        this.webTestClient
                .post()
                .uri(TypeResource.TYPES)
                .body(BodyInserters.fromValue(typeCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);

    }

    @Test
    void testUpdateDescriptionNotFound(){
        List<TypeDescriptionUpdating> typeDescriptionUpdatingList = Arrays.asList(
                new TypeDescriptionUpdating("Science","Stunning effect")
        );
        this.webTestClient
                .patch()
                .uri(TypeResource.TYPES)
                .body(BodyInserters.fromValue(typeDescriptionUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateDescription(){
        List<TypeDescriptionUpdating> typeDescriptionUpdatingList = Arrays.asList(
                new TypeDescriptionUpdating("Comedy","DSAFASFSFDFASDF"),
                new TypeDescriptionUpdating("Tragedy","AFDASFDADSGASDGF")
        );
        this.webTestClient
                .patch()
                .uri(TypeResource.TYPES)
                .body(BodyInserters.fromValue(typeDescriptionUpdatingList))
                .exchange()
                .expectStatus().isOk();
    }
}
