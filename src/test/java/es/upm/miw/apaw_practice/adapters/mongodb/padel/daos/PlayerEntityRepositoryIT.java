package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class PlayerEntityRepositoryIT {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void getPlayerEntitiesByDni(){
        assertEquals("Diego",playerRepository.getPlayerEntitiesByDni("77013276A").orElse(null).getName());
        assertEquals("Diegoo",playerRepository.getPlayerEntitiesByDni("77013276B").orElse(null).getName());
        assertEquals("Diegooo",playerRepository.getPlayerEntitiesByDni("77013276C").orElse(null).getName());
        assertEquals("Diegoooo",playerRepository.getPlayerEntitiesByDni("77013276D").orElse(null).getName());

    }
}
