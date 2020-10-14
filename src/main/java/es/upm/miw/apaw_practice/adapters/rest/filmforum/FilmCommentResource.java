package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.filmforum.FilmCommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FilmCommentResource.COMMENT)
public class FilmCommentResource {

    public static final String COMMENT = "/filmforum/comments";
    public static final String ID_ID = "/{id}";
    public static final String ACTOR = "/actor";

    private FilmCommentService filmCommentService;

    public FilmCommentResource(FilmCommentService filmCommentService) {
        this.filmCommentService = filmCommentService;
    }

    @DeleteMapping(ID_ID)
    public void deleteComment(@PathVariable String id) {
        filmCommentService.delete(id);
    }

    @GetMapping(ACTOR)
    public List<String> findCommentsOfFilmsFromActor(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return filmCommentService.getContentsOfFilmCommentsFromActorName(name);
    }
}
