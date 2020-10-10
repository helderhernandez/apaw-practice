package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import es.upm.miw.apaw_practice.domain.services.filmforum.FilmForumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FilmForumResource.FILMFORUM_FILMS)
public class FilmForumResource {
    public static final String FILMFORUM_FILMS = "/filmforum/film";
    public static final String FIND_BY_NAME = "/name";

    private final FilmForumService filmForumService;

    public FilmForumResource(FilmForumService filmForumService) {
        this.filmForumService = filmForumService;
    }

    @GetMapping(FIND_BY_NAME)
    public FilmForum findByName(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return filmForumService.findByName(name);
    }
}
