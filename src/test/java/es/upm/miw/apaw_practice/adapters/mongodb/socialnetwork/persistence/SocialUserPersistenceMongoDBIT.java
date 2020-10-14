package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SocialUserPersistenceMongoDBIT {

    @Autowired
    private SocialUserPersistenceMongoDB socialUserPersistenceMongoDB;

    @Test
    void testUpdateBiography() {
        Optional<SocialUser> socialUser = this.socialUserPersistenceMongoDB.readAll().findAny();
        assertTrue(socialUser.isPresent());
        this.socialUserPersistenceMongoDB.updateBiography(socialUser.get().getId(), "New test biography updated");
        Optional<SocialUser> socialUserUpdated = this.socialUserPersistenceMongoDB.readAll()
                .filter(socialUserAux -> socialUserAux.getId().equals(socialUser.get().getId()))
                .findFirst();
        assertTrue(socialUserUpdated.isPresent());
        assertEquals(socialUser.get().getNickName(), socialUserUpdated.get().getNickName());
        assertEquals("New test biography updated", socialUserUpdated.get().getBiography());
        assertEquals(socialUser.get().isVerified(), socialUserUpdated.get().isVerified());
        assertEquals(socialUser.get().getSocialListIds(), socialUserUpdated.get().getSocialListIds());
        assertEquals(socialUser.get().getSocialPostIds(), socialUserUpdated.get().getSocialPostIds());
        this.socialUserPersistenceMongoDB.updateBiography(socialUserUpdated.get().getId(), socialUser.get().getBiography());
    }

}
