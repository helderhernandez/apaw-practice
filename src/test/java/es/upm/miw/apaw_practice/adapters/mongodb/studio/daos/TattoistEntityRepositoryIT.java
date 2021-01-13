package es.upm.miw.apaw_practice.adapters.mongodb.studio.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.TattoistEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TattoistEntityRepositoryIT {
    @Autowired
    private TattoistRepository tattoistRepository;

    @Test
    void testFindByNickname() {
        assertTrue(this.tattoistRepository.findByNickname("Ghinko").isPresent());
        TattoistEntity tattoistEntity = this.tattoistRepository.findByNickname("Ghinko").get();
        assertEquals("email1@test.com", tattoistEntity.getEmail());
        assertEquals("Blackwork", tattoistEntity.getMainStyle());
        assertEquals("Ghinko", tattoistEntity.getNickname());
        assertEquals("Maneki Neko", tattoistEntity.getName());
        assertEquals("2221026542", tattoistEntity.getPhone());
    }
}
