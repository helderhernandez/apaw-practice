package es.upm.miw.apaw_practice.data.shop.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TagRepositoryIT {

    @Autowired
    private TagRepository tagRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.tagRepository.findAll().stream()
                .anyMatch(tag -> "tag2".equals(tag.getDescription()) &&
                        2 == tag.getArticles().size() &&
                        84001L==tag.getArticles().get(0).getBarcode() &&
                        tag.getFavourite()
                ));
    }
}
