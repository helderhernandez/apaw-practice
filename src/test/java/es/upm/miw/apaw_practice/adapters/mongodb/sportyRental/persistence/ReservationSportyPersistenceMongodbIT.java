package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationSporty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ReservationSportyPersistenceMongodbIT {

    @Autowired
    private ReservationSportyPersistenceMongodb reservationSportyPersistenceMongodb;

    @Autowired
    private ShopSeederService shopSeederService;

    @Test
    void testReadByRefReservation() {
        ReservationSporty reservationSporty = this.reservationSportyPersistenceMongodb.readByRefReservation("R3458901");
        assertEquals("1", reservationSporty.getIdReservation());
        assertEquals(LocalDateTime.of(2020, 11, 10, 0, 0), reservationSporty.getDateReservation());
        assertEquals("1", reservationSporty.getCategorySporty().getIdCategory());
        assertEquals(3, reservationSporty.getCustomersSporty().size());
        assertEquals(2, reservationSporty.getDiscountsSporty().size());
        assertTrue(reservationSporty.getPaidOut());
    }
}
