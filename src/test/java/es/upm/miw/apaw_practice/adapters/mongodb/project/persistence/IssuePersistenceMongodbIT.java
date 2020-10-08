package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.project.Issue;
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

    @Test
    void testFindById() {
        assertTrue(this.issuePersistence.readAll()
                .filter(issue -> issue.getName().equals("setup environment"))
                .findFirst().isPresent());
        Issue issueToFind = this.issuePersistence.readAll()
                .filter(issue -> issue.getName().equals("setup environment"))
                .findFirst().get();
        assertTrue(this.issuePersistence.readById(issueToFind.getId())
                .getName().equals("setup environment"));
    }

    @Test
    void testUpdate() {
        assertTrue(this.issuePersistence.readAll()
                .filter(issue -> issue.getName().equals("setup environment"))
                .findFirst().isPresent());
        Issue issueToUpdate = this.issuePersistence.readAll()
                .filter(issue -> issue.getName().equals("setup environment"))
                .findFirst().get();
        issueToUpdate.setDone(true);
        this.issuePersistence.update(issueToUpdate);
        assertTrue(this.issuePersistence.readById(issueToUpdate.getId())
                .getDone());
    }

}
