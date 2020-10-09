package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;
@TestConfig
public class LibrarianEntityRepositoryIT {
    @Autowired
    private LibrarianRepository librarianRepository;
    @Test
    void testCreateAndRead(){
        assertTrue(this.librarianRepository.findAll().stream()
                .anyMatch(librarian ->
                        "1".equals(librarian.getId())&&
                                "Isabel".equals(librarian.getName())&&
                                "695333666".equals(librarian.getPhone())&&
                                2==librarian.getOrderEntity().size()));
    }
}
