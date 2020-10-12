package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.ShopSeederService;
import es.upm.miw.apaw_practice.domain.models.sportyRental.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testCreateReservation() {
        CustomerCreationSporty customerCreation = new CustomerCreationSporty("50908840P", "Nestor", "Perez Diaz", "nestor.perez@gmail.com", "776456300");
        CategoryCreationSporty categoryCreation = new CategoryCreationSporty("Hockey", 10);
        DiscountCreationSporty discountCreation = new DiscountCreationSporty("Promotion 25%", 25.0);

        ReservationCreationSporty reservationCreation =
                new ReservationCreationSporty(new BigDecimal(20), Boolean.TRUE, List.of(customerCreation), categoryCreation, List.of(discountCreation));
        ReservationSporty reservationSporty = this.reservationSportyPersistenceMongodb.create(reservationCreation);
        assertNotNull(reservationSporty.getRefReservation());
        assertTrue(reservationSporty.getPaidOut());
        assertEquals("Hockey", reservationSporty.getCategorySporty().getDescription());
        assertEquals(1, reservationSporty.getCustomersSporty().size());
        assertEquals("50908840P", reservationSporty.getCustomersSporty().get(0).getDni());
        assertEquals(1, reservationSporty.getDiscountsSporty().size());
        assertEquals("Promotion 25%", reservationSporty.getDiscountsSporty().get(0).getDescription());
    }
}
