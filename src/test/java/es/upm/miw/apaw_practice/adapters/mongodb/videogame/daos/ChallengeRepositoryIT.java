package es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.ChallengeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ChallengeRepositoryIT {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Test
    void testFindAll(){
        List<ChallengeEntity> challengeEntityList = challengeRepository.findAll();
        assertEquals("Get all red objects",challengeEntityList.get(0).getDescription());
        assertFalse(challengeEntityList.get(1).getCompleted());
        assertTrue(challengeEntityList.get(2).getCompleted());
    }

}