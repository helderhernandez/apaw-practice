package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialUserRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialUserEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialUserPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("socialUserPersistance")
public class SocialUserPersistanceMongoDB implements SocialUserPersistance {

    private SocialUserRepository socialUserRepository;

    @Autowired
    public SocialUserPersistanceMongoDB(SocialUserRepository socialUserRepository) {
        this.socialUserRepository = socialUserRepository;
    }

    @Override
    public SocialUser create(SocialUserCreation socialUserCreation) {
        this.assertNickNameNotExist(socialUserCreation.getNickName());
        return this.socialUserRepository
                .save(new SocialUserEntity(socialUserCreation))
                .toSocialUser();
    }

    private void assertNickNameNotExist(String nickName) {
        this.socialUserRepository
                .findByNickName(nickName)
                .ifPresent(socialUserEntity -> {
                    throw new ConflictException("NickName exist: " + nickName);
                });
    }

}
