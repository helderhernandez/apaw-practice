package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForumUpdating;
import es.upm.miw.apaw_practice.domain.services.filmforum.FilmForumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(FilmForumResource.FILMFORUM_FILMS)
public class FilmForumResource {
    public static final String FILMFORUM_FILMS = "/filmforum/films";
    public static final String UPDATE_FILMS = "/audience-range";

    private final FilmForumService filmForumService;

    public FilmForumResource(FilmForumService filmForumService) {
        this.filmForumService = filmForumService;
    }

    @GetMapping
    public FilmForum findByName(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return filmForumService.findByName(name);
    }

    @PatchMapping(UPDATE_FILMS)
    public void updateAudienceRange(@RequestBody List<FilmForumUpdating> updatings) {
        filmForumService.updateFilmAudienceRange(updatings);
    }
}
