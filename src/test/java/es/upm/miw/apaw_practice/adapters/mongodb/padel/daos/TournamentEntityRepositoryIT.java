package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
 class TournamentEntityRepositoryIT {
    @Autowired
    private TournamentRepository tournamentRepository;
    @Test
    void testFindByName(){
        assertEquals(2,this.tournamentRepository.findByName("TORNEO-A").orElse(null).size());
        assertEquals(1,this.tournamentRepository.findByName("TORNEO-B").orElse(null).size());
        assertEquals(1,this.tournamentRepository.findByName("TORNEO-C").orElse(null).size());
        assertEquals(3,this.tournamentRepository.findByName("TORNEO-B").orElse(null).get(0).getPlayerEntities().size());

    }
}
