package es.upm.miw.apaw_practice.adapters.mongodb.filmforum;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmActorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmCommentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmForumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmUserRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmActorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmUserEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

@Service
public class FilmForumSeederService {
    @Autowired
    private FilmForumRepository filmForumRepository;
    @Autowired
    private FilmActorRepository filmActorRepository;
    @Autowired
    private FilmCommentRepository filmCommentRepository;
    @Autowired
    private FilmUserRepository filmUserRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- FilmForum Initial Load -----------");

        FilmUserEntity[] users = {
                new FilmUserEntity("1", "acabezas", "email1@email.com"),
                new FilmUserEntity("2", "jnavalon", "email2@email.com"),
                new FilmUserEntity("3", "mmonforte", "email3@email.com"),
        };
        this.filmUserRepository.saveAll(Arrays.asList(users));

        FilmCommentEntity[] comments = {
                new FilmCommentEntity("1", users[0], "content1", 10, LocalDateTime.of(2020, 10, 7, 19, 0)),
                new FilmCommentEntity("2", users[0], "content2", 60, LocalDateTime.now()),
                new FilmCommentEntity("3", users[1], "content3", 100, LocalDateTime.now()),
                new FilmCommentEntity("4", users[1], "content4", 50, LocalDateTime.now()),
                new FilmCommentEntity("5", users[2], "content5", 100, LocalDateTime.now())
        };
        this.filmCommentRepository.saveAll(Arrays.asList(comments));

        FilmActorEntity[] actors = {
                new FilmActorEntity("1", "actor1", "surname1", 10),
                new FilmActorEntity("2", "actor2", "surname2", 20),
                new FilmActorEntity("3", "actor3", "surname3", 30),
        };
        this.filmActorRepository.saveAll(Arrays.asList(actors));

        FilmForumEntity[] films = {
                new FilmForumEntity("1", Collections.singletonList(actors[0]), Collections.singletonList(comments[0]), "film1", 2021, true, 110, "genre1"),
                new FilmForumEntity("2", Arrays.asList(actors[1], actors[2]), Collections.emptyList(), "film2", 2021, false, 120, "genre2"),
                new FilmForumEntity("3", Collections.singletonList(actors[0]), Arrays.asList(comments[1], comments[2]), "film3", 2023, true, 130, "genre3"),
                new FilmForumEntity("4", Collections.singletonList(actors[0]), Arrays.asList(comments[1], comments[2]), "film4", 2024, true, 140, "genre4")
        };
        this.filmForumRepository.saveAll(Arrays.asList(films));
    }

    public void deleteAll() {
        this.filmForumRepository.deleteAll();
        this.filmCommentRepository.deleteAll();
        this.filmActorRepository.deleteAll();
        this.filmUserRepository.deleteAll();
    }
}
