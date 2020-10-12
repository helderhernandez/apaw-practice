package es.upm.miw.apaw_practice.adapters.mongodb.padel.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.RacketRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.TournamentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.PlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.RacketEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.padel.Player;
import es.upm.miw.apaw_practice.domain.models.padel.Racket;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.RacketPersistence;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("RacketPersistence")
public class RacketPersistenceMongodb implements RacketPersistence {
    private RacketRepository racketRepository;
    private TournamentRepository tournamentRepository;

    @Autowired
    public RacketPersistenceMongodb(RacketRepository racketRepository, TournamentRepository tournamentRepository) {
        this.racketRepository = racketRepository;
        this.tournamentRepository = tournamentRepository;
    }

    public Racket update(Racket racket) {
        RacketEntity racketEntity = this.racketRepository.findById(racket.getId())
                .orElseThrow(() -> new NotFoundException("Racket id:" + racket.getId()));

        racketEntity.fromRacket(racket);
        return this.racketRepository
                .save(racketEntity)
                .toRacket();
    }

    @Override
    public Stream<Racket> readByBrand(String brand) {
        if (this.racketRepository.findAllByBrand(brand).isEmpty()) {
            throw new NotFoundException("Racket brand: " + brand);
        }
        return this.racketRepository.findAllByBrand(brand)
                .stream()
                .map(RacketEntity::toRacket);
    }

    @Override
    public void deleteById(String id) {
        this.racketRepository.deleteById(id);
    }


    private Stream<PlayerEntity> findPlayersToPlayInLevelTournamentGreaterThan(Integer level) {
        return this.tournamentRepository.findAll().stream()
                .filter(tournamentEntity -> tournamentEntity.getLevel() > level)
                .flatMap(tournamentEntity -> tournamentEntity.getPlayerEntities().stream())
                .distinct();

    }

    @Override
    public Stream<String> findBrandRacketPlayersToPlayInLevelTournamentGreaterThan(Integer level) {
        List<PlayerEntity> players = findPlayersToPlayInLevelTournamentGreaterThan(level)
                .collect(Collectors.toList());
        System.out.println(players.toString());

        return this.racketRepository.findAll().stream()
                .peek(x-> LogManager.getLogger(this.getClass()).info("RESULTADO0:" + x))
                .filter(racketEntity -> players.contains(racketEntity.getPlayerEntity()))
                .peek(x-> LogManager.getLogger(this.getClass()).info("RESULTADO1:" + x))
                .map(RacketEntity::toRacket)
                .map(Racket::getBrand)
                .distinct()
                .peek(x-> LogManager.getLogger(this.getClass()).info("RESULTADO2:" + x));
    }
}
