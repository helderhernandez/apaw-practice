package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.domain.services.article.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WorksResource.WORKSES)
public class WorksResource {
    static final String WORKSES = "/article/workses";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private final WorksService worksService;

    @Autowired
    public WorksResource(WorksService worksService) { this.worksService = worksService; }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) { this.worksService.delete(id);}
}
