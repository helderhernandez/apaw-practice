package es.upm.miw.apaw_practice.adapters.filmforum;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmActorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmCommentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmForumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmUserRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FilmForumSeederService {
    @Autowired private FilmForumRepository filmForumRepository;
    @Autowired private FilmActorRepository filmActorRepository;
    @Autowired private FilmCommentRepository filmCommentRepository;
    @Autowired private FilmUserRepository filmUserRepository;

    public void seedDatabase() {
        FilmUserEntity[] users = {
                new FilmUserEntity("1", "acabezas", "email1@email.com"),
                new FilmUserEntity("2", "jnavalon", "email2@email.com"),
                new FilmUserEntity("3", "mmonforte", "email3@email.com"),
        };
        this.filmUserRepository.saveAll(Arrays.asList(users));

    }

}
