package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.PassengerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PassengerEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class PassengerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    void testDeleteById() {
        PassengerEntity passengerEntity = passengerRepository.save(new PassengerEntity());

        this.webTestClient
                .delete()
                .uri(PassengerResource.PASSENGERS + PassengerResource.ID, passengerEntity.getId())
                .exchange()
                .expectStatus().isOk();
    }
}
