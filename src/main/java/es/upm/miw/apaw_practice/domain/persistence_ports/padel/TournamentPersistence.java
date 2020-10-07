package es.upm.miw.apaw_practice.domain.persistence_ports.padel;

import es.upm.miw.apaw_practice.domain.models.padel.Tournament;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Repository
public interface TournamentPersistence {
    Tournament updateInitialDay(String id, LocalDateTime initialDay);
    Stream<Tournament> findByTournamentsAndNameDistintOfPlayer(String name);
}
