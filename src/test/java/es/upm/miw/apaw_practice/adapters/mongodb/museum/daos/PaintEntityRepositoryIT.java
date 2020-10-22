package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtRestorerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PaintEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class PaintEntityRepositoryIT {

    @Autowired
    private PaintRepository paintRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.paintRepository.findById("PPP1").isPresent());
        PaintEntity paint = this.paintRepository.findById("PPP3").get();
        assertEquals("PPP3", paint.getId());
        assertEquals("Paint3", paint.getName());
        assertEquals("Technique2", paint.getTechnique());
        assertEquals("Technique2", paint.getTechnique());
        assertEquals(true, paint.getRestoring());
        assertEquals("AAA4", paint.getArtistEntity().getId());
        assertTrue(paint.getArtRestorerEntities().stream()
                .map(ArtRestorerEntity::getId)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("ARR3")));
    }
}
