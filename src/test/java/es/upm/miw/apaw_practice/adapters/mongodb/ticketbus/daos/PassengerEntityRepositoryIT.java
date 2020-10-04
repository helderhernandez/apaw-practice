package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class PassengerEntityRepositoryIT {

    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    void testCreateAndRead() {

        assertTrue(this.passengerRepository.findAll().stream()
                .anyMatch(passenger ->
                        "89386661J".equals(passenger.getDocIdentify()) &&
                                "Juan".equals(passenger.getName()) &&
                                "Perez".equals(passenger.getFamilyName()) &&
                                "651112234".equals(passenger.getPhone()) &&
                                "jpz@upm.es".equals(passenger.getEmail()) &&
                                Boolean.FALSE.equals(passenger.getAccesibility()))
        );

    }
}
