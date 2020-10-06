package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class IssuePersistenceMongodbIT {

    @Autowired
    private IssuePersistenceMongodb issuePersistence;

    @Test
    void testReadAll() {
        assertTrue(this.issuePersistence.readAll()
                .anyMatch(issue ->
                        "create class user".equals(issue.getName()) &&
                                2 == issue.getEstimatedHours() &&
                                issue.getDueDate().isBefore(LocalDateTime.now()) &&
                                !issue.getDone() &&
                                "jaime@developer.com".equals(issue.getDeveloper().getEmail()) &&
                                2 == issue.getLabels().size()));
    }

}
