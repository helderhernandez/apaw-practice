package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.TagService;
import es.upm.miw.apaw_practice.data.shop.entities.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TagResource.BASE_PATH)
public class TagResource {
    static final String BASE_PATH = "/tags";
    static final String ID_ID = "/{id}";

    private TagService tagService;

    public TagResource(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(TagResource.ID_ID)
    public Tag read(@PathVariable String id) {
        return this.tagService.read(id);
    }
}
