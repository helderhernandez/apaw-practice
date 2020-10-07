package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.domain.services.project.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserStoryResource.USER_STORY)
public class UserStoryResource {

    static final String USER_STORY = "user-stories";
    static final String ID_ID = "/{id}";

    private UserStoryService userStoryService;

    @Autowired
    public UserStoryResource(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.userStoryService.delete(id);
    }

}
