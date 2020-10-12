package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GamePlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GamePlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class GamePlayerPersistenceMongodbIT {

    @Autowired
    private GamePlayerPersistenceMongodb gamePlayerPersistence;

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Test
    void testDeleteById(){
        GamePlayerEntity gamePlayerEntity = this.gamePlayerRepository.findAll().stream()
                .filter(gamePlayer -> gamePlayer.getNickName().equals("a89"))
                .findFirst().get();

        this.gamePlayerPersistence.delete(gamePlayerEntity.getId());
        assertFalse(this.gamePlayerRepository.findAll().stream()
                .anyMatch(gamePlayer -> "a89".equals(gamePlayer.getNickName())));
    }
}