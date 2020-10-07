package es.upm.miw.apaw_practice.adapters.mongodb.project;

import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.DeveloperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.IssueRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.LabelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.UserStoryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.DeveloperEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.IssueEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.LabelEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.UserStoryEntity;
import es.upm.miw.apaw_practice.domain.models.project.Label;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProjectSeederService {

    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private UserStoryRepository userStoryRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Project Initial Load -----------");
        LabelEntity[] labels = {
                new LabelEntity(new Label("enhancement", "New feature or request")),
                new LabelEntity(new Label("documentation", "Improvements or additions to documentation")),
                new LabelEntity(new Label("bug", "Something isn't working")),
                new LabelEntity(new Label("test", "Test new code"))
        };
        this.labelRepository.saveAll(Arrays.asList(labels));
        DeveloperEntity[] developers = {
                new DeveloperEntity("Jaime", "jaime@developer.com", 7),
                new DeveloperEntity("Alberto", "alberto@developer.com", 3),
                new DeveloperEntity("Marta", "marta@developer.com", 12)
        };
        this.developerRepository.saveAll(Arrays.asList(developers));
        IssueEntity[] issues = {
                new IssueEntity("create class user", 2, developers[0], Arrays.asList(labels[0], labels[1])),
                new IssueEntity("test class user", 1, developers[2], Arrays.asList(labels[3], labels[1])),
                new IssueEntity("setup environment", 5, developers[1], Arrays.asList(labels[2], labels[0]))
        };
        this.issueRepository.saveAll(Arrays.asList(issues));
        UserStoryEntity[] userStories = {
                new UserStoryEntity("login", "Implement login feature", 5, Arrays.asList(issues[0], issues[1])),
                new UserStoryEntity("environment", "Setup continuous integration environment", 8, Arrays.asList(issues[2])),
                new UserStoryEntity("delete", "Issue to delete", 8, Arrays.asList(issues[2]))
        };
        userStoryRepository.saveAll(Arrays.asList(userStories));
    }

    public void deleteAll() {
        this.labelRepository.deleteAll();
        this.developerRepository.deleteAll();
        this.issueRepository.deleteAll();
        this.userStoryRepository.deleteAll();
    }

}
