package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.hospital.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.hospital.RoomResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class RoomResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(ROOMS+ID_ID,"exampleOfId")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    void testSearchByNameWidthOfBeds(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(ROOMS + SEARCH)
                                .queryParam("q", "contagious:true")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Room.class)
                .value(rooms -> assertTrue(rooms.size() > 0))
                .value(rooms -> assertEquals(1, rooms.get(0).getFloor()))
                .value(rooms -> assertEquals("AreaB", rooms.get(1).getArea()));
    }
}
