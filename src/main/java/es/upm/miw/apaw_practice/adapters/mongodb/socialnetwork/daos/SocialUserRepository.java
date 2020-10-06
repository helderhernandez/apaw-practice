package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SocialUserRepository extends MongoRepository<SocialUserEntity, String> {
    Optional<SocialUserEntity> findByNickName(String nickName);
}
