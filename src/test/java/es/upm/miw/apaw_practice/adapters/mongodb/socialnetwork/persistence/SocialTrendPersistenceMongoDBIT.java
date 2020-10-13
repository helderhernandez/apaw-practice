package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SocialTrendPersistenceMongoDBIT {

    @Autowired
    private SocialTrendPersistenceMongoDB socialTrendPersistance;

    @Test
    void testReadByName() {
        Optional<SocialTrend> socialTrend = this.socialTrendPersistance.readByName("Europan")
                .filter(trend -> trend.getPosition() == 1)
                .findFirst();
        assertTrue(socialTrend.isPresent());
        assertNotNull(socialTrend.get().getId());
        assertNotNull(socialTrend.get().getSocialPostId());
    }

}
