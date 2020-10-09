package es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.basketball.entities.MemberTeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemberTeamRepository extends MongoRepository<MemberTeamEntity, String> {
    Optional<MemberTeamEntity> findMemberByDni(String dni);
}
