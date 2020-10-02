package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
 class ReservationEntityRepositoryIT {
    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void testFindAllByDateBefore(){
        LocalDateTime testDate = LocalDateTime.of(2000,10,20,0,0);
        assertEquals(4,this.reservationRepository.findAllByDateBefore(testDate).orElse(null).size());
        testDate = LocalDateTime.of(1998,10,20,0,0);
        assertEquals(2,this.reservationRepository.findAllByDateBefore(testDate).orElse(null).size());

    }
}
