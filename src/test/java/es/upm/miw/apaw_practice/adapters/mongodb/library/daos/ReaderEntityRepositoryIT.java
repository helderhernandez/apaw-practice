package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.ReaderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ReaderEntityRepositoryIT {
    @Autowired
    private ReaderRepository readerRepository;

    @Test
    void testFindByDni(){
        assertTrue(this.readerRepository.findByDNI("01648463T").isPresent());
        ReaderEntity reader=this.readerRepository.findByDNI("01648463T").get();
        assertEquals("Ana",reader.getName());
        assertEquals("Woman",reader.getSex());
        assertEquals("695222111",reader.getPhone());
        assertEquals("waldujocnj@gmail.com",reader.getEmail());
    }
}
