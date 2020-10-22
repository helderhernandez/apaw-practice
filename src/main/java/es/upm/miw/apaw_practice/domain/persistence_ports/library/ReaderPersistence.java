package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.domain.models.library.Reader;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ReaderPersistence {
    Reader create(Reader reader);
    Stream<Reader> findNameByISBN(String ISBN);
}
