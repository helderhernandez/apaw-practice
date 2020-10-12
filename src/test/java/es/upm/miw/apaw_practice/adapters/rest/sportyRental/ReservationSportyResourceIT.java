package es.upm.miw.apaw_practice.adapters.rest.sportyRental;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationSporty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.adapters.rest.sportyRental.ReservationSportyResource.REF_RESERVATION;
import static es.upm.miw.apaw_practice.adapters.rest.sportyRental.ReservationSportyResource.RESERVATIONS_SPORTY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class ReservationSportyResourceIT {

    @Autowired
    private WebTestClient webTestClient;

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
}
