package es.upm.miw.apaw_practice.adapters.mongodb.shop;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class TagEntityRepositoryIT {

    @Autowired
    private TagRepository tagRepository;

    @Test
    void testCreateAndRead() {
        TagEntity tag = this.tagRepository.findById("tag2").get();
        assertEquals("tag 2", tag.getDescription());
        assertTrue(tag.getArticleEntities().stream()
                .map(ArticleEntity::getBarcode)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(84001L, 84004L)));
        assertTrue(tag.getFavourite());

    }
}
