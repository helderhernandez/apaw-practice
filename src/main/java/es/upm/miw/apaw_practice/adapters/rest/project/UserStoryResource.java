package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.project.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(UserStoryResource.USER_STORY)
public class UserStoryResource {

    static final String USER_STORY = "/project/user-stories";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private UserStoryService userStoryService;

    @Autowired
    public UserStoryResource(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.userStoryService.delete(id);
    }

    @GetMapping(SEARCH)
    public Stream<String> findByLabelName(@RequestParam String q) {
        String labelName = new LexicalAnalyzer().extractWithAssure(q, "labelName");
        return this.userStoryService.findByLabelName(labelName);
    }

}
