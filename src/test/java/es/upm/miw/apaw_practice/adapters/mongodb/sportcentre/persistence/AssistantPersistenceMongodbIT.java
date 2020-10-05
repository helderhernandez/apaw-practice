package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.AssistantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance.AssistantPersistenceMongodb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestConfig
public class AssistantPersistenceMongodbIT {

    @Autowired
    private AssistantPersistenceMongodb assistantPersistenceMongodb;
    @Autowired
    private AssistantRepository assistantRepository;

    @Test
    void testUpdate(){
        AssistantEntity assistantEntity = this.assistantRepository.findById("100").get();
        int assistantPhone = assistantEntity.getPhone();
        assistantEntity.setPhone(123456789);
        AssistantEntity assistantBD = this.assistantRepository.save(assistantEntity);
        assertNotEquals(assistantPhone, assistantBD.getPhone());
        assertEquals(123456789, assistantBD.getPhone());
    }

}
