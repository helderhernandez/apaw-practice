package es.upm.miw.apaw_practice.adapters.mongodb.studio.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.StudioSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.TattoistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.TattoistEntity;
import es.upm.miw.apaw_practice.domain.persistence_ports.studio.TattoistPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class TattoistPersistenceMongodbIT {

    @Autowired
    private TattoistPersistence tattoistPersistence;

    @Autowired
    private StudioSeederService studioSeederService;

    @Autowired
    private TattoistRepository tattoistRepository;

    @Test
    void testUpdateNickname() {
        TattoistEntity tattoistEntity = this.tattoistRepository
                .findByNickname("JC")
                .get();
        assertNotNull(tattoistEntity.getId());
        this.tattoistPersistence.updateNickname(tattoistEntity.getId(), "BOB");
        assertEquals(
                "BOB",
                tattoistRepository.findByNickname("BOB").get().getNickname()
        );
        studioSeederService.deleteAll();
        studioSeederService.seedDatabase();
    }
}
