package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmForumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmForumPersistence;
import org.springframework.stereotype.Repository;

@Repository("filmForumPersistence")
public class FilmForumPersistenceMongodb implements FilmForumPersistence {

    FilmForumRepository filmForumRepository;

    public FilmForumPersistenceMongodb(FilmForumRepository filmForumRepository) {
        this.filmForumRepository = filmForumRepository;
    }

    @Override
    public FilmForum findByName(String name) {
        return filmForumRepository.findByName(name)
                .map(FilmForumEntity::toFilmForum)
                .orElseThrow(() -> new NotFoundException("Film not found with name " + name));
    }

    @Override
    public FilmForum update(FilmForum updatedFilm) {
        FilmForumEntity film = filmForumRepository
                .findByName(updatedFilm.getName())
                .orElseThrow(() -> new NotFoundException("Film with name " + updatedFilm.getName() + " not found."));
        film.fromEntity(updatedFilm);
        return filmForumRepository.save(film).toFilmForum();
    }

    @Override
    public FilmForum getFilmFromComment(FilmComment comment) {
        FilmCommentEntity commentEntity = new FilmCommentEntity();
        commentEntity.fromFilmComment(comment);
        FilmForumEntity film = filmForumRepository.findByFilmCommentsContaining(commentEntity)
                .orElseThrow(() -> new NotFoundException("Comment with id " + comment.getId() + " has no film related"));
        return film.toFilmForum();
    }
}