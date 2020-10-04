package es.upm.miw.apaw_practice.adapters.mongodb.project.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class LabelEntityRepositoryIT {

    @Autowired
    private LabelRepository labelRepository;

    @Test
    void createAndRead() {
        assertTrue(this.labelRepository.findAll().stream()
                .anyMatch(label ->
                        "enhancement".equals(label.getName()) &&
                                "New feature or request".equals(label.getDescription())));
    }

}
