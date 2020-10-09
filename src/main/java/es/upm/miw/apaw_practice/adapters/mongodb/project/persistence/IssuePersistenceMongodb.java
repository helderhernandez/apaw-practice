package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.IssueRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.IssueEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.project.Issue;
import es.upm.miw.apaw_practice.domain.persistence_ports.project.IssuePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("issuePersistence")
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

    @Override
    public Issue readById(String id) {
        return this.issueRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Issue id: " + id))
                .toIssue();
    }

    @Override
    public void update(Issue issue) {
        IssueEntity issueEntity = this.issueRepository
                .findById(issue.getId())
                .orElseThrow(() -> new NotFoundException("Issue id: " + issue.getId()));
        issueEntity.fromIssue(issue);
        this.issueRepository.save(issueEntity);
    }

}
