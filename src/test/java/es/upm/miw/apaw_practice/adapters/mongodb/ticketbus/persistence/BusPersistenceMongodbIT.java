package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.ticketbus.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class BusPersistenceMongodbIT {

    @Autowired
    private BusPersistenceMongodb busPersistenceMongodb;
    BusCreation busCreation;
    TicketBusCreation ticketBusCreation;

    @BeforeEach
    void testBefore() {
        busCreation = new BusCreation("VL-001", "COOP-VL", 50, Boolean.TRUE, Boolean.FALSE);
        ticketBusCreation = new TicketBusCreation(3, LocalDateTime.now(), LocalDateTime.now(), new BigDecimal("19.99"));
    }


    void testTicketBusFromBus(TicketBus ticketBus) {
        assertEquals(ticketBusCreation.getSeat(), ticketBus.getSeat());
        assertEquals(ticketBusCreation.getDepartureTime(), ticketBus.getDepartureTime());
        assertEquals(ticketBusCreation.getArriveTime(), ticketBus.getArriveTime());
        assertEquals(ticketBusCreation.getPrice(), ticketBus.getPrice());
        assertNotNull(ticketBus.getRegistrationDate());
        assertNotNull(ticketBus.getId());
    }

    @Test
    void testCreateAndRead() {
        BusCreation busCreation = new BusCreation("VL-001", "COOP-VL", 50, Boolean.TRUE, Boolean.FALSE);
        ticketBusCreation = new TicketBusCreation(3, LocalDateTime.now(), LocalDateTime.now(), new BigDecimal("19.99"));

        busCreation.setTickets(Arrays.asList(ticketBusCreation));

        Bus bus = this.busPersistenceMongodb.create(busCreation);

        assertEquals(busCreation.getCompany(), bus.getCompany());
        assertEquals(busCreation.getCapacity(), bus.getCapacity());
        assertEquals(busCreation.getAccesibility(), bus.getAccesibility());
        assertEquals(busCreation.getWifi(), bus.getWifi());
        assertNotNull(bus.getRegistrationDate());
        assertNotNull(bus.getId());
        assertNotNull(bus.getTickets());
        assertEquals(1, bus.getTickets().size());

        testTicketBusFromBus(bus.getTickets().get(0));
    }
}

