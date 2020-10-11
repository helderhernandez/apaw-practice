package es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.LevelEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class LevelRepositoryIT {

    @Autowired
    private LevelRepository levelRepository;

    @Test
    void testFindAll() {
        List<LevelEntity> levelEntityList = levelRepository.findAll();
        assertEquals("level 1", levelEntityList.get(0).getDescription());
        assertEquals(800, levelEntityList.get(1).getRecordPoints());
        assertEquals(1, levelEntityList.get(1).getGamePlayerEntities().size());
        assertEquals("Alicia", levelEntityList.get(2).getGameDeveloperEntity().getName());
    }
}