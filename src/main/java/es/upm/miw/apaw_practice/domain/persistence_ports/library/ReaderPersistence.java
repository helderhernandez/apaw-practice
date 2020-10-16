package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.domain.models.library.Reader;
import es.upm.miw.apaw_practice.domain.models.library.ReaderCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderPersistence {
    Reader create(ReaderCreation readerCreation);
}
