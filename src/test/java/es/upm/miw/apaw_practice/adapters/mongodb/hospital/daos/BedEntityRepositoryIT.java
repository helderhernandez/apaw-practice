package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class BedEntityRepositoryIT {

    @Autowired
    private BedRepository bedRepository;

    @Test
    void testFindByInternedDate() {
        assertEquals(2, this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 10, 2, 10, 0)).orElse(null).size());
        assertEquals(1, this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 10, 3, 15, 0)).orElse(null).size());
        assertEquals(105, this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 10, 2, 10, 0)).orElse(null).get(0).getWidth());
        assertTrue(this.bedRepository.findByInternedDate(LocalDateTime.of(2020, 1, 1, 9, 0)).get().isEmpty());
    }

}
