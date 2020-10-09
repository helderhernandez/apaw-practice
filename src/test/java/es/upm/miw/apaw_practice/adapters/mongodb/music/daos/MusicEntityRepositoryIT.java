package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class MusicEntityRepositoryIT {

    @Autowired
    private MusicRepository musicRepository;
    @Test
    void testCreateAndRead() {
        assertTrue(this.musicRepository.findAll().stream()
                .anyMatch(music ->
                        music.getId() !=null&&
                        "Fly to moon".equals(music.getName())&&
                        "a song of pop".equals(music.getDescription())


                ));
    }

}
