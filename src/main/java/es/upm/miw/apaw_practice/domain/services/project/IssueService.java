package es.upm.miw.apaw_practice.domain.services.project;

import es.upm.miw.apaw_practice.domain.models.project.Issue;
import es.upm.miw.apaw_practice.domain.persistence_ports.project.IssuePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class IssueService {

    private IssuePersistence issuePersistence;

    @Autowired
    public IssueService(IssuePersistence issuePersistence) {
        this.issuePersistence = issuePersistence;
    }

    public Stream<Issue> readAll() {
        return this.issuePersistence.readAll();
    }

}
