package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.domain.services.socialnetwork.SocialListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SocialListResource.LISTS)
public class SocialListResource {

    static final String LISTS = "/socialnetwork/lists";
    static final String ID = "/{id}";

    private SocialListService socialListService;

    @Autowired
    public SocialListResource(SocialListService socialListService) {
        this.socialListService = socialListService;
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable String id) {
        this.socialListService.delete(id);
    }

}
