package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.BusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.ticketbus.*;
import es.upm.miw.apaw_practice.domain.services.ticketbus.BusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class BusResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private BusRepository busRepository;

    TicketBusCreation ticketBusCreation;
    BusCreation busCreation;
    DateTimeFormatter formatter;
    LocalDateTime departureTime;
    LocalDateTime arriveTime;

    @BeforeEach
    void testBefore() {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        departureTime = LocalDateTime.parse("16/10/2020 18:00", formatter);
        arriveTime = LocalDateTime.parse("16/10/2020 22:00", formatter);
    }

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

    void testDatesTicketsBus(List<TicketBus> ticketsBus) {
        List<TicketBus> ticketsError = ticketsBus.stream().filter(ticketBus -> !departureTime.equals(ticketBus.getDepartureTime()) &&
                !arriveTime.equals(ticketBus.getArriveTime())
        ).collect(Collectors.toList());
        assertEquals(0, ticketsError.size());
    }

    @Test
    void testUpdateDatesTicketsBus() {

        List<Bus> buses = busRepository.findAll().stream().map(BusEntity::toBus).collect(Collectors.toList());
        Bus bus = buses.get(1);

        this.webTestClient
                .patch()
                .uri(BusResource.BUSES + "/" + bus.getReference() + BusResource.TICKETS_DATES)
                .body(BodyInserters.fromValue(new BusTicketsDatesDto(departureTime, arriveTime)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Bus.class)
                .value(Assertions::assertNotNull)
                .value(busData -> testDatesTicketsBus(busData.getTickets()));
    }

    void testNamesPassengers(List<String> namePassengers) {
        List<String> expectation = new ArrayList<>();
        expectation.add("Juan");
        expectation.add("Ana");

        assertEquals(expectation, namePassengers);
    }

    @Test
    void testFindNamePassengersByReference() {
        List<Bus> buses = busRepository.findAll().stream().map(BusEntity::toBus).collect(Collectors.toList());
        Bus bus = buses.get(0);

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(BusResource.BUSES + "/" + bus.getReference() + BusResource.PASSENGERS)
                        .queryParam("fields", "name")
                        .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(Assertions::assertNotNull)
                .value("['Juan', 'Ana']"::equals);
    }
}
