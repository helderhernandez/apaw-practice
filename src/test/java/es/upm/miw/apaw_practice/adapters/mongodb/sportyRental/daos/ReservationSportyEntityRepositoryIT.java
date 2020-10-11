package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.CategorySportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.CustomerSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.DiscountSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.ReservationSportyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ReservationSportyEntityRepositoryIT {

    @Autowired
    private ReservationSportyRepository reservationSportyRepository;
    @Autowired
    private CustomerSportyRepository customerSportyRepository;
    @Autowired
    private CategorySportyRepository categorySportyRepository;
    @Autowired
    private DiscountSportyRepository discountSportyRepository;

    @Test
    void testFindByDni() {
        assertTrue(reservationSportyRepository.findByRefReservation("R3458902").isPresent());
        ReservationSportyEntity reservation = this.reservationSportyRepository.findByRefReservation("R3458902").get();
        assertEquals(LocalDateTime.of(2020, 11, 11, 0, 0), reservation.getDateReservation());
        assertEquals(new BigDecimal(20), reservation.getAmount());
        assertEquals(Boolean.FALSE, reservation.getPaidOut());
        assertEquals("Paddle", reservation.getCategorySportyEntity().getDescription());
        assertEquals(2, reservation.getCustomerSportyEntities().size());
        assertEquals(1, reservation.getDiscountSportyEntity().size());
    }


    @Test
    void testReservationCreateAndGet() {
        assertTrue(customerSportyRepository.findByDni("50506080J").isPresent());
        CustomerSportyEntity customer = this.customerSportyRepository.findByDni("50506080J").get();
        assertTrue(discountSportyRepository.findById("1").isPresent());
        DiscountSportyEntity discount = this.discountSportyRepository.findById("1").get();
        assertTrue(categorySportyRepository.findById("2").isPresent());
        CategorySportyEntity category = this.categorySportyRepository.findById("2").get();
        ReservationSportyEntity reservationSport = new ReservationSportyEntity("5", LocalDateTime.of(2020, 11, 26, 0, 0), "R3458909", new BigDecimal(20), Boolean.TRUE, List.of(customer), category,
                List.of(discount));
        this.reservationSportyRepository.save(reservationSport);
        assertTrue(this.reservationSportyRepository.findAll().stream().
                anyMatch(reservation -> "R3458909".equals(reservation.getRefReservation()) &&
                        reservation.getPaidOut()));
    }

    @Test
    void testReservationSet() {
        assertTrue(reservationSportyRepository.findByRefReservation("R3458902").isPresent());
        ReservationSportyEntity reservation = this.reservationSportyRepository.findByRefReservation("R3458902").get();

        reservation.setPaidOut(Boolean.TRUE);
        reservation.setDateReservation(LocalDateTime.of(2020, 11, 30, 0, 0));
        reservation.setAmount(new BigDecimal(20));
        assertEquals(Boolean.TRUE, reservation.getPaidOut());
        assertEquals(LocalDateTime.of(2020, 11, 30, 0, 0), reservation.getDateReservation());
        assertEquals(new BigDecimal(20), reservation.getAmount());

    }
}
