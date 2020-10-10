package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.TicketBusSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos.TicketBusRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.ticketbus.Journey;
import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RestTestConfig
class TicketBusResourceIT {

    @Autowired
    private TicketBusSeederService ticketBusSeederService;

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private TicketBusRepository ticketBusRepository;

    @AfterEach
    void resetBD(){
        ticketBusSeederService.deleteAll();
        ticketBusSeederService.seedDatabase();
    }

    void testTicketBusPassenger(TicketBus ticketBus, PassengerBusCreation passengerBusCreation){
        PassengerBus passengerBus = ticketBus.getPassenger();
        assertNotNull(ticketBus);
        assertNotNull(ticketBus.getId());
        assertNotNull(passengerBus);
        assertNotNull(passengerBus.getId());

        assertEquals(passengerBusCreation.getName(), passengerBus.getName());
        assertEquals(passengerBusCreation.getFamilyName(), passengerBus.getFamilyName());
        assertEquals(passengerBusCreation.getDocIdentify(), passengerBus.getDocIdentify());
        assertEquals(passengerBusCreation.getPhone(), passengerBus.getPhone());
        assertEquals(passengerBusCreation.getEmail(), passengerBus.getEmail());
        assertEquals(passengerBusCreation.getAccesibility(), passengerBus.getAccesibility());
    }

    @Test
    void testFindAll(){

        PassengerBusCreation passengerBusCreation = new PassengerBusCreation("87460970C", "Juan Jose", "Cortes", "893266507", "kfl688l2@talk21.com", Boolean.FALSE);
        List<TicketBus> ticketBuses = ticketBusRepository.findAll()
                    .stream()
                    .map(TicketBusEntity::toTicketBus)
                    .collect(Collectors.toList());
        TicketBus ticketBus = ticketBuses.get(0);

        this.webTestClient
                .put()
                .uri(TicketBusResource.TICKETBUSES + ticketBus.getId() + TicketBusResource.PASSENGER )
                .body(BodyInserters.fromValue(passengerBusCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(TicketBus.class)
                .value(Assertions::assertNotNull)
                .value(ticketBus1 -> assertNotNull(ticketBus1.getId()))
                .value(ticketBus1 -> testTicketBusPassenger(ticketBus1, passengerBusCreation) );
    }

}
