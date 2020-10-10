package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;


import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SingerEntityRepositoryIT {

    @Autowired
    private SingerRepository singerRepository;

    @Test
    void testCreateAndRead() {

        assertTrue(this.singerRepository.findAll().stream()
                .anyMatch(singer ->
                        singer.getId() != null &&
                        "Bruno".equals(singer.getName()) &&
                        "Mars".equals(singer.getSurname()) &&
                        "America".equals(singer.getNationality())

        ));
    }
}
