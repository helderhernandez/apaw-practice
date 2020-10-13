package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.domain.services.filmforum.FilmCommentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FilmCommentResource.COMMENT)
public class FilmCommentResource {

    public static final String COMMENT = "/filmforum/comments";
    public static final String ID_ID = "/{id}";

    private FilmCommentService filmCommentService;

    public FilmCommentResource(FilmCommentService filmCommentService) {
        this.filmCommentService = filmCommentService;
    }

    @DeleteMapping(ID_ID)
    public void deleteComment(@PathVariable String id) {
        filmCommentService.delete(id);
    }
}
