package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.daos.FlightRepository;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.FlightPriceUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class FlightResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private FlightRepository flightRepository;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(FlightResource.FLIGHTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Flight.class)
                .value(Assertions::assertNotNull)
                .value(flights -> assertEquals("madrid", flights.get(0).getDestinationCity()))
                .value(flights -> assertEquals("11112", flights.get(1).getPlane().getLicensePlate()));
    }

    @Test
    void testUpdatePrices() {
        List<FlightPriceUpdating> flightPriceUpdatingList = flightRepository
                .findAll()
                .stream()
                .map(flightEntity -> new FlightPriceUpdating(flightEntity.getId(), new BigDecimal(1000)))
                .collect(Collectors.toList());

        this.webTestClient
                .patch()
                .uri(FlightResource.FLIGHTS)
                .body(BodyInserters.fromValue(flightPriceUpdatingList))
                .exchange()
                .expectStatus().isOk();

        flightPriceUpdatingList = flightRepository
                .findAll()
                .stream()
                .map(flightEntity -> new FlightPriceUpdating(flightEntity.getId(), new BigDecimal("20.50")))
                .collect(Collectors.toList());

        this.webTestClient
                .patch()
                .uri(FlightResource.FLIGHTS)
                .body(BodyInserters.fromValue(flightPriceUpdatingList))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdatePricesNotFound() {
        List<FlightPriceUpdating> flightPriceUpdatingList = Arrays.asList(
                new FlightPriceUpdating("aa", BigDecimal.ONE)
        );

        this.webTestClient
                .patch()
                .uri(FlightResource.FLIGHTS)
                .body(BodyInserters.fromValue(flightPriceUpdatingList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindPriceBySuitcaseColor() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(FlightResource.FLIGHTS + FlightResource.SEARCH)
                        .queryParam("q", "color:red")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> assertEquals(new BigDecimal("41.00"), priceDto.getPrice()));
    }
}
