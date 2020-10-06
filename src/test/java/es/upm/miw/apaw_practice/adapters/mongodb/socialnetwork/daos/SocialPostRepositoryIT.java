package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SocialPostRepositoryIT {

    @Autowired
    private SocialPostRepository socialPostRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.socialPostRepository.findAll().stream()
                .anyMatch(socialPostEntity ->
                        "Lorem ipsum dolor sit amet".equals(socialPostEntity.getContent()) &&
                        0 == socialPostEntity.getShared() &&
                        0 == socialPostEntity.getLikes() &&
                        socialPostEntity.getPostingDate().isBefore(LocalDateTime.now())
                ));
    }

}
