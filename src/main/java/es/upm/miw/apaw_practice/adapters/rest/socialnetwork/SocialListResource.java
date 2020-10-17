package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.socialnetwork.SocialListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(SocialListResource.LISTS)
public class SocialListResource {

    static final String LISTS = "/socialnetwork/lists";
    static final String ID = "/{id}";
    static final String SEARCH = "/search";

    private SocialListService socialListService;

    @Autowired
    public SocialListResource(SocialListService socialListService) {
        this.socialListService = socialListService;
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable String id) {
        this.socialListService.delete(id);
    }

    @GetMapping(SEARCH)
    public Set<String> findVerifiedNickNamesByListName(@RequestParam String q) {
        String listName = new LexicalAnalyzer().extractWithAssure(q, "listName");
        return this.socialListService.findVerifiedNickNamesByListName(listName);
    }

}
