package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.LabelRepository;
import es.upm.miw.apaw_practice.domain.models.project.Label;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class LabelPersistenceMongodbIT {

    @Autowired
    private LabelPersistenceMongodb labelPersistence;
    @Autowired
    private LabelRepository labelRepository;

    @Test
    void testCreate() {
        this.labelPersistence.create(new Label("test label", "test label"));
        assertTrue(this.labelRepository.findAll().stream()
                .anyMatch(labelEntity ->
                        "test label".equals(labelEntity.getName()) &&
                                "test label".equals(labelEntity.getDescription())));
    }

}
