package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.ChefRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.kitchen.Chef;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ChefPersistenceMongodbIT {

    @Autowired
    private ChefPersistenceMongodb chefPersistence;

    @Autowired
    private ChefRepository chefRepository;

    @Test
    void testUpdate() {
        Chef chefBD = this.chefRepository.findByDni("44411122F")
                .orElseThrow(() -> new NotFoundException("Chef dni: 44411122F"))
                .toChef();
        chefBD.setRecipesFinished(4);
        chefBD = this.chefPersistence.updateRecipesFinished(chefBD.getDni(), chefBD.getRecipesFinished());
        assertEquals(4, chefBD.getRecipesFinished());
    }
}
