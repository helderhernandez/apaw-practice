package es.upm.miw.apaw_practice.domain.persistence_ports.library;

import es.upm.miw.apaw_practice.domain.models.library.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPersistence {
    Book updateBookPrice(Book book);
    Book readByISBN(String ISBN);
}
