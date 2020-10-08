package es.upm.miw.apaw_practice.domain.persistence_ports.padel;

import es.upm.miw.apaw_practice.domain.models.padel.Racket;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface RacketPersistence {
    Racket update(Racket racket);
    Stream<Racket> readByBrand(String brand);
    void deleteById(String id);
    Stream<String> findBrandRacketPlayersToPlayInLevelTournamentGreaterThan(Integer level);
}
