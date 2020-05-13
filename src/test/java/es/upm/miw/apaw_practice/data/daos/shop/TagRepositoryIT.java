package es.upm.miw.apaw_practice.data.daos.shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.data.model.entities.shop.Article;
import es.upm.miw.apaw_practice.data.model.entities.shop.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class TagRepositoryIT {

    @Autowired
    private TagRepository tagRepository;

    @Test
    void testCreateAndRead() {
        Tag tag = this.tagRepository.findById("tag2").get();
        assertEquals("tag 2", tag.getDescription());
        assertTrue(tag.getArticles().stream()
                .map(Article::getBarcode)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(84001L, 84004L)));
        assertTrue(tag.getFavourite());

    }
}
