package es.upm.miw.apaw_practice.business.rest.shop;

import es.upm.miw.apaw_practice.business.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.business.services.shop.TagService;
import es.upm.miw.apaw_practice.data.model.dtos.shop.TagDto;
import es.upm.miw.apaw_practice.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(TagResource.TAGS)
public class TagResource {
    static final String TAGS = "/tags";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private TagService tagService;

    @Autowired
    public TagResource(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(ID_ID)
    public TagDto read(@PathVariable String id) {
        return this.tagService.read(id);
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.tagService.delete(id);
    }

    @GetMapping(SEARCH)
    public Stream<TagDto> findByArticlesInShoppingCarts(@RequestParam String q) {
        if (!"in".equals(new LexicalAnalyzer().extractAssured(q, "shopping-carts"))) {
            throw new BadRequestException("q incorrect, expected in");
        }
        return this.tagService.findByArticlesInShoppingCarts();
    }
}
