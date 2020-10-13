package es.upm.miw.apaw_practice.domain.persistence_ports.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.models.videogame.Level;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface LevelPersistence {

    Stream<Level> readAll();

    Stream<Challenge> findCompletedChallengesByDescription(String description);
}
