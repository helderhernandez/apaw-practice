package es.upm.miw.apaw_practice.adapters.mongodb.project.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.LabelEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class LabelEntityRepositoryIT {

    @Autowired
    private LabelRepository labelRepository;

    @Test
    void testFindById() {
        assertTrue(this.labelRepository.findById("0").isPresent());
        LabelEntity label = this.labelRepository.findById("0").get();
        assertEquals("enhancement", label.getName());
        assertEquals("New feature or request", label.getDescription());
    }

}
