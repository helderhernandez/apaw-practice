package es.upm.miw.apaw_practice.domain.services.article;

import es.upm.miw.apaw_practice.domain.models.article.Author;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.AuthorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AuthorService {

    private final AuthorPersistence authorPersistence;

    @Autowired
    public AuthorService(AuthorPersistence authorPersistence) { this.authorPersistence = authorPersistence; }

    public Stream<Author> readAll() { return this.authorPersistence.readAll(); }
}
