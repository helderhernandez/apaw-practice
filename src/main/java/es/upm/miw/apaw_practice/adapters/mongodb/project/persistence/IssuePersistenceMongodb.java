package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.IssueRepository;
import es.upm.miw.apaw_practice.domain.models.project.Issue;
import es.upm.miw.apaw_practice.domain.persistence_ports.project.IssuePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("IssuePersistence")
public class IssuePersistenceMongodb implements IssuePersistence {

    private IssueRepository issueRepository;

    @Autowired
    public IssuePersistenceMongodb(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public Stream<Issue> readAll() {
        return this.issueRepository.findAll().stream()
                .map(issueEntity -> issueEntity.toIssue());
    }

}
