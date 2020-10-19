package es.upm.miw.apaw_practice.domain.persistence_ports.article;

import es.upm.miw.apaw_practice.domain.models.article.Author;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AuthorPersistence {
    Stream<Author> readAll();
}
