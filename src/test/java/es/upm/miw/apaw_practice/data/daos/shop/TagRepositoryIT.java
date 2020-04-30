package es.upm.miw.apaw_practice.data.daos.shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.data.model.entities.shop.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class TagRepositoryIT {

    @Autowired
    private TagRepository tagRepository;

    @Test
    void testCreateAndRead() {
        Optional<Tag> tag = this.tagRepository.findById("tag2");
        assertTrue(tag.isPresent());
        assertEquals("tag 2", tag.get().getDescription());
        assertEquals(Long.valueOf(84001), tag.get().getArticles().get(0).getBarcode());
        assertTrue(tag.get().getFavourite());

    }
}
