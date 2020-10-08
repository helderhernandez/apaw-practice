package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class LikesEntityRepositoryIT {

    @Autowired
    private LikesRepository likesRepository;
    private LikesEntity likes;

    @BeforeEach
    void before() {
        assertTrue(this.likesRepository.findById("likes-01").isPresent());
        likes =    this.likesRepository.findById("likes-01").get();
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.likesRepository.findAll().stream().
                anyMatch(likes -> "likes-01".equals(likes.getId()) &&
                        "Artes".equals(likes.getName()) &&
                        "Pintura, lienzos, pinceles".equals(likes.getDescription())
                ));
    }

    @Test
    void testSetAndGet() {
        likes.setId("id-001");
        likes.setName("test");
        likes.setDescription("likes of test");

        assertEquals("id-001",likes.getId());
        assertEquals("test",likes.getName());
        assertEquals("likes of test",likes.getDescription());
    }
}
