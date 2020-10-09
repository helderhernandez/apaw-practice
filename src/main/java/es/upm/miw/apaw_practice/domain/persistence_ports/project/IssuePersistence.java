package es.upm.miw.apaw_practice.domain.persistence_ports.project;

import es.upm.miw.apaw_practice.domain.models.project.Issue;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface IssuePersistence {

    Stream<Issue> readAll();

    Issue readById(String id);

    void update(Issue issue);

}
