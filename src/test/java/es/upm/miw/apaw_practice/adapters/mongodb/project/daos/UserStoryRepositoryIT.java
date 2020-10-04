package es.upm.miw.apaw_practice.adapters.mongodb.project.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class UserStoryRepositoryIT {

    @Autowired
    private UserStoryRepository userStoryRepository;

    @Test
    void createAndRead() {
        assertTrue(this.userStoryRepository.findAll().stream()
                .anyMatch(userStory ->
                        "login".equals(userStory.getName()) &&
                                "Implement login feature".equals(userStory.getDescription()) &&
                                5 == userStory.getValue() &&
                                2 == userStory.getIssues().size()));
    }

}
