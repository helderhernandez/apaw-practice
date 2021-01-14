package es.upm.miw.apaw_practice.adapters.mongodb.studio.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.ConsumerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ConsumerEntityRepositoryIT {
    @Autowired
    private ConsumerRepository consumerRepository;

    @Test
    void testFindByEmail() {
        assertTrue(this.consumerRepository.findByEmail("consumer1@test.com").isPresent());
        ConsumerEntity consumerEntity = this.consumerRepository.findByEmail("consumer1@test.com").get();
        assertEquals("Wilma York", consumerEntity.getName());
        assertEquals("123456789", consumerEntity.getPhone());
        assertEquals("Japanese Traditional", consumerEntity.getFavoriteStyle());
    }

}
