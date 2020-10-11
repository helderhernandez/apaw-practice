package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GamePlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GamePlayerEntity;
import es.upm.miw.apaw_practice.domain.models.videogame.GamePlayer;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.GamePlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("GamePlayerPersistence")
public class GamePlayerPersistenceMongodb implements GamePlayerPersistence {

    private GamePlayerRepository gamePlayerRepository;

    @Autowired
    public GamePlayerPersistenceMongodb(GamePlayerRepository gamePlayerRepository) {
        this.gamePlayerRepository = gamePlayerRepository;
    }

    @Override
    public Stream<GamePlayer> readAll() {
        return gamePlayerRepository.findAll().stream()
                .map(GamePlayerEntity::toGamePlayer);
    }

    



}
