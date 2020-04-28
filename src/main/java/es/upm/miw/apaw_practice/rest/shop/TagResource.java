package es.upm.miw.apaw_practice.rest.shop;

import es.upm.miw.apaw_practice.business.shop.TagService;
import es.upm.miw.apaw_practice.data.shop.entities.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TagResource.TAGS)
public class TagResource {
    static final String TAGS = "/tags";
    static final String ID_ID = "/{id}";

    private TagService tagService;

    public TagResource(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(TagResource.ID_ID)
    public Tag read(@PathVariable String id) {
        return this.tagService.read(id);
    }

    @DeleteMapping(TagResource.ID_ID)
    public void delete(@PathVariable String id) {
        this.tagService.delete(id);
    }
}
