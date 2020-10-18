package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerBusEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class PassengerBusPersistenceMongodbIT {

    @Autowired
    private PassengerBusPersistenceMongodb passengerBusPersistenceMongodb;

    @Autowired
    private JourneyPersistenceMongodb journeyPersistenceMongodb;

    @Test
    void testFindJourneysByPassengerName() {

        String idJourney = journeyPersistenceMongodb.findIdByDepartureAndArrive("Madrid", "Barcelona");

        boolean hasJourney = passengerBusPersistenceMongodb.findIdJourneysFromNamePassenger("Ana")
                .anyMatch(idJourney::equals);

        assertEquals(Boolean.TRUE, hasJourney);
    }

    @Test
    void testFindJourneysByPassengerNameNotFound() {

        Long numResults = passengerBusPersistenceMongodb.findIdJourneysFromNamePassenger("Beatriz")
                .count();

        assertEquals(0L, numResults);
    }

    @Test
    void testBuilderPassengeBus() {
        String docIdentify = "07876787T";
        String name = "Rochel";
        String familyName = "Montilla";
        String phone = "798112645";
        String email = "rochel@mymail.com";
        Boolean accesibility = Boolean.FALSE;

        PassengerBusEntity passengerBusEntity = PassengerBusEntity.builder()
                .docIdentify(docIdentify)
                .name(name)
                .familyName(familyName)
                .phone(phone)
                .email(email)
                .accesibility(accesibility)
                .build();

        assertNotNull(passengerBusEntity);
        assertNotNull(passengerBusEntity.getId());
        assertNotNull(passengerBusEntity.getReference());
        assertEquals(name, passengerBusEntity.getName());
        assertEquals(familyName, passengerBusEntity.getFamilyName());
        assertEquals(phone, passengerBusEntity.getPhone());
        assertEquals(email, passengerBusEntity.getEmail());
        assertEquals(accesibility, passengerBusEntity.getAccesibility());
    }

}
