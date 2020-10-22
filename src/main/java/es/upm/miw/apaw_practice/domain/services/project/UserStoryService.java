package es.upm.miw.apaw_practice.domain.services.project;

import es.upm.miw.apaw_practice.domain.models.project.UserStory;
import es.upm.miw.apaw_practice.domain.persistence_ports.project.UserStoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserStoryService {

    private UserStoryPersistence userStoryPersistence;

    @Autowired
    public UserStoryService(UserStoryPersistence userStoryPersistence) {
        this.userStoryPersistence = userStoryPersistence;
    }

    public void delete(String id) {
        this.userStoryPersistence.delete(id);
    }

    public Stream<String> findByLabelName(String labelName) {
        return this.userStoryPersistence.readAll()
                .filter(userStory -> userStory.hasLabel(labelName))
                .map(UserStory::getName);
    }

}
