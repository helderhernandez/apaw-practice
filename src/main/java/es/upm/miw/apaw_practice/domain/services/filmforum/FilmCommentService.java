package es.upm.miw.apaw_practice.domain.services.filmforum;

import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmCommentPersistence;
import org.springframework.stereotype.Service;

@Service
public class FilmCommentService {

    private FilmCommentPersistence filmCommentPersistence;

    public FilmCommentService(FilmCommentPersistence filmCommentPersistence) {
        this.filmCommentPersistence = filmCommentPersistence;
    }

    public void delete(String id) {
        filmCommentPersistence.delete(id);
    }
}
