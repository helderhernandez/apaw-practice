package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
 class ReservationEntityRepositoryIT {
    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void testFindAllByDateBefore(){
        LocalDate testDate = LocalDate.of(2000,10,20);
        assertEquals(4,this.reservationRepository.findAllByDateBefore(testDate).orElse(null).size());
        testDate = LocalDate.of(1998,10,20);
        assertEquals(2,this.reservationRepository.findAllByDateBefore(testDate).orElse(null).size());

    }
}
