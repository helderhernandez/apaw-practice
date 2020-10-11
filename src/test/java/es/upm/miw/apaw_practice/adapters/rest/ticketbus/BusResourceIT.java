package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.ticketbus.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class BusResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    TicketBusCreation ticketBusCreation;
    BusCreation busCreation;

    void testTicketBus(TicketBus ticketBus) {
        assertEquals(ticketBusCreation.getSeat(), ticketBus.getSeat());
        assertEquals(ticketBusCreation.getPrice(), ticketBus.getPrice());
        assertEquals(ticketBusCreation.getDepartureTime(), ticketBus.getDepartureTime());
        assertEquals(ticketBusCreation.getArriveTime(), ticketBus.getArriveTime());
    }

    void testCmpBus(Bus busReturned, BusCreation busCreation) {
        assertNotNull(busReturned.getReference());
        assertEquals(busCreation.getCompany(), busReturned.getCompany());
        assertEquals(busCreation.getCapacity(), busReturned.getCapacity());
        assertEquals(busCreation.getAccesibility(), busReturned.getAccesibility());
        assertEquals(busCreation.getWifi(), busReturned.getWifi());
    }

    @Test
    void testCreate() {
        busCreation = new BusCreation("COOP-VL", 50, Boolean.TRUE, Boolean.FALSE);
        ticketBusCreation = new TicketBusCreation(3, LocalDateTime.now(), LocalDateTime.now(), new BigDecimal("19.99"));

        busCreation.setTickets(Arrays.asList(ticketBusCreation));

        this.webTestClient
                .post()
                .uri(BusResource.BUSES)
                .body(BodyInserters.fromValue(busCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Bus.class)
                .value(Assertions::assertNotNull)
                .value(busData -> testCmpBus(busData, busCreation))
                .value(busData -> assertNotNull(busData.getTickets()))
                .value(busData -> assertNotNull(busData.getTickets().get(0)))
                .value(busData -> testTicketBus(busData.getTickets().get(0)));
    }
}
