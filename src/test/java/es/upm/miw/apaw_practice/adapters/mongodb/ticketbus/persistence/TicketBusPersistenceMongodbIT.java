package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.TicketBusSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerBusEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.TicketBusEntity;
import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBusCreation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class TicketBusPersistenceMongodbIT {


    @Autowired
    private TicketBusSeederService ticketBusSeederService;

    @Autowired
    private TicketBusPersistenceMongodb ticketBusPersistenceMongodb;

    @AfterEach
    void resetBD() {
        ticketBusSeederService.deleteAll();
        ticketBusSeederService.seedDatabase();
    }

    void testTicketBusPassenger(TicketBus ticketBus, PassengerBusCreation passengerBusCreation) {
        PassengerBus passengerBus = ticketBus.getPassenger();
        assertNotNull(ticketBus);
        assertNotNull(ticketBus.getReference());
        assertNotNull(passengerBus);
        assertNotNull(passengerBus.getReference());

        assertEquals(passengerBusCreation.getName(), passengerBus.getName());
        assertEquals(passengerBusCreation.getFamilyName(), passengerBus.getFamilyName());
        assertEquals(passengerBusCreation.getDocIdentify(), passengerBus.getDocIdentify());
        assertEquals(passengerBusCreation.getPhone(), passengerBus.getPhone());
        assertEquals(passengerBusCreation.getEmail(), passengerBus.getEmail());
        assertEquals(passengerBusCreation.getAccesibility(), passengerBus.getAccesibility());
    }

    @Test
    void testUpdate() {
        List<TicketBus> ticketBuses = ticketBusPersistenceMongodb.findAll().collect(Collectors.toList());
        TicketBus ticketBus = ticketBuses.get(0);
        assertNotNull(ticketBus);
        assertNotNull(ticketBus.getReference());

        PassengerBusCreation passengerBusCreation = new PassengerBusCreation("87460970C", "Juan Jose", "Cortes", "893266507", "kfl688l2@talk21.com", Boolean.FALSE);

        ticketBus = ticketBusPersistenceMongodb.update(ticketBus.getReference(), passengerBusCreation);
        testTicketBusPassenger(ticketBus, passengerBusCreation);
    }

    @Test
    void testDelete() {
        List<TicketBus> ticketBuses = ticketBusPersistenceMongodb.findAll().collect(Collectors.toList());
        TicketBusCreation ticketBusCreation = new TicketBusCreation();
        TicketBus ticketBus = ticketBuses.get(3);
        BeanUtils.copyProperties(ticketBus, ticketBusCreation);

        ticketBusPersistenceMongodb.delete(ticketBus.getReference());

        assertFalse(ticketBusPersistenceMongodb.findAll()
                .anyMatch(ticketBus1 -> ticketBus1.getReference().equals(ticketBus.getReference()))
        );

        ticketBusPersistenceMongodb.save(ticketBusCreation);
    }
}
