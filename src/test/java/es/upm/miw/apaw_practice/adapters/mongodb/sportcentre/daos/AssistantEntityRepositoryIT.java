package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AssistantEntityRepositoryIT {

    @Autowired
    private AssistantRepository assistantRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.assistantRepository.findById("104").isPresent());
        AssistantEntity assistant = this.assistantRepository.findById("104").get();
        assertEquals("Garcia", assistant.getLastName());
        assertEquals("Adrian", assistant.getName());
        assertEquals(155555555, assistant.getPhone());
    }

}