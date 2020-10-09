package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class BookEntityRepositoryIT {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void testFindByISBN(){
        assertTrue(this.bookRepository.findByISBN("9787111636623").isPresent());
        BookEntity book=this.bookRepository.findByISBN("9787111636623").get();
        assertEquals("2",book.getId());
        assertEquals("python",book.getTitle());
        assertEquals("Alex",book.getAuthor());
        assertEquals(true,book.getState());
    }
}
