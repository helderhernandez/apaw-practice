package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.TournamentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TournamentRepository extends MongoRepository<TournamentEntity,String> {
    Optional<List<TournamentEntity>> findByName(String name);
}
