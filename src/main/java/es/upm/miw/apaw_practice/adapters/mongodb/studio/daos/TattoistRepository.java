package es.upm.miw.apaw_practice.adapters.mongodb.studio.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.TattoistEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TattoistRepository extends MongoRepository<TattoistEntity, String> {
    Optional<TattoistEntity> findByNickname(String nickname);
}
