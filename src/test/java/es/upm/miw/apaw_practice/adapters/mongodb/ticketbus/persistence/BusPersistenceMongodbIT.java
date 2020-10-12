package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.ticketbus.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class BusPersistenceMongodbIT {

    @Autowired
    private BusPersistenceMongodb busPersistenceMongodb;
    BusCreation busCreation;
    TicketBusCreation ticketBusCreation;
    DateTimeFormatter formatter;

    @BeforeEach
    void testBefore() {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        busCreation = new BusCreation("COOP-VL", 50, Boolean.TRUE, Boolean.FALSE);
        ticketBusCreation = new TicketBusCreation(3, LocalDateTime.now(), LocalDateTime.now(), new BigDecimal("19.99"));
    }


    void testTicketBusFromBus(TicketBus ticketBus) {
        assertEquals(ticketBusCreation.getSeat(), ticketBus.getSeat());
        assertEquals(ticketBusCreation.getDepartureTime(), ticketBus.getDepartureTime());
        assertEquals(ticketBusCreation.getArriveTime(), ticketBus.getArriveTime());
        assertEquals(ticketBusCreation.getPrice(), ticketBus.getPrice());
        assertNotNull(ticketBus.getRegistrationDate());
        assertNotNull(ticketBus.getReference());
    }

    @Test
    void testCreateAndRead() {
        BusCreation busCreation = new BusCreation("COOP-VL", 50, Boolean.TRUE, Boolean.FALSE);
        ticketBusCreation = new TicketBusCreation(3, LocalDateTime.now(), LocalDateTime.now(), new BigDecimal("19.99"));

        busCreation.setTickets(Arrays.asList(ticketBusCreation));

        Bus bus = this.busPersistenceMongodb.create(busCreation);

        assertNotNull(bus.getReference());
        assertEquals(busCreation.getCompany(), bus.getCompany());
        assertEquals(busCreation.getCapacity(), bus.getCapacity());
        assertEquals(busCreation.getAccesibility(), bus.getAccesibility());
        assertEquals(busCreation.getWifi(), bus.getWifi());
        assertNotNull(bus.getRegistrationDate());
        assertNotNull(bus.getTickets());
        assertEquals(1, bus.getTickets().size());

        testTicketBusFromBus(bus.getTickets().get(0));
    }

    void resetTestUpdateDates(BusTicketsDatesUpdate busTicketsDatesUpdate) {
        busTicketsDatesUpdate.setArrive(null);
        busTicketsDatesUpdate.setDeparture(null);
        busPersistenceMongodb.updateTicketsDates(busTicketsDatesUpdate);
    }

    @Test
    void testPatchBusTicketsDates() {
        LocalDateTime departureTime = LocalDateTime.parse("16/10/2020 18:00", formatter);
        LocalDateTime arriveTime = LocalDateTime.parse("16/10/2020 22:00", formatter);

        List<Bus> buses = busPersistenceMongodb.findAll();
        Bus busBefore = buses.get(0);

        BusTicketsDatesUpdate busTicketsDatesUpdate = new BusTicketsDatesUpdate(busBefore.getReference(), departureTime, arriveTime);

        Bus busAfter = busPersistenceMongodb.updateTicketsDates(busTicketsDatesUpdate);
        assertNotNull(busAfter);
        assertNotNull(busAfter.getTickets());
        List<TicketBus> ticketsError = busAfter.getTickets().stream()
                .filter(ticketBus -> !departureTime.equals(ticketBus.getDepartureTime()) &&
                        !arriveTime.equals(ticketBus.getArriveTime())
                ).collect(Collectors.toList());
        assertEquals(0, ticketsError.size());

        resetTestUpdateDates(busTicketsDatesUpdate);
    }

    @Test
    void testFindNamePassengersByReference() {
        List<Bus> buses = busPersistenceMongodb.findAll();
        String reference = buses.get(0).getReference();

        List<String> expectation = new ArrayList<>();
        expectation.add("Juan");
        expectation.add("Ana");

        Stream<String> namesPassengers = busPersistenceMongodb.findNamePassengersByReference(reference);
        assertNotNull(namesPassengers);

        assertEquals(expectation, namesPassengers.collect(Collectors.toList()));
    }
}
