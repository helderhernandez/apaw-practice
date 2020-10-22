package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.article.Essay;
import es.upm.miw.apaw_practice.domain.services.article.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(EssayResource.ESSAIES)
public class EssayResource {
    static final String ESSAIES = "/article/essaies";
    static final String SEARCH = "/search";
    static final String ID_ID = "{id}";
    static final String NAME = "/name";

    private final EssayService essayService;

    @Autowired
    public EssayResource(EssayService essayService) { this.essayService = essayService;}

    @PutMapping(ID_ID + NAME)
    public Essay updateName(@PathVariable String id, @RequestBody NewName newName) {
        return this.essayService.updateName(id, newName.getName());
    }
    @GetMapping(SEARCH)
    public Stream<Essay> findEssayIdByAuthor(@RequestParam String q){
        String nationality = new LexicalAnalyzer().extractWithAssure(q,"nationality");
        return this.essayService.findEssayIdByAuthor(nationality);
    }
}
