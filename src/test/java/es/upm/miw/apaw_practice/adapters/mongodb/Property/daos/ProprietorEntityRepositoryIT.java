package es.upm.miw.apaw_practice.adapters.mongodb.Property.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.ProprietorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.ProprietorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ProprietorEntityRepositoryIT {

    @Autowired
    private ProprietorRepository proprietorRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.proprietorRepository.findByDni("35274690B").isPresent());
        ProprietorEntity proprietor = this.proprietorRepository.findByDni("35274690B").get();
        assertEquals("Paloma", proprietor.getName());
        assertEquals("35", proprietor.getAge());
        assertEquals("688128554", proprietor.getPhone());
        assertEquals("paloma@gmail.com", proprietor.getEmail());
    }
}
