package es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GamePlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class GamePlayerRepositoryIT {

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Test
    void testFindAll() {
        List<GamePlayerEntity> gamePlayerEntityList = gamePlayerRepository.findAll();

        assertEquals("natcas", gamePlayerEntityList.get(1).getNickName());
        assertEquals(300, gamePlayerEntityList.get(1).getPoints());
        assertTrue(gamePlayerEntityList.get(1).getPremiumPlayer());
        assertEquals(1, gamePlayerEntityList.get(2).getChallengeEntities().size());
    }

}