package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PlaneRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GameDeveloperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GameDeveloperEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloper;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloperCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class GameDeveloperResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private GameDeveloperRepository gameDeveloperRepository;

    @Test
    void testCreate() {
        GameDeveloperCreation gameDeveloperCreation =
                new GameDeveloperCreation("Javier", "javiersanchez@hotmail.com", 665632345);
        this.webTestClient
                .post()
                .uri(GameDeveloperResource.GDEVELOPERS)
                .body(BodyInserters.fromValue(gameDeveloperCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(GameDeveloper.class)
                .value(Assertions::assertNotNull)
                .value(gameDeveloper -> assertNotNull(gameDeveloper.getId()))
                .value(gameDeveloper -> assertEquals(665632345, gameDeveloper.getPhone()));
    }

    @Test
    void testUpdatePhone() {
        List<GameDeveloperEntity> gameDeveloperEntities = gameDeveloperRepository.findAll();
        PhoneDto phoneDto = new PhoneDto(665789322);
        this.webTestClient
                .put()
                .uri(GameDeveloperResource.GDEVELOPERS + GameDeveloperResource.ID + GameDeveloperResource.PHONE, gameDeveloperEntities.get(0).getId())
                .body(BodyInserters.fromValue((phoneDto)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(GameDeveloper.class)
                .value(gameDeveloper -> assertEquals(665789322, gameDeveloper.getPhone()));
    }

    @Test
    void TestUpdatePhoneNotFound() {
        PhoneDto phoneDto = new PhoneDto(661759322);
        this.webTestClient
                .put()
                .uri(GameDeveloperResource.GDEVELOPERS + GameDeveloperResource.ID + GameDeveloperResource.PHONE, "02")
                .body(BodyInserters.fromValue((phoneDto)))
                .exchange()
                .expectStatus().isNotFound();

    }

    @Test
    void testCreateConflict() {
        GameDeveloperCreation gameDeveloperCreation =
                new GameDeveloperCreation("Pedro", "pedrofernandez@hotmail.com", 667659345);
        this.webTestClient
                .post()
                .uri(GameDeveloperResource.GDEVELOPERS)
                .body(BodyInserters.fromValue(gameDeveloperCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }


}