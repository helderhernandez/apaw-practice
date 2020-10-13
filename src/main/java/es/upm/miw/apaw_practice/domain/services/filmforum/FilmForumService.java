package es.upm.miw.apaw_practice.domain.services.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForumUpdating;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmUser;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmCommentPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmForumPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmUserPersistence;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmForumService {
    private FilmForumPersistence filmForumPersistence;
    private FilmUserPersistence filmUserPersistence;
    private FilmCommentPersistence filmCommentPersistence;

    public FilmForumService(FilmForumPersistence filmForumPersistence,
                            FilmUserPersistence filmUserPersistence,
                            FilmCommentPersistence filmCommentPersistence) {
        this.filmForumPersistence = filmForumPersistence;
        this.filmUserPersistence = filmUserPersistence;
        this.filmCommentPersistence = filmCommentPersistence;
    }

    public FilmForum findByName(String name) {
        return filmForumPersistence.findByName(name);
    }

    public void updateFilmAudienceRange(List<FilmForumUpdating> filmsToUpdate) {
        filmsToUpdate.stream().map(filmToUpdate -> {
            FilmForum film = filmForumPersistence.findByName(filmToUpdate.getName());
            film.setForAllPublic(filmToUpdate.isForAllPublic());
            return film;
        }).forEach(film -> filmForumPersistence.update(film));
    }

    public List<String> getFilmsIdCommentedByUser(String username) {
        FilmUser user = filmUserPersistence.findByUsername(username);
        List<FilmComment> commentOfUser = filmCommentPersistence.findCommentsByUser(user);
        return commentOfUser.stream()
                .map(comment -> filmForumPersistence.getFilmFromComment(comment))
                .map(FilmForum::getId)
                .collect(Collectors.toList());
    }
}
