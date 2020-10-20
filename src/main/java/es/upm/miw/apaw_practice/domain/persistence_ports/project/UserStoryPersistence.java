package es.upm.miw.apaw_practice.domain.persistence_ports.project;

import es.upm.miw.apaw_practice.domain.models.project.UserStory;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface UserStoryPersistence {

    void delete(String id);

    Stream<UserStory> readAll();
}
