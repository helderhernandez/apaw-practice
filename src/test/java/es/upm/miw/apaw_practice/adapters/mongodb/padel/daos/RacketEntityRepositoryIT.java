package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class RacketEntityRepositoryIT {
    @Autowired
    private RacketRepository racketRepository;

    @Test
    void findAllByBrand(){
        assertEquals(2,this.racketRepository.findAllByBrand("BRAND-A").size());
        assertEquals(1,this.racketRepository.findAllByBrand("BRAND-B").size());
        assertTrue(this.racketRepository.findAllByBrand("BRAND-Z").isEmpty());
        assertEquals("DDDDD",this.racketRepository.findAllByBrand("BRAND-D").get(0).getName());


    }
}
