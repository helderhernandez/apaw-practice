package es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GameDeveloperEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class GameDeveloperRepositoryTestIT {

    @Autowired
    private GameDeveloperRepository gameDeveloperRepository;

    @Test
    void testFindAll() {
        List<GameDeveloperEntity> gameDeveloperEntityList = gameDeveloperRepository.findAll();
        assertEquals(2, gameDeveloperEntityList.size());
        assertEquals("Alicia", gameDeveloperEntityList.get(1).getName());
        assertEquals("aliciamartinez@gmail.com", gameDeveloperEntityList.get(1).getEmail());
        assertEquals(654331290, gameDeveloperEntityList.get(1).getPhone());
    }

}