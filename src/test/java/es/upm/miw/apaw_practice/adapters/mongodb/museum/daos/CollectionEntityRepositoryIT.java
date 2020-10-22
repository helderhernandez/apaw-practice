package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtRestorerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.CollectionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PaintEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CollectionEntityRepositoryIT {

    @Autowired
    private CollectionRepository collectionRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.collectionRepository.findById("CCC2").isPresent());
        CollectionEntity collection = this.collectionRepository.findById("CCC1").get();
        assertEquals("CCC1", collection.getId());
        assertEquals("Collection_1", collection.getName());
        assertTrue(collection.getInitialDate().isEqual(LocalDate.now()));
        assertEquals(5, collection.getDuration());
        assertTrue(collection.getPaintEntities().stream()
                .map(PaintEntity::getId)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("PPP1", "PPP2")));
    }

}
