package es.upm.miw.apaw_practice.adapters.mongodb.padel.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.TournamentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.PlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.TournamentEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.padel.Tournament;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.TournamentPersistence;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Repository("tournamentPersistence")
public class TournamentPersistenceMongodb implements TournamentPersistence {

    private TournamentRepository tournamentRepository;

    @Autowired
    public TournamentPersistenceMongodb(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Tournament updateInitialDay(String id, LocalDateTime initialDay) {
        TournamentEntity tournamentEntity = this.tournamentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Tournament id: "+id));

        tournamentEntity.setStartDay(initialDay);
        return this.tournamentRepository.save(tournamentEntity).toTournament();
    }

    @Override
    public Stream<Tournament> findByTournamentsAndNameDistintOfPlayer(String name){
        return this.tournamentRepository.findAll().stream()
                .filter(tournament -> tournament.getPlayerEntities().stream()
                        .anyMatch(playerEntity -> playerEntity.getName().equals(name)))
                .map(TournamentEntity::toTournament)
                .peek(x-> LogManager.getLogger(this.getClass()).info("RESULTADO:" + x));

    }


}
