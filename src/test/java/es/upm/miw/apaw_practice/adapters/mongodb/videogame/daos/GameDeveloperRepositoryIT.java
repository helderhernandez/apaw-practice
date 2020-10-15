package es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GameDeveloperEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.composite.GameDevelopersLeaf;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.composite.TreeGameDevelopers;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.composite.TreeGameDevelopersComposite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class GameDeveloperRepositoryIT {

    @Autowired
    private GameDeveloperRepository gameDeveloperRepository;

    @Test
    void testFindAll() {
        List<GameDeveloperEntity> gameDeveloperEntityList = gameDeveloperRepository.findAll();
        assertEquals("Alicia", gameDeveloperEntityList.get(1).getName());
        assertEquals("aliciamartinez@gmail.com", gameDeveloperEntityList.get(1).getEmail());
        assertEquals(654331290, gameDeveloperEntityList.get(1).getPhone());
    }

    @Test
    void testPatternComposite(){
        TreeGameDevelopers gameDevelopersComposite1 = new TreeGameDevelopersComposite("Software");
        TreeGameDevelopersComposite gameDevelopersComposite2 = new TreeGameDevelopersComposite("Hardware");
        TreeGameDevelopersComposite gameDevelopersComposite3 = new TreeGameDevelopersComposite("Design");


        TreeGameDevelopers gameDevelopersLeaf1 = new GameDevelopersLeaf(this.gameDeveloperRepository.findByName("Pedro").get());
        TreeGameDevelopers gameDevelopersLeaf2 = new GameDevelopersLeaf(this.gameDeveloperRepository.findByName("Alicia").get());

        gameDevelopersComposite1.add(gameDevelopersLeaf1);
        gameDevelopersComposite1.add(gameDevelopersLeaf2);
        gameDevelopersComposite2.add(gameDevelopersLeaf2);
        gameDevelopersComposite3.add(gameDevelopersLeaf1);
        gameDevelopersComposite3.add(gameDevelopersLeaf2);

        gameDevelopersComposite3.remove(gameDevelopersLeaf2);

        assertTrue(gameDevelopersComposite1.isComposite());
        assertFalse(gameDevelopersLeaf2.isComposite());
        assertThrows(UnsupportedOperationException.class,
                () -> gameDevelopersLeaf1.add(new GameDevelopersLeaf(this.gameDeveloperRepository.findByName("Pedro").get())));

        assertEquals("[Pedro, Alicia]", gameDevelopersComposite1.getGameDevelopersName().toString());
        assertEquals("[Pedro]", gameDevelopersComposite3.getGameDevelopersName().toString());

        assertEquals("Hardware", gameDevelopersComposite2.getName());



    }

}