package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.domain.models.project.Issue;
import es.upm.miw.apaw_practice.domain.services.project.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(IssueResource.ISSUE)
public class IssueResource {

    static final String ISSUE = "/project/issues";

    private IssueService issueService;

    @Autowired
    public IssueResource(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping
    public Stream<Issue> readAll() {
        return this.issueService.readAll();
    }

}
