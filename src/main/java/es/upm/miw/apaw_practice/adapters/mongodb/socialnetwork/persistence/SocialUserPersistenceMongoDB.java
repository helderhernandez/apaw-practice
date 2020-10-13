package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialUserRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialUserEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialUserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("socialUserPersistence")
public class SocialUserPersistenceMongoDB implements SocialUserPersistence {

    private SocialUserRepository socialUserRepository;

    @Autowired
    public SocialUserPersistenceMongoDB(SocialUserRepository socialUserRepository) {
        this.socialUserRepository = socialUserRepository;
    }

    @Override
    public SocialUser create(SocialUserCreation socialUserCreation) {
        this.assertNickNameNotExist(socialUserCreation.getNickName());
        return this.socialUserRepository
                .save(new SocialUserEntity(socialUserCreation))
                .toSocialUser();
    }

    @Override
    public SocialUser updateBiography(String id, String biography) {
        SocialUserEntity socialUserEntity = this.socialUserRepository.findById(id)
                                                .orElseThrow(() -> new NotFoundException("SocialUser id: " + id));
        socialUserEntity.setBiography(biography);
        return this.socialUserRepository.save(socialUserEntity).toSocialUser();
    }

    @Override
    public Stream<SocialUser> readAll() {
        return this.socialUserRepository.findAll().stream()
                .map(SocialUserEntity::toSocialUser);
    }

    private void assertNickNameNotExist(String nickName) {
        this.socialUserRepository
                .findByNickName(nickName)
                .ifPresent(socialUserEntity -> {
                    throw new ConflictException("NickName exist: " + nickName);
                });
    }

}
