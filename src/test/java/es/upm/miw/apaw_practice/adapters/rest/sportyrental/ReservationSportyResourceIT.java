package es.upm.miw.apaw_practice.adapters.rest.sportyrental;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.SportyRentalSeederService;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.sportyrental.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.List;

import static es.upm.miw.apaw_practice.adapters.rest.sportyrental.ReservationSportyResource.REF_RESERVATION;
import static es.upm.miw.apaw_practice.adapters.rest.sportyrental.ReservationSportyResource.RESERVATIONS_SPORTY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class ReservationSportyResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private SportyRentalSeederService sportyRentalSeederService;

    @AfterEach
    void resetDatabase() {
        sportyRentalSeederService.deleteAll();
        sportyRentalSeederService.seedDatabase();
    }

    @Test
    void testReadByRefReservation() {
        this.webTestClient
                .get()
                .uri(RESERVATIONS_SPORTY + REF_RESERVATION, "R3458901")
                .exchange()
                .expectStatus().isOk()
                .expectBody(ReservationSporty.class)
                .value(Assertions::assertNotNull)
                .value(reservationSportyData -> {
                    assertEquals("1", reservationSportyData.getIdReservation());
                    assertEquals("R3458901", reservationSportyData.getRefReservation());
                    assertEquals(3, reservationSportyData.getCustomersSporty().size());
                    assertEquals("1", reservationSportyData.getCategorySporty().getIdCategory());
                    assertEquals(2, reservationSportyData.getDiscountsSporty().size());
                    assertTrue(reservationSportyData.getPaidOut());
                });
    }

    @Test
    void testReadByRefReservationNotFound() {
        this.webTestClient
                .get()
                .uri(RESERVATIONS_SPORTY + REF_RESERVATION, "R9999999")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testCreate() {
        CustomerCreationSporty customerCreation = new CustomerCreationSporty("50907740L", "Nestor", "Perez Diaz", "nestor.perez@gmail.com", "776456300");
        CategoryCreationSporty categoryCreation = new CategoryCreationSporty("Ping Pong", 2);
        DiscountCreationSporty discountCreation = new DiscountCreationSporty("Promotion 10%", 10.0);

        ReservationCreationSporty reservationCreation =
                new ReservationCreationSporty(new BigDecimal(20), Boolean.TRUE, List.of(customerCreation), categoryCreation, List.of(discountCreation));
        this.webTestClient
                .post()
                .uri(RESERVATIONS_SPORTY)
                .body(BodyInserters.fromValue(reservationCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ReservationSporty.class)
                .value(Assertions::assertNotNull)
                .value(reservationSportyData -> {
                    assertTrue(reservationSportyData.getPaidOut());
                    assertEquals("Ping Pong", reservationSportyData.getCategorySporty().getDescription());
                    assertEquals(1, reservationSportyData.getCustomersSporty().size());
                    assertEquals("50907740L", reservationSportyData.getCustomersSporty().get(0).getDni());
                    assertEquals(1, reservationSportyData.getDiscountsSporty().size());
                    assertEquals("Promotion 10%", reservationSportyData.getDiscountsSporty().get(0).getDescription());
                });
    }
}
