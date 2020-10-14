package es.upm.miw.apaw_practice.domain.services.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmActorPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmCommentPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmForumPersistence;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmCommentService {

    private FilmCommentPersistence filmCommentPersistence;
    private FilmForumPersistence filmForumPersistence;
    private FilmActorPersistence filmActorPersistence;

    public FilmCommentService(FilmCommentPersistence filmCommentPersistence,
                              FilmForumPersistence filmForumPersistence,
                              FilmActorPersistence filmActorPersistence) {
        this.filmCommentPersistence = filmCommentPersistence;
        this.filmForumPersistence = filmForumPersistence;
        this.filmActorPersistence = filmActorPersistence;
    }

    public void delete(String id) {
        filmCommentPersistence.delete(id);
    }

    public List<String> getContentsOfFilmCommentsFromActorName(String name) {
        List<FilmActor> actors = filmActorPersistence.findByName(name);
        return actors.stream()
                .map(actor -> filmForumPersistence.getFilmsFromActor(actor))
                .flatMap(Collection::stream)
                .flatMap(film -> film.getComments().stream())
                .map(FilmComment::getContent)
                .collect(Collectors.toList());
    }
}
