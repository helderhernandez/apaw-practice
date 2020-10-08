package es.upm.miw.apaw_practice.domain.services.padel;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.TournamentRepository;
import es.upm.miw.apaw_practice.domain.models.padel.Tournament;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.TournamentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
public class TournamentService {
    private TournamentPersistence tournamentPersistence;

    @Autowired

    public TournamentService(TournamentPersistence tournamentPersistence) {
        this.tournamentPersistence = tournamentPersistence;
    }

    public Tournament uptadeStartDay(String id, LocalDateTime startDay){
        return this.tournamentPersistence.updateInitialDay(id,startDay);
    }

    public Stream<Tournament> findByTournamentsAndNameDistintOfPlayer(String name){
        return this.tournamentPersistence.findByTournamentsAndNameDistintOfPlayer(name);
    }

}
