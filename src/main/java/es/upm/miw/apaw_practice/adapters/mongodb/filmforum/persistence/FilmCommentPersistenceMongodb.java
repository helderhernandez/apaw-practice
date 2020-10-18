package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmCommentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmUserEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmUser;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmCommentPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("filmCommentPersistence")
public class FilmCommentPersistenceMongodb implements FilmCommentPersistence {

    private FilmCommentRepository filmCommentRepository;

    public FilmCommentPersistenceMongodb(FilmCommentRepository filmCommentRepository) {
        this.filmCommentRepository = filmCommentRepository;
    }

    @Override
    public void delete(String id) {
        FilmCommentEntity comment = filmCommentRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Comment with id " + id + " not found."));
        filmCommentRepository.delete(comment);
    }

    @Override
    public List<FilmComment> findCommentsByUser(FilmUser user) {
        FilmUserEntity userEntity = new FilmUserEntity();
        userEntity.fromFilmUser(user);
        return filmCommentRepository.findByCommentUser(userEntity).stream()
                .map(FilmCommentEntity::toFilmComment)
                .collect(Collectors.toList());
    }
}
