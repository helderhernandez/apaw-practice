package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class IllnessEntityRepositoryIT {

    @Autowired
    private IllnessRepository illnessRepository;

    @Test
    void testFindByContagious() {
        assertEquals(2, this.illnessRepository.findByContagious(true).orElse(null).size());
        assertEquals(3, this.illnessRepository.findByContagious(false).orElse(null).size());
        assertEquals(4, this.illnessRepository.findByContagious(true).orElse(null).get(1).getPhase());
    }
}
