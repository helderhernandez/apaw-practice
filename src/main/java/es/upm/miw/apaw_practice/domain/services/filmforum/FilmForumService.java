package es.upm.miw.apaw_practice.domain.services.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForumUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmForumPersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmForumService {
    private FilmForumPersistence filmForumPersistence;

    public FilmForumService(FilmForumPersistence filmForumPersistence) {
        this.filmForumPersistence = filmForumPersistence;
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
}
