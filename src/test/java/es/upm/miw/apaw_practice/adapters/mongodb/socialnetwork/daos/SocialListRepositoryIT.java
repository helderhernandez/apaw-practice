package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SocialListRepositoryIT {

    @Autowired
    private SocialListRepository socialListRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.socialListRepository.findAll().stream()
                .anyMatch(socialListEntity ->
                        "Family".equals(socialListEntity.getName()) &&
                        "My family members".equals(socialListEntity.getDescription()) &&
                        socialListEntity.isPersonal() &&
                        socialListEntity.getId() != null &&
                        socialListEntity.getDescription() != null &&
                        "Alicia97".equals(socialListEntity.getSocialUserEntities().get(0).getNickName())
                ));
    }

}
