package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SocialTrendRepositoryIT {

    @Autowired
    private SocialTrendRepository socialTrendRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.socialTrendRepository.findAll().stream()
                .anyMatch(socialTrendEntity ->
                        "Europan".equals(socialTrendEntity.getName()) &&
                        1 == socialTrendEntity.getPosition() &&
                        "Li Europan lingues es membres".equals(socialTrendEntity.getSocialPostEntity().getContent()) &&
                        4 == socialTrendEntity.getSocialPostEntity().getShared() &&
                        6 == socialTrendEntity.getSocialPostEntity().getLikes() &&
                        socialTrendEntity.getSocialPostEntity().getPostingDate().isBefore(LocalDateTime.now())
                ));
    }

}
