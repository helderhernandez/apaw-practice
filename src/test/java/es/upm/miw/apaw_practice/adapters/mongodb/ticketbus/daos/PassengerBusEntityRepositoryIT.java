package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerBusEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class PassengerBusEntityRepositoryIT {

    @Autowired
    private PassengerBusRepository passengerBusRepository;

    @Test
    void testCreateAndRead() {

        assertTrue(this.passengerBusRepository.findAll().stream()
                .anyMatch(passenger ->
                        passenger.getReference() != null &&
                                "89386661J".equals(passenger.getDocIdentify()) &&
                                "Juan".equals(passenger.getName()) &&
                                "Perez".equals(passenger.getFamilyName()) &&
                                "651112234".equals(passenger.getPhone()) &&
                                "jpz@upm.es".equals(passenger.getEmail()) &&
                                Boolean.FALSE.equals(passenger.getAccesibility()))
        );

    }

    @Test
    void testEquals(){
        PassengerBusEntity passengerBusEntity = this.passengerBusRepository.findAll().stream().findFirst().get();
        PassengerBusEntity passengerBusTest = PassengerBusEntity.builder()
                .docIdentify(passengerBusEntity.getDocIdentify())
                .name(passengerBusEntity.getName())
                .familyName(passengerBusEntity.getFamilyName())
                .phone(passengerBusEntity.getPhone())
                .email(passengerBusEntity.getEmail())
                .accesibility(passengerBusEntity.getAccesibility())
                .build();

        passengerBusTest.setId(passengerBusEntity.getId());
        passengerBusTest.setReference(passengerBusEntity.getReference());

        assertEquals(passengerBusEntity, passengerBusTest);
    }

}
