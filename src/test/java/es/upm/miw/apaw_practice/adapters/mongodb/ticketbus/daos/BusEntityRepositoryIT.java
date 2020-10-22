package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.BusEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class BusEntityRepositoryIT {

    @Autowired
    private BusRepository busRepository;

    @Test
    void testAndCreate() {

        assertTrue(this.busRepository.findAll().stream()
                .anyMatch(bus ->
                        bus.getReference() != null &&
                                "Velocity Cars".equals(bus.getCompany()) &&
                                Boolean.TRUE.equals(bus.getAccesibility()) &&
                                Boolean.TRUE.equals(bus.getWifi()) &&
                                Integer.valueOf(11).equals(bus.getTickets().get(0).getSeat()) &&
                                bus.getTickets().get(0).getDepartureTime() == null &&
                                bus.getTickets().get(0).getArriveTime() == null &&
                                new BigDecimal("30.99").equals(bus.getTickets().get(0).getPrice()) &&
                                "89386661J".equals(bus.getTickets().get(0).getPassenger().getDocIdentify()) &&
                                "Madrid".equals(bus.getJourneys().get(0).getDeparture()) &&
                                "Barcelona".equals(bus.getJourneys().get(0).getArrive()) &&
                                Integer.valueOf(5).equals(bus.getJourneys().get(0).getNumStops())
                )
        );
    }

    @Test
    void testEquals(){
        BusEntity busEntity = this.busRepository.findAll().stream().findFirst().get();

        BusEntity busEntityTest = new BusEntity();
        busEntityTest.setId(busEntity.getId());
        busEntityTest.setReference(busEntity.getReference());
        busEntityTest.setRegistrationDate(busEntity.getRegistrationDate());
        busEntityTest.setCompany(busEntity.getCompany());
        busEntityTest.setCapacity(busEntity.getCapacity());
        busEntityTest.setAccesibility(busEntity.getAccesibility());
        busEntityTest.setWifi(busEntity.getWifi());
        busEntityTest.setJourneys(busEntity.getJourneys());

        assertEquals(busEntity, busEntityTest);
    }
}
