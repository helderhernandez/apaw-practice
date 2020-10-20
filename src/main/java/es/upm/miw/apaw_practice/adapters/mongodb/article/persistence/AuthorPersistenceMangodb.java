package es.upm.miw.apaw_practice.adapters.mongodb.article.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.AuthorRepository;
import es.upm.miw.apaw_practice.domain.models.article.Author;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.AuthorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("authorPersistence")
public class AuthorPersistenceMangodb implements AuthorPersistence {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorPersistenceMangodb(AuthorRepository authorRepository) { this.authorRepository = authorRepository; }

    @Override
    public Stream<Author> readAll(){
        return this.authorRepository.findAll().stream()
                .map(authorEntity -> authorEntity.toAuthor());
    }
}
