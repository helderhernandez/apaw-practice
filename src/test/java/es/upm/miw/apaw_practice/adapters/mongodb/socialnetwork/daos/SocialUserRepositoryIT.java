package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SocialUserRepositoryIT {

    @Autowired
    private SocialUserRepository socialUserRepository;

    @Test
    void testFindByNickName() {
        assertTrue(this.socialUserRepository.findByNickName("Famoso_oficial").isPresent());
        SocialUserEntity socialUserEntity = this.socialUserRepository.findByNickName("Famoso_oficial").get();
        assertEquals("Cuenta Oficial", socialUserEntity.getBiography());
        assertEquals(true, socialUserEntity.isVerified());
        assertEquals("Li Europan lingues es membres", socialUserEntity.getSocialPostEntities().get(0).getContent());
        assertEquals(4, socialUserEntity.getSocialPostEntities().get(0).getShared());
        assertEquals(6, socialUserEntity.getSocialPostEntities().get(0).getLikes());
        assertEquals("abc def ghi jkl mno", socialUserEntity.getSocialPostEntities().get(1).getContent());
        assertEquals(3, socialUserEntity.getSocialPostEntities().get(1).getShared());
        assertEquals(5, socialUserEntity.getSocialPostEntities().get(1).getLikes());
        assertEquals("Friends", socialUserEntity.getSocialListEntities().get(0).getName());
        assertEquals("My friends", socialUserEntity.getSocialListEntities().get(0).getDescription());
        assertEquals(true, socialUserEntity.getSocialListEntities().get(0).isPersonal());
    }

}
