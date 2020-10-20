package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.domain.models.library.Librarian;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface LibrarianPersistence {
    Librarian updateName(String id,String name);
    Stream<Librarian> findPhoneByReaderDni(String dni);
}
